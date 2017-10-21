package com.example.jitu.reterofit_tutorial;

/**
 * Created by jitu on 5/8/2017.
 */



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("mynews/z_get_news_all.php")
    Call<newsresponse> getTopRatedMovies(@Query("page") String apiKey,@Query("catagory") String catagory);

}
