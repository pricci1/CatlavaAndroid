package cl.uandes.catloversapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cl.uandes.catloversapp.R
import cl.uandes.catloversapp.databinding.ActivityCatloverBinding
import cl.uandes.catloversapp.data.model.Users
import com.google.android.material.bottomnavigation.BottomNavigationView

var isLoggedIn = false
val users = Users.createUserList()

class CatLoverActivity : AppCompatActivity() {

  private lateinit var binding: ActivityCatloverBinding
  private lateinit var navigationController: NavController
  private lateinit var bottomNavigationView: BottomNavigationView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityCatloverBinding.inflate(layoutInflater)
    setContentView(binding.root)

    val navHost: NavHost = (
        supportFragmentManager.findFragmentById(R.id.nav_host_activity_main)
        ) as NavHost
    navigationController = navHost.navController

    bottomNavigationView = binding.bottomNavigationView
    bottomNavigationView.setupWithNavController(navigationController)

    val appBarConfiguration = AppBarConfiguration(
      setOf(R.id.catlover_navigation, R.id.signin_navigation)
    )

    setupActionBarWithNavController(navigationController, appBarConfiguration)

    if (!isLoggedIn) {
      navigationController.navigate(R.id.signin_navigation)
      bottomNavigationView.visibility = View.GONE
    }
  }
}
