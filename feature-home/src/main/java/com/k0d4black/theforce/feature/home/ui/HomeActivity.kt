/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.k0d4black.theforce.feature.home.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.k0d4black.theforce.feature.home.R
import com.k0d4black.theforce.feature.home.databinding.ActivityHomeBinding
import com.k0d4black.theforce.shared.android.AppScreen
import com.k0d4black.theforce.shared.android.extensions.navigateToFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    // region Members

    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding

    // endregion

    // region Android Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpBottomNavigationView()
        bindViewModel()
        setupDefaultScreen()
    }

    // endregion

    // region OnNavigationItemSelectedListener

    override fun onNavigationItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.favorites -> {
                homeViewModel.navigateToFavorites()
                true
            }
            R.id.search -> {
                homeViewModel.navigateToSearch()
                true
            }
            R.id.settings -> {
                homeViewModel.navigateToSettings()
                true
            }
            else -> false
        }

    // endregion

    // region Private Api

    private fun bindViewModel() {
        homeViewModel.onFavoritesClicked().observe(this) {
            navigateToFragment(appScreen = AppScreen.FAVORITES) { favoritesFragment ->
                replace(R.id.fragment_container, favoritesFragment)
            }
        }

        homeViewModel.onSearchClicked().observe(this) {
            navigateToFragment(appScreen = AppScreen.CHARACTER_SEARCH) { searchFragment ->
                replace(R.id.fragment_container, searchFragment)
            }
        }

        homeViewModel.onSettingsClicked().observe(this) {
            navigateToFragment(appScreen = AppScreen.SETTINGS) { settingsFragment ->
                replace(R.id.fragment_container, settingsFragment)
            }
        }
    }

    private fun setUpBottomNavigationView() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.home_bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }


    private fun setupDefaultScreen() {
        navigateToFragment(appScreen = AppScreen.CHARACTER_SEARCH) { searchFragment ->
            add(R.id.fragment_container, searchFragment)
        }
    }

    // endregion
}