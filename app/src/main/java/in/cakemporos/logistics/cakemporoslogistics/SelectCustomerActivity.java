package in.cakemporos.logistics.cakemporoslogistics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import in.cakemporos.logistics.cakemporoslogistics.models.Customer;
import in.cakemporos.logistics.cakemporoslogistics.models.Locality;
import in.cakemporos.logistics.cakemporoslogistics.models.Order;

/**
 * Created by maitr on 31-Jul-16.
 */
public class SelectCustomerActivity extends AppCompatActivity {
    private List<Order> list;
    private Order[] orders;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_customer);

        //Test Order
        list=new ArrayList<Order>();
        Locality l1=new Locality();
        l1.setName("Navagaon");
        Customer c1=new Customer();
        c1.setFirstName("Maitreya");
        c1.setLastName("Save");
        c1.setLocality(l1);
        c1.set_id("1");
        c1.setAddress("A-2, Suyog Society, Navagaon, Dahisar(West), Mumbai - 400068");
        c1.setPhone(9619794793l);
        Order o1=new Order();
        o1.setCustomer(c1);
        list.add(o1);
        //
        Locality l2=new Locality();
        l2.setName("Kandarpada");
        Customer c2=new Customer();
        c2.setFirstName("Roger");
        c2.setLastName("Cores");
        c2.setLocality(l2);
        c2.set_id("2");
        c2.setAddress("XYZ, Dahisar");
        c2.setPhone(9876543210l);
        Order o2=new Order();
        o2.setCustomer(c2);
        list.add(o2);
        //
        Locality l3=new Locality();
        l3.setName("Thane");
        Customer c3=new Customer();
        c3.setFirstName("Nikhil");
        c3.setLastName("Shirsath");
        c3.setLocality(l3);
        c3.set_id("3");
        c3.setAddress("QWERTY, Thane");
        c3.setPhone(1111111111l);
        Order o3=new Order();
        o3.setCustomer(c3);
        list.add(o3);
        //Convert List to Array
        orders= (Order[]) list.toArray(new Order[list.size()]);
        //
        //adapter for list view
       // ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_select_customer, list);
        //ListView listView = (ListView) findViewById(R.id.customer_list);
        //listView.setAdapter(adapter);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(orders);
        mRecyclerView.setAdapter(mAdapter);

    }
}
