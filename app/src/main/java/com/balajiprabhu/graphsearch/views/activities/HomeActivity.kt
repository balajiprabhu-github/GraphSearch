package com.balajiprabhu.graphsearch.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.balajiprabhu.graphsearch.R

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val personImageView : ImageView = findViewById(R.id.personImageView)
        val organisationImageView : ImageView = findViewById(R.id.organisationImageView)

        personImageView.setOnClickListener {
            val intent = Intent(this,PersonListActivity::class.java)
            startActivity(intent)
        }

        organisationImageView.setOnClickListener {
            val intent = Intent(this,OrganisationListActivity::class.java)
            startActivity(intent)
        }
    }
}