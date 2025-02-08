package com.example.firstkotlinpractice.ui.views.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.firstkotlinpractice.R
import com.example.firstkotlinpractice.data.repositories.UserRepository
import com.example.firstkotlinpractice.databinding.ActivityAppBinding
import com.example.firstkotlinpractice.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private lateinit var navController: NavController
    private val loginViewModel: LoginViewModel by viewModels()//PARA TEST, BORRAR DSP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        //setupActionBarWithNavController(navController)

        val bottomNavBar = binding.bottomNavigationView
        bottomNavBar.setupWithNavController(navController)

        /*
        val navHostFragment = binding.navHostFragment
        val navController = navHostFragment.findNavController()
        val bottomNavBar = binding.bottomNavigationView
        bottomNavBar.setupWithNavController(navController)
        */

        //val tvUser = binding.tvUser
        /*
        * BUG: La primera vez que se llega a esta Activity, el user no se recupera correctamente, sino que
        * devuelve una version previa. Lo debuggee por arriba y parece estar seteando bien el valor, asumo
        * que el problema sera algo de la asincronia, o el como recupero el valor.
        */
        /*
        loginViewModel.user.observe(this, Observer { user ->
            tvUser.text = user
        })
        loginViewModel.getUser()*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}