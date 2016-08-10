package in.cakemporos.logistics.cakemporoslogistics.web.endpoints;

import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.Error;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by roger on 10/8/16.
 */
public interface OrderEndPoint {
    @GET("user/test")
    public Call<Response> test(@Header("x-access-token") String accessToken);
}
