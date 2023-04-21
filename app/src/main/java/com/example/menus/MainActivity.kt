package com.example.menus

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(textView)


    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {

        menu?.add(3,201,3,"Red")
        menu?.add(3,202,2,"Green")
        menu?.add(3,203,1,"Blue")
        menu?.setHeaderTitle("Select Color to change")

        super.onCreateContextMenu(menu, v, menuInfo)
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            201 -> (textView.setTextColor(Color.RED))
            202 -> (textView.setTextColor(Color.GREEN))
            203 -> (textView.setTextColor(Color.BLUE))
        }
            return super.onContextItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(1,1001,1,"HOME")
        menu?.add(1,1002,2,"GREEN")
        menu?.add(1,1003,3,"BLUE")
        var smenu = menu?.addSubMenu("Gender")
        smenu?.add(2,11,1,"Male")?.setChecked(false)
        smenu?.add(2,12,2,"Female")?.setChecked(false)
        smenu?.setGroupCheckable(2,true,true)

        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

    when(item.itemId)
    {
       1001 -> startActivity(Intent(this,home::class.java))
        1002 -> (tvinfo.setTextColor(Color.GREEN))
        1003 -> (tvinfo.setTextColor(Color.BLUE))
        11 -> (textView.setText("You are Male"))
        12-> (textView.setText("You are Female"))

    }

        return super.onOptionsItemSelected(item)
    }
}