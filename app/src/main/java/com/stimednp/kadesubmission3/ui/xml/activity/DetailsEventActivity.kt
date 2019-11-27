package com.stimednp.kadesubmission3.ui.xml.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.stimednp.kadesubmission3.R
import com.stimednp.kadesubmission3.model.EventsLeagues
import com.stimednp.kadesubmission3.model.TeamsBadge
import com.stimednp.kadesubmission3.util.CustomesUI
import com.stimednp.kadesubmission3.util.invisible
import com.stimednp.kadesubmission3.util.visible
import kotlinx.android.synthetic.main.activity_details_event.*
import kotlinx.android.synthetic.main.item_header_statis.*
import kotlinx.android.synthetic.main.items_body_statis.*

class DetailsEventActivity : AppCompatActivity() {
    companion object {
        val EXTRA_DATA_EVENT: String = "extra_data_event"
        val EXTRA_BADGEH: String = "extra_badge_h"
        val EXTRA_BADGEA: String = "extra_badge_A"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_event)
        val events: EventsLeagues? = intent.getParcelableExtra(EXTRA_DATA_EVENT)
        val badgeH: TeamsBadge? = intent.getParcelableExtra(EXTRA_BADGEH)
        val badgeA: TeamsBadge? = intent.getParcelableExtra(EXTRA_BADGEA)

        setToolbar()
        setData(events!!, badgeH!!, badgeA!!)
    }

    private fun setToolbar() {
        setSupportActionBar(tbar_statis)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        tbar_statis.setTitle(R.string.app_detail_match)
        tbar_statis.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
        tbar_statis.setNavigationOnClickListener { finish() }
    }

    private fun setData(ev: EventsLeagues, badgeH: TeamsBadge, badgeA: TeamsBadge) {
        val urlimgH = "${badgeH.strTeamBadge}/preview"
        val urlimgA = "${badgeA.strTeamBadge}/preview"
        val dateChange = CustomesUI.changeDateFormat(ev.dateEvent!!, ev.strTime!!)

        //header
        ev.intHomeScore ?: ev.intAwayScore ?: tv_fts.invisible()
        tv_hscore.text = ev.intHomeScore?.toString() ?: "-"
        tv_ascore.text = ev.intAwayScore?.toString() ?: "-"
        tv_hname.text = ev.strHomeTeam
        tv_aname.text = ev.strAwayTeam

        //load image
        Picasso.get().load(urlimgH).into(imgv_hteam, object : Callback {
            override fun onSuccess() {
                prog_hteam.invisible()
            }

            override fun onError(e: Exception?) {
                prog_hteam.visible()
            }
        })
        Picasso.get().load(urlimgA).into(imgv_ateam, object : Callback {
            override fun onSuccess() {
                prog_ateam.invisible()
            }

            override fun onError(e: Exception?) {
                prog_ateam.visible()
            }
        })
        Picasso.get().load(urlimgH).into(img_badgeHb, object : Callback {
            override fun onSuccess() {
                prog_hsteam.invisible()
            }

            override fun onError(e: Exception?) {
                prog_hteam.visible()
            }
        })
        Picasso.get().load(urlimgA).into(img_badgeAb, object : Callback {
            override fun onSuccess() {
                prog_asteam.invisible()
            }

            override fun onError(e: Exception?) {
                prog_ateam.visible()
            }
        })

        //body
        tv_vs.text = ev.strEvent ?: "-"
        tv_date_time.text = dateChange
        tv_tnameh.text = ev.strHomeTeam ?: "-"
        tv_tnamea.text = ev.strAwayTeam ?: "-"
        tv_formationh.text = ev.strHomeFormation ?: "-"
        tv_formationa.text = ev.strAwayFormation ?: "-"
        tv_goalh.text = ev.intHomeScore?.toString() ?: "-"
        tv_goala.text = ev.intAwayScore?.toString() ?: "-"
        tv_shoth.text = ev.intHomeShots?.toString() ?: "-"
        tv_shota.text = ev.intAwayShots?.toString() ?: "-"
        tv_credh.text = ev.strHomeRedCards?.replace(";", "\n") ?: "-"
        tv_creda.text = ev.strAwayRedCards?.replace(";", "\n") ?: "-"
        tv_cyellowh.text = ev.strHomeYellowCards?.replace(";", "\n") ?: "-"
        tv_cyellowa.text = ev.strAwayYellowCards?.replace(";", "\n") ?: "-"
        tv_gkeeperh.text = ev.strHomeLineupGoalkeeper?.replace("; ", "\n") ?: "-"
        tv_gkeepera.text = ev.strAwayLineupGoalkeeper?.replace("; ", "\n") ?: "-"
        tv_defenseh.text = ev.strHomeLineupDefense?.replace("; ", "\n") ?: "-"
        tv_defensea.text = ev.strAwayLineupDefense?.replace("; ", "\n") ?: "-"
        tv_midh.text = ev.strHomeLineupMidfield?.replace("; ", "\n") ?: "-"
        tv_mida.text = ev.strAwayLineupMidfield?.replace("; ", "\n") ?: "-"
        tv_forwardh.text = ev.strHomeLineupForward?.replace("; ", "\n") ?: "-"
        tv_forwarda.text = ev.strAwayLineupForward?.replace("; ", "\n") ?: "-"
        tv_subtih.text = ev.strHomeLineupSubstitutes?.replace("; ", "\n") ?: "-"
        tv_subtia.text = ev.strAwayLineupSubstitutes?.replace("; ", "\n") ?: "-"
        tv_dgoalh.text = ev.strHomeGoalDetails?.replace(";", "\n") ?: "-"
        tv_dgoala.text = ev.strAwayGoalDetails?.replace(";", "\n") ?: "-"
    }
}
