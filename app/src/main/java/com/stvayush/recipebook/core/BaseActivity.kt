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
//added to create the recyclerView
private lateinit var LinearLayoutManager: LinearLayoutManager

abstract class BaseActivity : AppCompatActivity() {
    var progressBar: ProgressBar? = null
    override fun setContentView(layoutResID: Int) {
        val constraintLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout
        val frameLayout =
            constraintLayout.findViewById<FrameLayout>(R.id.activity_content)
        progressBar = constraintLayout.findViewById(R.id.progress_bar)
        layoutInflater.inflate(layoutResID, frameLayout, true)
        super.setContentView(constraintLayout)

        LinearLayoutManager = LinearLayoutManager(this)  //added for creating RecyclerView
        recyclerView.layoutManager = LinearLayoutManager
    }

    fun showProgressBar(visible: Boolean) {
        progressBar!!.visibility = if (visible) View.VISIBLE else View.INVISIBLE
    }
}
