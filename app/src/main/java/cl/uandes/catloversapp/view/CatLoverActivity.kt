package cl.uandes.catloversapp.view

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.ActivityCatloverBinding
import cl.uandes.catloversapp.model.Users
import com.google.android.material.bottomnavigation.BottomNavigationView


var isLoggedIn = false

class CatLoverActivity : AppCompatActivity() {

  private var _binding: ActivityCatloverBinding? = null
  private val binding get() = _binding!!
  private lateinit var navigationController: NavController
  private lateinit var bottomNavigationView: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    _binding = ActivityCatloverBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHost: NavHost = (
        supportFragmentManager.findFragmentById(R.id.nav_host_activity_main)
        ) as NavHost
    navigationController = navHost.navController

    bottomNavigationView = binding.bottomNavigationView

    val appBarConfiguration = AppBarConfiguration(
      setOf(R.id.catlover_navigation)
    )

    setupActionBarWithNavController(navigationController, appBarConfiguration)
    bottomNavigationView.setupWithNavController(navigationController)

    if (!isLoggedIn) {
      navigationController.navigate(R.id.loginFragment)
      bottomNavigationView.visibility = View.INVISIBLE
    }
  }

  override fun onResume() {
    super.onResume()
  }
}
