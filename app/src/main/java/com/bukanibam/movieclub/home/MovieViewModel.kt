package com.bukanibam.movieclub.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.bukanibam.movieclub.core.domain.usecase.MovieUseCase

class MovieViewModel(movieUseCase: MovieUseCase): ViewModel() {
    val movies = movieUseCase.getAllMovies().asLiveData()
    val tvShows = movieUseCase.getAllTvShows().asLiveData()
}