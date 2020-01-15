package cn.george.mylearn

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object{
        private const val TAG="MainActivity-"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host:NavHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = host.navController
        initBottomNavigationView(bNavView,navController)
    }

    private fun initBottomNavigationView(bottomNavigationView:BottomNavigationView, navController:NavController){
        bottomNavigationView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener{
                _, destination, _ ->
            when(destination.id){
                R.id.meFragment-> Log.d(TAG,"我的")
                else -> Log.d(TAG,"其他")
            }
        }

    }
}
