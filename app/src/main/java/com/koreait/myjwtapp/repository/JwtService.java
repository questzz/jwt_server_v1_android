package com.koreait.myjwtapp.repository;

import com.koreait.myjwtapp.BuildConfig;
import com.koreait.myjwtapp.repository.models.request.ReqLogin;
import com.koreait.myjwtapp.repository.models.request.ReqSignup;
import com.koreait.myjwtapp.repository.models.response.ResLogin;
import com.koreait.myjwtapp.repository.models.response.ResPost;
import com.koreait.myjwtapp.repository.models.response.ResSignup;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JwtService {

    @POST("login")
    Call<ResLogin> getLogin(@Body ReqLogin reqLogin);

    @POST("join")
    Call<ResSignup> saveMember(@Body ReqSignup reqSignup);

    @GET("post")
    Call<ResPost> getPostList(@Header("Authorization") String token);

    // ipconfig / ifconfig
    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://192.168.2.101:8080/")
            .baseUrl("http://lalacoding.site/")
            .client(httpLoggingInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    static OkHttpClient httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        if (BuildConfig.DEBUG) {
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        return new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }


}
