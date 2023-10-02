package com.bukanibam.movieclub.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bukanibam.movieclub.core.data.Resource
import com.bukanibam.movieclub.core.ui.MovieAdapter
import com.bukanibam.movieclub.databinding.FragmentTvShowBinding
import com.bukanibam.movieclub.detail.DetailMovieActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {
    private val viewModel:MovieViewModel by viewModel()
    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.onCLick = { selectedItem ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedItem)
                startActivity(intent)
            }

            viewModel.tvShows.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    when(movie) {
                        is Resource.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.tvError.visibility = View.GONE
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.tvError.visibility = View.VISIBLE
                        }
                        is Resource.Success -> {
                            binding.tvError.visibility = View.GONE
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                            Log.d("MOVIE", movie.data.toString())
                        }
                    }
                }
            }

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

        }
    }
}