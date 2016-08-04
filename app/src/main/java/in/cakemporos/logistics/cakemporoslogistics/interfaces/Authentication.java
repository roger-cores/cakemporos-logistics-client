package in.cakemporos.logistics.cakemporoslogistics.interfaces;

import in.cakemporos.logistics.cakemporoslogistics.models.Login;
import in.cakemporos.logistics.cakemporoslogistics.models.LoginResponse;
import in.cakemporos.logistics.cakemporoslogistics.models.Response;
import in.cakemporos.logistics.cakemporoslogistics.models.ValidateRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by maitr on 30-Jul-16.
 */
public interface Authentication {
    @POST("user/oauth/token")
    Call<LoginResponse> login(@Body Login login);
    @POST("user/validate-token")
    Call<Response> validateToken(@Body ValidateRequest validateRequest);
}
