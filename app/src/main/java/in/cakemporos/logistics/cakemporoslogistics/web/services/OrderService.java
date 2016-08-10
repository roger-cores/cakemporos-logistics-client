package in.cakemporos.logistics.cakemporoslogistics.web.services;

import android.app.Activity;

import in.cakemporos.logistics.cakemporoslogistics.R;
import in.cakemporos.logistics.cakemporoslogistics.dbase.Key;
import in.cakemporos.logistics.cakemporoslogistics.dbase.Utility;
import in.cakemporos.logistics.cakemporoslogistics.events.WebServiceCallDoneEvent;
import in.cakemporos.logistics.cakemporoslogistics.web.endpoints.AuthenticationEndPoint;
import in.cakemporos.logistics.cakemporoslogistics.web.endpoints.OrderEndPoint;
import in.cakemporos.logistics.cakemporoslogistics.web.webmodels.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by roger on 10/8/16.
 */
public class OrderService {
    public static void test(final Activity activity,
                            final Retrofit retrofit,
                            final OrderEndPoint orderEndPoint,
                            final WebServiceCallDoneEvent event){

        final Call<Response> testCall = orderEndPoint.test(Utility.getKey(activity).getAccess());
        testCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                event.onDone(R.string.success, 0);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                event.onContingencyError(0);
            }
        });
    }
}
