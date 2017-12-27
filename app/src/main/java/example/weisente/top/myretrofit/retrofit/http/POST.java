package example.weisente.top.myretrofit.retrofit.http;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by san on 2017/12/27.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public  @interface POST {
    String value();
}
