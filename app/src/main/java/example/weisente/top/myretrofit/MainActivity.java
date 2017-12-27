package example.weisente.top.myretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import example.weisente.top.myretrofit.retrofit.Call;
import example.weisente.top.myretrofit.retrofit.Callback;
import example.weisente.top.myretrofit.retrofit.Response;
import example.weisente.top.myretrofit.retrofit.RetrofitClient;
import example.weisente.top.myretrofit.simple.UserLoginResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RetrofitClient.getServiceApi().userLogin("Darren", "940223")
                .enqueue(new Callback<UserLoginResult>() {
                    @Override
                    public void onResponse(Call<UserLoginResult> call, Response<UserLoginResult> response) {
//                        Log.e("TAG",response.body.toString());
                        Log.d("tag123","onResponse");
                    }

                    @Override
                    public void onFailure(Call<UserLoginResult> call, Throwable t) {
                        Log.d("tag123","onFailure");
                    }
                });
    }
}
