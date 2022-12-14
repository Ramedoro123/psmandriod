package com.example.myapplication.com.example.whm

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.KeyEvent
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityMain2Binding
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem
import android.widget.Toast
import android.R
import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.whm.ui.revertpolist.RevertPolistFragment
import java.lang.Exception


class MainActivity2 : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding
    var usertype: String = ""
    var menu: MenuItem? = null
    var navigationView: NavigationView? = null
    private var StatusD: Int = 1
    private var StatusR: Int = 3
    private var StatusS: Int = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        var EmpAutoId = preferences.getString("EmpAutoId", "")
        var EmpTypeNo = preferences.getString("EmpTypeNo", "")
        var Empname = preferences.getString("Empname", "")
        var Username = preferences.getString("Username", "")

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        usertype = EmpTypeNo.toString()
        val nav_Menu: Menu = navView.menu
        if (usertype == "5") {
            nav_Menu.findItem(com.example.myapplication.R.id.nav_productlist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_orderlist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_assignorder).isVisible = true
        }else if (usertype == "2") {
            nav_Menu.findItem(com.example.myapplication.R.id.nav_product).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_addbar).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_productlist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_orderlist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_assignorder).isVisible = true

        }
        else if (usertype == "9") {
            nav_Menu.findItem(com.example.myapplication.R.id.nav_product).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_addbar).isVisible = true

        }
        else if (usertype == "11") {
            nav_Menu.findItem(com.example.myapplication.R.id.nav_product).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_addbar).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_inventory).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_drfatpolist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_submitpolist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_revertpolist).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_internalpos).isVisible = true
        }
        else if (usertype=="14")
        {
            nav_Menu.findItem(com.example.myapplication.R.id.nav_Processed_order_list_Picker).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_Packed_order_list_Picker).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_Add_On_order_list_Picker).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_Add_OnPacked_order_list_Picker).isVisible = true
            nav_Menu.findItem(com.example.myapplication.R.id.nav_Update_Location).isVisible = true
        }
        val navController =findNavController(com.example.myapplication.R.id.nav_host_fragment_content_main)
        val hview = navView.getHeaderView(0)
        val textViewName = hview.findViewById(com.example.myapplication.R.id.emptype) as TextView
        val usename = hview.findViewById(com.example.myapplication.R.id.username) as TextView
        textViewName.text =preferences.getString("Empname", "") + " [" + preferences.getString("LName", "") + "]"
        usename.text = preferences.getString("Username", "")
        appBarConfiguration = AppBarConfiguration(
            setOf(
                com.example.myapplication.R.id.nav_home,
                com.example.myapplication.R.id.nav_slideshow,
                com.example.myapplication.R.id.nav_product,
                com.example.myapplication.R.id.nav_addbar,
                com.example.myapplication.R.id.nav_productlist,
                com.example.myapplication.R.id.nav_assignorder,
                com.example.myapplication.R.id.nav_orderlist,
                com.example.myapplication.R.id.nav_inventory,
                com.example.myapplication.R.id.nav_bindpolist,
                com.example.myapplication.R.id.nav_drfatpolist,
                com.example.myapplication.R.id.nav_submitpolist,
                com.example.myapplication.R.id.nav_revertpolist,
                com.example.myapplication.R.id.nav_internalpos,
                com.example.myapplication.R.id.nav_info,
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //  navigationView = findViewById<View>(com.example.myapplication.R.id.nav_view) as NavigationView
        // setupDrawerContent(navigationView!!);

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(com.example.myapplication.R.menu.main_activity2, menu)

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController =
            findNavController(com.example.myapplication.R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onKeyDown(key_code: Int, key_event: KeyEvent?): Boolean {
        if (key_code == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(key_code, key_event)
            return false
        }
        return true
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true

        }
    }

    fun selectDrawerItem(menuItem: MenuItem) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(this@MainActivity2)
        val editor = preferences.edit()
        when (menuItem.itemId) {
            //  com.example.myapplication.R.id.fragment_podraftlist -> RevertPolistFragment::class.java
//             com.example.myapplication.R.id.nav_drfatpolist -> {
//                 editor.putInt("StatusD", StatusD)
//                 editor.apply()
//                 val intent = Intent(this, RevertPolistFragment::class.java)
//                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                 startActivity(intent)
//                 Toast.makeText(this@MainActivity2, "Draft List", Toast.LENGTH_LONG).show()
//                 true
//             }
//             com.example.myapplication.R.id.nav_submitpolist -> {
//
//                 Toast.makeText(this@MainActivity2, "Submit List", Toast.LENGTH_LONG).show()
//                 true
//             }
//             com.example.myapplication.R.id.nav_revertpolist -> {
//
//                 Toast.makeText(this@MainActivity2, "Revert List", Toast.LENGTH_LONG).show()
//                 true
//             }
//
//             else -> RevertPolistFragment::class.java
        }


    }


}







