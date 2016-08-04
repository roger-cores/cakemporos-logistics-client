package in.cakemporos.logistics.cakemporoslogistics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by maitr on 29-Jul-16.
 */
public class HomeActivity extends AppCompatActivity {
    private View book_delivery,rate_card,order_history,my_account,refer_baker,app_ver;
    private Context ctx_home=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //get views
        book_delivery= findViewById(R.id.grid_1);
        rate_card= findViewById(R.id.grid_2);
        order_history= findViewById(R.id.grid_3);
        my_account= findViewById(R.id.grid_4);
        refer_baker= findViewById(R.id.grid_5);
        app_ver= findViewById(R.id.grid_6);

        //set onlClicks
        book_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,BookDeliveryActivity.class);
                startActivity(intent_book);
            }
        });
        rate_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,RateCardActivity.class);
                startActivity(intent_book);
            }
        });
        order_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,RateCardActivity.class);
                startActivity(intent_book);
            }
        });
        my_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,RateCardActivity.class);
                startActivity(intent_book);
            }
        });
        refer_baker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,RateCardActivity.class);
                startActivity(intent_book);
            }
        });
        app_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_book=new Intent(ctx_home,RateCardActivity.class);
                startActivity(intent_book);
            }
        });
    }
}
