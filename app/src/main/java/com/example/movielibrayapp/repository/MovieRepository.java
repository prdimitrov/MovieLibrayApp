package com.example.movielibrayapp.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movielibrayapp.R;
import com.example.movielibrayapp.model.Movie;
import com.example.movielibrayapp.model.Result;
import com.example.movielibrayapp.serviceapi.MovieApiService;
import com.example.movielibrayapp.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class is used to abstract the data source details and
 * provide a clean API for the ViewModel to
 * fetch and manage the data.
 */
public class MovieRepository {
    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MovieApiService movieApiService = RetrofitInstance.getService();
        Call<Result> call = movieApiService
                .getPopularMovies(application.getApplicationContext().getString(R.string.api_key));

        // Perform network request in background thread and
        // handle the response on the main (UI) thread
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                // Success
                Result result = response.body();

                if (result != null && result.getResults() != null) {
                    movies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(movies);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });

        return mutableLiveData;
    }
}
