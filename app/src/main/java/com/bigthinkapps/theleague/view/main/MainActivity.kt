package com.bigthinkapps.theleague.view.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bigthinkapps.theleague.R
import com.bigthinkapps.theleague.databinding.ActivityMainBinding
import com.bigthinkapps.theleague.utils.AppConstants
import com.bigthinkapps.theleague.view.adapter.TeamAdapter
import com.bigthinkapps.theleague.viewmodel.MainViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val teamAdapter by lazy {
        TeamAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recyclerTeam.adapter = teamAdapter
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        title = AppConstants.SPANISH_LEAGUE
        viewModel.getTeamsByLeague(AppConstants.SPANISH_LEAGUE)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val typeLeague = when (item!!.itemId) {
            R.id.action_league_1 -> AppConstants.SPANISH_LEAGUE
            R.id.action_league_2 -> AppConstants.ENGLISH_LEAGUE
            R.id.action_league_3 -> AppConstants.ITALIAN_LEAGUE
            else -> AppConstants.SPANISH_LEAGUE
        }

        title = typeLeague
        viewModel.getTeamsByLeague(typeLeague)

        return super.onOptionsItemSelected(item)
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }
}
