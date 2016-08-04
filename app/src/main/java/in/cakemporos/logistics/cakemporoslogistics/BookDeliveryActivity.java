package in.cakemporos.logistics.cakemporoslogistics;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import in.cakemporos.logistics.cakemporoslogistics.interfaces.OrderService;
import in.cakemporos.logistics.cakemporoslogistics.models.Customer;
import in.cakemporos.logistics.cakemporoslogistics.models.Locality;
import in.cakemporos.logistics.cakemporoslogistics.models.LoginResponse;
import in.cakemporos.logistics.cakemporoslogistics.models.Order;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maitr on 31-Jul-16.
 */
public class BookDeliveryActivity extends AppCompatActivity {
    private Spinner cake_type,weight_of_cake;
    private Button confirm_booking,select_existing_customer;
    private ImageButton home;
    private EditText firstName,lastName,phone,altPhone,sublocality,address,cost,dropAltPhone,pickUpDate,pickupTime,dropDate;

    private Customer customer;
    private Order order;
    private Locality locality;

    private Retrofit retrofit;

    private Context ctx_book_delivery=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_delivery);
        //find views
        cake_type= (Spinner) findViewById(R.id.spinner_cake_type);
        weight_of_cake=(Spinner) findViewById(R.id.spinner_weight_of_cake);
        select_existing_customer=(Button)findViewById(R.id.button_select_existing_customer);
        confirm_booking=(Button)findViewById(R.id.button_confirm_booking);
        home=(ImageButton)findViewById(R.id.home_img_button_book_delivery);
        firstName=(EditText)findViewById(R.id.et_first_name_drop_details);
        lastName=(EditText)findViewById(R.id.et_last_name_drop_details);
        phone=(EditText)findViewById(R.id.et_phone_no_drop_details);
        altPhone=(EditText)findViewById(R.id.et_alternative_phone_drop_details);
        sublocality=(EditText)findViewById(R.id.et_sub_locality_drop_details);
        address=(EditText)findViewById(R.id.et_address_drop_details);
        cost=(EditText)findViewById(R.id.et_cost_of_cake_product_details);
        pickUpDate=(EditText)findViewById(R.id.et_pickup_date_pickup_details);
        pickupTime=(EditText)findViewById(R.id.et_pickup_time_pickup_details);
        //
        String[] items_cake_type = new String[]{"Normal","Photo","Customized"};
        ArrayAdapter<String> adapter_cake_type = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items_cake_type);
        cake_type.setAdapter(adapter_cake_type);
        //
        String[] items_weight = new String[]{"0.5 Kg","1 Kg","1.5 Kg","2 Kg"};
        ArrayAdapter<String> adapter_weight = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items_weight);
        weight_of_cake.setAdapter(adapter_weight);

        //button onClicks
        select_existing_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_select_existing_customer=new Intent(ctx_book_delivery,SelectCustomerActivity.class);
                startActivity(intent_select_existing_customer);
            }
        });
        //
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        confirm_booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locality=new Locality();
                customer=new Customer();
                order=new Order();
                //
                locality.set_id("579df74edf6d425f21603bec");
                customer.setLocality(locality);
                customer.setAddress(address.getText().toString());
                customer.setFirstName(firstName.getText().toString());
                customer.setLastName(lastName.getText().toString());
                customer.setPhone(Long.parseLong(phone.getText().toString()));
                //
                order.setLocality(locality);
                order.setCustomer(customer);
                order.setAddress(customer.getAddress());
                order.setCakeType(cake_type.getSelectedItem().toString());
                order.setCost(Integer.parseInt(cost.getText().toString()));
                order.setAltPhone(Long.parseLong(altPhone.getText().toString()));
                order.setPickUpDate(pickUpDate.getText()+" "+pickupTime.getText().toString());
                order.setDropDate("12/01/2020 03:03:33");
                order.setWeight(weight_of_cake.getSelectedItem().toString());
                order.setDropAltPhone(Long.parseLong(altPhone.getText().toString()));

                OrderService orderService = retrofit.create(OrderService.class);
                Call<Order> call =  orderService.createOrder(order);

                call.enqueue(new Callback<Order>() {
                    @Override
                    public void onResponse(Call<Order> call, Response<Order> response) {
                        Toast.makeText(ctx_book_delivery,"Order Created",Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Order> call, Throwable t) {
                        Toast.makeText(ctx_book_delivery,"Failed to create",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        //Web Services
        retrofit=new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
