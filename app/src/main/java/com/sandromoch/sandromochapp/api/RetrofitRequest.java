package com.sandromoch.sandromochapp.api;


import com.sandromoch.sandromochapp.models.monument.Memorials;
import com.sandromoch.sandromochapp.models.monument.MonumentResponse;
import com.sandromoch.sandromochapp.util.Const;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;


/**
 * Responsible for creating Retrofit Requests
 */
public class RetrofitRequest {

    private static final String TAG = RetrofitRequest.class.getSimpleName();

    public static final int TIMEOUT = 60;

    private FunOneApi api;

    public RetrofitRequest() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .client(createHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(FunOneApi.class);

    }

    private OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(TIMEOUT, TimeUnit.SECONDS);
        builder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
      //  builder.addInterceptor(createLoggingInterceptor());
        return builder.build();
    }

//    private HttpLoggingInterceptor createLoggingInterceptor() {
//        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
//        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        return loggingInterceptor;
//    }


    public interface FunOneApi {

        @GET("monuments/ ")
        Call<MonumentResponse> getMonuments();

        @GET("memorials/")
        Call<Memorials> getMemorials();
    }

    /**********************************************************************************************/
    /************************************** Api Calls *********************************************/
    /**********************************************************************************************/

    public void getMonuments(Callback<MonumentResponse> callBack){
        api.getMonuments().enqueue(callBack);
    }
    public void getMemorials(Callback<Memorials> callBack){
        api.getMemorials().enqueue(callBack);
    }


}
