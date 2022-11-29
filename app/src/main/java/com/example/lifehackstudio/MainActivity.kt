package com.example.lifehackstudio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lifehackstudio.domain.Controller
import com.example.lifehackstudio.domain.model.data.DataCompanyListItem
import com.example.lifehackstudio.domain.model.data.detail.DataCompanyDetailItem
import com.example.lifehackstudio.ui.detail.DetailFragment
import com.example.lifehackstudio.ui.main.MainFragment

class MainActivity : AppCompatActivity(), Controller {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun openSecondFragment(companyData: DataCompanyListItem) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_activity_container, DetailFragment.newInstance(companyData))
            .commit()
    }
}
