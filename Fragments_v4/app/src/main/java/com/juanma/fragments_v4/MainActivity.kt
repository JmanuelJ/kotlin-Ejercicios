package com.juanma.fragments_v4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.juanma.fragments_v4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentManager: FragmentManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       initView()
       setOnClickButtons()
    }

   private fun initView(){
       binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)
   }

   private fun setOnClickButtons(){
        binding.apply {
            buttomFragment1.setOnClickListener{
                goToFragment(Fragment1())
            }
            buttomFragment2.setOnClickListener{
                goToFragment(Fragment2())
            }
        }
    }

    private fun goToFragment(fragment: Fragment){
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

}