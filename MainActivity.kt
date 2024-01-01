package com.coder.behzod.bottomnavigationv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.coder.behzod.bottomnavigationv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainController()

    }

    private fun mainController() {
        binding.bottomNavigationView.background = null
        navigationBetweenFragments(HomeFragment())
        setBottomNavigation()
    }
    val int = 1
    private fun setBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.menu_home->{
                    navigationBetweenFragments(HomeFragment())
                }
                R.id.menu_favorite->{
                    navigationBetweenFragments(FavoriteFragment())
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun navigationBetweenFragments(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
    }
}