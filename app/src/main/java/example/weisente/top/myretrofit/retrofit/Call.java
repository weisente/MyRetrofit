package example.weisente.top.myretrofit.retrofit;

/**
 * Created by san on 2017/12/27.
 */

public interface Call<T> {
    void enqueue(Callback<T> callback);
}
