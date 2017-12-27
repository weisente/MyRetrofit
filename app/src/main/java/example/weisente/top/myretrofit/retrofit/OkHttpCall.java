package example.weisente.top.myretrofit.retrofit;

import java.io.IOException;

/**
 * Created by san on 2017/12/27.
 */

public class OkHttpCall<T> implements Call<T> {

    final ServiceMethod serviceMethod;
    final Object[] args;
    public OkHttpCall(ServiceMethod serviceMethod, Object[] args) {
        this.serviceMethod = serviceMethod;
        this.args = args;
    }



    @Override
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call = serviceMethod.createNewCall(args);
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                if(callback != null){
                    callback.onFailure(OkHttpCall.this,e);
                }
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Response rResponse = new Response();
                rResponse.body = serviceMethod.parseBody(response.body());

                if(callback != null){
                    callback.onResponse(OkHttpCall.this,rResponse);
                }
            }
        });
    }
}
