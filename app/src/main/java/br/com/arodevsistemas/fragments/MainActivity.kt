package br.com.arodevsistemas.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import br.com.arodevsistemas.fragments.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity :
    AppCompatActivity(),
    View.OnClickListener,
    BottomNavigationView.OnNavigationItemSelectedListener{

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    /*
    private lateinit var btnHome: Button
    private lateinit var btnConsole: Button
    private lateinit var btnGame: Button
    */
    private lateinit var homeFragment: HomeFragment
    private lateinit var consoleFragment: ConsoleFragment
    private lateinit var gameFragment: GameFragment

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        /*
        btnHome = binding.btnHome
        btnHome.setOnClickListener(this)
        btnConsole = binding.btnConsole
        btnConsole.setOnClickListener(this)
        btnGame = binding.btnGame
        btnGame.setOnClickListener(this)
        */
        homeFragment = HomeFragment()
        consoleFragment = ConsoleFragment()
        gameFragment = GameFragment()

        bottomNavigationView = binding.bnMain
        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        setFragment(homeFragment)
    }

    private fun setFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_main, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View) {
        /*
        when(v.id){
            binding.btnHome.id -> {
                setFragment(homeFragment)
            }
            binding.btnConsole.id -> {
                setFragment(consoleFragment)
            }
            binding.btnGame.id -> {
                setFragment(gameFragment)
            }
        }
        */
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mn_home -> {
                setFragment(homeFragment)
            }
            R.id.mn_console -> {
                setFragment(consoleFragment)
            }
            R.id.mn_game -> {
                setFragment(gameFragment)
            }
        }
        return true
    }

}