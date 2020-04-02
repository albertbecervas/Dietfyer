package com.abecerra.base.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abecerra.base.R

abstract class BaseActivity : AppCompatActivity(), BaseView {

    abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        findViewById<ProgressBar>(R.id.loading_progress_bar)?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        findViewById<ProgressBar>(R.id.loading_progress_bar)?.visibility = View.GONE
    }
}