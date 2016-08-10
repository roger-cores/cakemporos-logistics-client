package in.cakemporos.logistics.cakemporoslogistics.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import in.cakemporos.logistics.cakemporoslogistics.R;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.entities.Customer;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.entities.Locality;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maitr on 31-Jul-16.
 */
public class SelectCustomerActivity extends AppCompatActivity {
    private ListView listView;

    List<Customer> customers;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_customer);
        customers = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setDateFormat("dd-MM-yyyy HH:mm:ss")
                .create();

        retrofit=new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        listView = (ListView) findViewById(R.id.listView);

        dummyDate();

    }

    public void dummyDate(){
        Customer customer = new Customer();
        customer.setFirstName("Roger");
        customer.setLastName("Cores");
        customer.setPhone(8655814592L);
        customer.setLocality(new Locality());
        customer.getLocality().setName("Kandarpada");
        customers.add(customer);

        customer = new Customer();
        customer.setFirstName("Maitreya");
        customer.setLastName("Lallan");
        customer.setPhone(8655814592L);
        customer.setLocality(new Locality());
        customer.getLocality().setName("Junagaav");
        customers.add(customer);

        customer = new Customer();
        customer.setFirstName("Niks");
        customer.setLastName("Cool");
        customer.setPhone(8655814592L);
        customer.setLocality(new Locality());
        customer.getLocality().setName("Thane");
        customers.add(customer);

        CustomerAdapter adapter = new CustomerAdapter(this, R.layout.list_select_customer);
        adapter.setCustomers(customers);
        listView.setAdapter(adapter);


    }


    class CustomerAdapter extends ArrayAdapter<Customer>{

        List<Customer> customers;

        public CustomerAdapter(Context context, int resource) {
            super(context, resource);
        }

        public void setCustomers(List<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public int getCount() {
            if(customers!=null) return customers.size();
            else return 0;
        }

        @Override
        public Customer getItem(int position) {
            if(customers!=null) return customers.get(position);
            else return null;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.list_select_customer, null);
            }

            TextView name, phone, location;
            Customer customer = getItem(position);
            name = (TextView) convertView.findViewById(R.id.firstName);
            phone = (TextView) convertView.findViewById(R.id.phone);
            location = (TextView) convertView.findViewById(R.id.location);

            name.setText(customer.firstName + " " + customer.getLastName());
            phone.setText(customer.getPhone().toString());
            location.setText(customer.getLocality().getName());


            return convertView;
        }
    }


}
