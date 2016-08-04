package in.cakemporos.logistics.cakemporoslogistics.interfaces;

import java.util.List;

import in.cakemporos.logistics.cakemporoslogistics.models.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by maitr on 31-Jul-16.
 */
public interface OrderService {
    @POST("user/baker/order")
    Call<Order> createOrder(@Body Order order);
    @GET("user/baker/order")
    Call<List<Order>> getMyOrders();
}
