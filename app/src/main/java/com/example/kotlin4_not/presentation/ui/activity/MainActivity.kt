package com.example.kotlin4_not.presentation.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.kotlin4_not.R
import com.example.noteapp.utils.PreferencesHelper

class MainActivity : AppCompatActivity() {
    private val preferencesHelper: PreferencesHelper by lazy {
        PreferencesHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fcv_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // Если поворота экрана ни разу не было
        if (savedInstanceState == null) {
            val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

            if (preferencesHelper.isShownOnBoard) {
                navGraph.setStartDestination(R.id.homeFragment)
            } else {
                navGraph.setStartDestination(R.id.viewPagerFragment)
            }

            navController.graph = navGraph
        }
    }
}