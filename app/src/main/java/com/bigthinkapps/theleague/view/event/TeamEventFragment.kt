package com.bigthinkapps.theleague.view.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bigthinkapps.theleague.R
import com.bigthinkapps.theleague.data.TeamEvent
import kotlinx.android.synthetic.main.fragment_event.*

class TeamEventFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val teamEvent = it.getSerializable(DataExtra.EXTRA_TEAM_EVENT) as TeamEvent
            labelEventName.text = teamEvent.event
            labelEventDate.text = teamEvent.date
        }
    }

    companion object {

        fun newInstance(teamEvent: TeamEvent): TeamEventFragment {
            val fragment = TeamEventFragment()
            val bundle = Bundle()
            bundle.putSerializable(DataExtra.EXTRA_TEAM_EVENT, teamEvent)
            fragment.arguments = bundle
            return fragment
        }
    }

    object DataExtra {
        const val EXTRA_TEAM_EVENT = "extra_team_event"
    }
}