package com.stvayush.recipebook.core

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.stvayush.recipebook.R
import kotlinx.android.synthetic.main.activity_base.*

/**
 * Authored by s-ayush2903 on 16/7/20
 */
abstract class BaseActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun setContentView(layoutResID: Int) {
        val constraintLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout =
            constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        progressBar = constraintLayout.findViewById(R.id.progress_bar)
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)

        //setting the recyclerView
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

    }

    fun showProgressBar(visible: Boolean) {
        progressBar!!.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}
