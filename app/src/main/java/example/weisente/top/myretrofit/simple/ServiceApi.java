package example.weisente.top.myretrofit.simple;

import example.weisente.top.myretrofit.retrofit.Call;
import example.weisente.top.myretrofit.retrofit.http.GET;
import example.weisente.top.myretrofit.retrofit.http.Query;

/**
 * Created by san on 2017/12/27.
 */

public interface ServiceApi {
    @GET("LoginServlet")// 登录接口 GET(相对路径)
    Call<UserLoginResult> userLogin(
            // @Query(后台需要解析的字段)
            @Query("userName") String userName,
            @Query("password") String userPwd);
}
