package com.example.movielibrayapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movielibrayapp.model.Movie;
import com.example.movielibrayapp.repository.MovieRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MovieRepository(application);
    }

    // Live Data
    public LiveData<List<Movie>> getAllMovies() {
        return repository.getMutableLiveData();
    }
}
