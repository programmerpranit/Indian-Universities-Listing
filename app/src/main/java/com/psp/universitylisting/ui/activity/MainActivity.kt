package com.psp.universitylisting.ui.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.psp.universitylisting.R
import com.psp.universitylisting.data.University
import com.psp.universitylisting.ui.UniversityViewModel
import com.psp.universitylisting.ui.adapter.IClickListener
import com.psp.universitylisting.ui.adapter.UniversityListAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), IClickListener {

    private val viewModel: UniversityViewModel by viewModels()

    // http://universities.hipolabs.com/search?country=India

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = UniversityListAdapter(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        viewModel.universities.observe(this){ universities ->
            adapter.submitList(universities)
        }
    }

    override fun viewClicked(university: University) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(university.web_pages[0]))
    }
}
