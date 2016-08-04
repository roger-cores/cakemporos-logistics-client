package in.cakemporos.logistics.cakemporoslogistics;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import in.cakemporos.logistics.cakemporoslogistics.models.Order;

/**
 * Created by maitr on 31-Jul-16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Order[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView customer_name_cv,customer_phone_cv,customer_address_cv,customer_locality_cv;
        public View card;
        public ViewHolder(View v) {
            super(v);
            card=v;
            customer_name_cv = (TextView) v.findViewById(R.id.customer_first_name_cv);
            customer_phone_cv = (TextView) v.findViewById(R.id.customer_phone_cv);
            customer_address_cv = (TextView) v.findViewById(R.id.customer_address_cv);
            customer_locality_cv = (TextView) v.findViewById(R.id.customer_locality_cv);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Order[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_select_customer, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String customer_name=mDataset[position].getCustomer().getFirstName()+" "+mDataset[position].getCustomer().getLastName();
        String customer_phone=mDataset[position].getCustomer().getPhone()+"";
        holder.customer_name_cv.setText(customer_name);
        holder.customer_phone_cv.setText(customer_phone);
        holder.customer_address_cv.setText(mDataset[position].getCustomer().getAddress());
        holder.customer_locality_cv.setText(mDataset[position].getCustomer().getLocality().getName());
        //onclick
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String customer_id=mDataset[position].getCustomer().get_id();
                Log.d("I","onClick: "+customer_id);
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}