package com.example.movielibrayapp.serviceapi;

import com.example.movielibrayapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * This service interface will act as a bridge
 * between the app and the API
 */
public interface MovieApiService {

    @GET("movie/popular")
    Call<Result> getPopularMovies(@Query("api_key") String apiKey);
}
