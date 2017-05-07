package com.example.jitu.reterofit_tutorial;

/**
 * Created by jitu on 5/8/2017.
 */



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("news/z_get_news_ent.php")
    Call<newsresponse> getTopRatedMovies(@Query("page") String apiKey);
   /*@GET("news/z_get_news_ent.php")
   Call<newsresponse> getTopRatedMovies(@Query("page") String apiKey);*/

    /*@GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*/
   /* @GET("news/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("page") String apiKey);*/
}
