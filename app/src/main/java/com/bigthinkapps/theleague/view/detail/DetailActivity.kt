package com.bigthinkapps.theleague.view.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.bigthinkapps.theleague.R
import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.databinding.ActivityDetailBinding
import com.bigthinkapps.theleague.view.adapter.EventPagerAdapter
import com.bigthinkapps.theleague.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        binding.viewModel = viewModel
        binding.viewPagerEvent.adapter = EventPagerAdapter(supportFragmentManager)
        binding.lifecycleOwner = this
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        intent.extras?.run {
            val team = getSerializable(DataExtra.EXTRA_TEAM_DATA) as Team
            title = team.name
            binding.team = team
            viewModel.getTeamEvents(team.id)
        }

        binding.indicatorPager.setViewPager(binding.viewPagerEvent)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    object DataExtra {
        const val EXTRA_TEAM_DATA = "extra_team_data"
    }

    override fun onPause() {
        super.onPause()
        viewModel.onPause()
    }
}