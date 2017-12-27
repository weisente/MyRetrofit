package example.weisente.top.myretrofit.retrofit;

/**
 * Created by san on 2017/12/27.
 */

public interface Callback<T> {
    void onResponse(Call<T> call, Response<T> response);
    void onFailure(Call<T> call, Throwable t);
}
