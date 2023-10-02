package com.bukanibam.movieclub.search

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bukanibam.movieclub.core.data.Resource
import com.bukanibam.movieclub.core.ui.MovieAdapter
import com.bukanibam.movieclub.databinding.FragmentSearchBinding
import com.bukanibam.movieclub.detail.DetailMovieActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@FlowPreview
@ExperimentalCoroutinesApi
class SearchFragment : Fragment(){
    private val viewModel: SearchViewModel by viewModel()
    private lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @OptIn(FlowPreview::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.radioGroup.setOnCheckedChangeListener { _, _ ->
            viewModel.isMovieChecked.value = binding.rbMovie.isChecked
        }

        binding.edSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                lifecycleScope.launch {
                    viewModel.queryChannel.value = s.toString()
                }
            }
        })

        if (activity != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.onCLick = { selectedItem ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_DATA, selectedItem)
                startActivity(intent)
            }

            viewModel.searchResult.observe(viewLifecycleOwner) { movie ->
                if (movie != null) {
                    when(movie) {
                        is Resource.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            Log.d("MOVIE", "Loading")
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(activity, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                            Log.d("MOVIE", "error")
                        }
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                            Log.d("MOVIE", movie.data.toString())
                        }
                    }
                }
            }

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }


        }
    }

}