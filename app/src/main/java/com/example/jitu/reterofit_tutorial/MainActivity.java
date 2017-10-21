package com.example.jitu.reterofit_tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


    // TODO - insert your themoviedb.org API KEY here
    //private final static String API_KEY = "f8a29713551517de92be525a79762b6c";
    private final static String API_KEY = "2";
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        retrocall();
       /* ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<newsresponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<newsresponse>() {
            @Override
            public void onResponse(Call<newsresponse> call, Response<newsresponse> response) {
                int statusCode = response.code();
                List<news> movies = response.body().getArticles();
                //recyclerView.setAdapter(new RecycleViewAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                adapter = new CardAdapter1(movies, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<newsresponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });*/
    }

    public void retrocall() {


        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<newsresponse> call = apiService.getTopRatedMovies("2","news_cricket");
        call.enqueue(new Callback<newsresponse>() {
            @Override
            public void onResponse(Call<newsresponse> call, Response<newsresponse> response) {
                int statusCode = response.code();
                List<news> movies = response.body().getArticles();
                for(int i=0;i<movies.size();i++){
                    System.out.println("lll: "+movies.get(i).getImagelink());
                }
                //recyclerView.setAdapter(new RecycleViewAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                adapter = new CardAdapter1(movies, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<newsresponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}
