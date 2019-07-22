
package com.pertamina.spbucare.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.pertamina.spbucare.R
import com.pertamina.spbucare.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val topDestination = setOf(R.id.dashboard_dest,
            R.id.profile_dest,
            R.id.notification_dest)
        navController = findNavController(R.id.main_nav_fragment)
        appBarConfiguration = AppBarConfiguration(topDestination)
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.mainBottomNav.setupWithNavController(navController)
        OnDestinationChanged()
    }


    private fun OnDestinationChanged() =
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val destId = destination.id
            if (destId == R.id.dashboard_dest ||destId == R.id.profile_dest || destId == R.id.notification_dest) {
                supportActionBar?.title = ""
                supportActionBar?.show()
                binding.mainBottomNav.visibility = View.VISIBLE
            }else {
                supportActionBar?.hide()
                supportActionBar?.title = ""
                supportActionBar?.setHomeAsUpIndicator(R.drawable.left)
                binding.mainBottomNav.visibility = View.GONE
            }
        }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
