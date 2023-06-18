package com.myapp.catatuang

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.myapp.catatuang.databinding.ActivityMainBinding
import com.myapp.catatuang.fragments.AccountFragment
import com.myapp.catatuang.fragments.GoalsFragment
import com.myapp.catatuang.fragments.TransactionFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transactionFragment = TransactionFragment()
        val goalsFragment = GoalsFragment()
        val accountFragment = AccountFragment()

        binding.chipAppBar.setItemSelected(R.id.ic_transaction, true)
        makeCurrentFragment(transactionFragment)

        binding.chipAppBar.setOnItemSelectedListener { itemId ->
            when (itemId) {
                R.id.ic_transaction -> makeCurrentFragment(transactionFragment)
                R.id.ic_goals -> makeCurrentFragment(goalsFragment)
                R.id.ic_account -> makeCurrentFragment(accountFragment)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, InsertionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }
    }
}
