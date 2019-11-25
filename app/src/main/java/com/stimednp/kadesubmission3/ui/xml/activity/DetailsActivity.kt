package com.stimednp.kadesubmission3.ui.xml.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.stimednp.kadesubmission3.R
import com.stimednp.kadesubmission3.model.Leagues
import com.stimednp.kadesubmission3.ui.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.item_header.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DetailsActivity : AppCompatActivity(), View.OnClickListener {
    companion object {

        val EXTRA_DATA: String = "extra_data"
        var items: Leagues? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        items = intent.getParcelableExtra(EXTRA_DATA)
        initClick()
        setToolbar()
        showData()
        setupViewPager()
    }

    private fun initClick() {
        tv_web.setOnClickListener(this)
        tv_fb.setOnClickListener(this)
        tv_twit.setOnClickListener(this)
        tv_yt.setOnClickListener(this)
    }

    private fun showData() {
        val url = "${items?.strBadge}/preview"
        tv_name_league.text = items?.strLeague
        tv_desc_league.text = items?.strDescriptionEN
        Picasso.get().load(url).into(img_badgeHb)
    }

    private fun setToolbar() {
        val toolbar = htab_toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar.setTitle(R.string.app_detail_leagues)
        toolbar.setNavigationIcon(R.drawable.ic_keyboard_backspace_black_24dp)
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun setupViewPager() {
        htab_viewpager.adapter = ViewPagerAdapter(supportFragmentManager, this)
        htab_tablayout.setupWithViewPager(htab_viewpager)
        htab_tablayout.getTabAt(0)?.setIcon(R.drawable.ic_event_complete_black)
        htab_tablayout.getTabAt(1)?.setIcon(R.drawable.ic_event_next_black)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_search) {
            startActivity<SearchActivity>()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(id: View?) {
        when(id){
            tv_web -> goUri(items?.strWebsite)
            tv_fb -> goUri(items?.strFacebook)
            tv_twit -> goUri(items?.strTwitter)
            tv_yt -> goUri(items?.strYoutube)
        }
    }

    fun goUri(url: String?) {
        if (url == "") {
            toast(getString(R.string.str_nourl))
        } else {
            try {
                val uri = Uri.parse("http://$url")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                Handler().postDelayed({ startActivity(intent) }, 100)
            } catch (e: Exception) {
                toast("Something Error uri : $url")
            }
        }
    }
}
