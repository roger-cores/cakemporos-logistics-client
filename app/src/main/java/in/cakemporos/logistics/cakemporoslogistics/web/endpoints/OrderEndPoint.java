package in.cakemporos.logistics.cakemporoslogistics.web.endpoints;

import java.util.List;

import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.Response;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.entities.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by roger on 10/8/16.
 */
public interface OrderEndPoint {
    @GET("user/baker/order")
    public Call<List<Order>> getMyOrders(@Header("x-access-token") String accessToken);

    @POST("user/baker/order")
    public Call<Order> createOrder(@Header("x-access-token") String accessToken, @Body Order order);
}
