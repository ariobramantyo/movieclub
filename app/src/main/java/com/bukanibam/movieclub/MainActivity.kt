package com.bukanibam.movieclub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bukanibam.movieclub.databinding.ActivityMainBinding
import com.bukanibam.movieclub.home.HomeFragment
import com.bukanibam.movieclub.search.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.backgroundTintList = null

        loadFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.searchFragment -> {
                    loadFragment(SearchFragment())
                    true
                }
                R.id.favoriteFragment -> {
                    loadFavoriteFragment()
                    true
                }
                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }
    }

    private fun loadFavoriteFragment() {
        val fragment: Fragment? =
            try {
                Class.forName("com.bukanibam.movieclub.favorite.favorite.FavoriteFragment").newInstance() as Fragment
            } catch (e: Exception) {
                Toast.makeText(this, "Module not found", Toast.LENGTH_SHORT).show()
                null
            }
        if (fragment != null) {
            loadFragment(fragment)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}