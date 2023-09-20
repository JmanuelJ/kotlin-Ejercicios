package com.juanma.floatingmenuexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.juanma.floatingmenuexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initView()

        registerForContextMenu(binding.btnOpenMenu)
    }

    private fun initView(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.floating_context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this, "Option1 Salsa", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Option2 Bachata", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Option3 Merengue", Toast.LENGTH_SHORT).show()
            R.id.item4 -> Toast.makeText(this, "Option4 Kizomba", Toast.LENGTH_SHORT).show()
        }
        return super.onContextItemSelected(item)
    }
}