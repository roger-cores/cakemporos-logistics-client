package in.cakemporos.logistics.cakemporoslogistics.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.List;

import in.cakemporos.logistics.cakemporoslogistics.R;
import in.cakemporos.logistics.cakemporoslogistics.dbase.Utility;
import in.cakemporos.logistics.cakemporoslogistics.events.OnWebServiceCallDoneEventListener;
import in.cakemporos.logistics.cakemporoslogistics.utilities.Factory;
import in.cakemporos.logistics.cakemporoslogistics.web.endpoints.AuthenticationEndPoint;
import in.cakemporos.logistics.cakemporoslogistics.web.endpoints.OrderEndPoint;
import in.cakemporos.logistics.cakemporoslogistics.web.services.AuthenticationService;
import in.cakemporos.logistics.cakemporoslogistics.web.services.OrderService;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.entities.Order;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.enums.OrderStatus;
import retrofit2.Retrofit;

import static in.cakemporos.logistics.cakemporoslogistics.utilities.FlashMessage.displayContingencyError;
import static in.cakemporos.logistics.cakemporoslogistics.utilities.FlashMessage.displayError;
import static in.cakemporos.logistics.cakemporoslogistics.utilities.FlashMessage.displayMessage;

/**
 * Created by bloss on 14/8/16.
 */
public class OrderHistoryActivity extends AppCompatActivity implements OnWebServiceCallDoneEventListener{
    private Order[] orders;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Context ctx=this;
    private ImageButton home;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        //
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view_order_history);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // specify an adapter (see also next example)
        mAdapter = new OrderAdapter(orders);
        mRecyclerView.setAdapter(mAdapter);

        retrofit = Factory.createClient(getString(R.string.base_url));

        OrderEndPoint endPoint = retrofit.create(OrderEndPoint.class);
        OrderService.getMyOrders(this, retrofit, endPoint, this);
        //
        home= (ImageButton) findViewById(R.id.home_img_button_order_history);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //
        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, final int position) {
                // TODO Handle item click
                ImageButton ok_oh= (ImageButton) view.findViewById(R.id.change_order_status_oh);
                ImageButton cancel_oh=(ImageButton)view.findViewById(R.id.cancel_order_oh);
                // Ok
                ok_oh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                        builder.setTitle("Confirm Status Change");
                        builder.setMessage("Are you sure you want to DISPATCH this order?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                OrderEndPoint endPoint = retrofit.create(OrderEndPoint.class);
                                OrderService.shipOrder(OrderHistoryActivity.this, retrofit, endPoint, new OnWebServiceCallDoneEventListener() {
                                    @Override
                                    public void onDone(int message_id, int code, Object... args) {
                                        //successful
                                        orders[position].setStatus(OrderStatus.DISP);
                                        mAdapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onContingencyError(int code) {
                                        displayContingencyError(OrderHistoryActivity.this, 0);
                                    }

                                    @Override
                                    public void onError(int message_id, int code, String... args) {
                                        displayError(OrderHistoryActivity.this, message_id, Snackbar.LENGTH_LONG);
                                    }
                                }, orders[position].getId());

                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing
                                dialog.dismiss();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });
                //cancel
                cancel_oh.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                        builder.setTitle("Confirm Status Change");
                        builder.setMessage("Are you sure you want to CANCEL this order?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                OrderEndPoint endPoint = retrofit.create(OrderEndPoint.class);
                                OrderService.cancelOrder(OrderHistoryActivity.this, retrofit, endPoint, new OnWebServiceCallDoneEventListener() {
                                    @Override
                                    public void onDone(int message_id, int code, Object... args) {
                                        //successful
                                        orders[position].setStatus(OrderStatus.CAN);
                                        mAdapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onContingencyError(int code) {
                                        displayContingencyError(OrderHistoryActivity.this, 0);
                                    }

                                    @Override
                                    public void onError(int message_id, int code, String... args) {
                                        displayError(OrderHistoryActivity.this, message_id, Snackbar.LENGTH_LONG);
                                    }
                                }, orders[position].getId());


                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing
                                dialog.dismiss();
                            }
                        });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                });
            }
        }));


    }

    @Override
    public void onDone(int message_id, int code, Object... args) {
        displayMessage(this, "Success", Snackbar.LENGTH_LONG);

        List<Order> orderlist = ((List<Order>) args[0]);
        if(orderlist!=null){
            //here goes orders  \o/
            //                   |
            //                  / \
            orders=orderlist.toArray(new Order[orderlist.size()]);
            ((OrderAdapter)mAdapter).setmDataset(orders);
            mAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onContingencyError(int code) {
        displayContingencyError(this, 0);
    }

    @Override
    public void onError(int message_id, int code, String... args) {
        displayError(this, message_id, Snackbar.LENGTH_LONG);
    }
}
