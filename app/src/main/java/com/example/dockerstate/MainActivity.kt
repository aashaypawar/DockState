package com.example.dockerstate

import android.content.Intent
import android.content.Intent.EXTRA_DOCK_STATE
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.btnCheck)
        btn.setOnClickListener {
            val dockStatus: Intent? = IntentFilter(Intent.ACTION_DOCK_EVENT).let { ifilter ->
                applicationContext.registerReceiver(null, ifilter)
            }
            val dockState: Int = dockStatus?.getIntExtra(EXTRA_DOCK_STATE, -1) ?: -1
            val isDocked: Boolean = dockState != Intent.EXTRA_DOCK_STATE_UNDOCKED

            if(isDocked){
                Toast.makeText(applicationContext,"Docked",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Not Docked",Toast.LENGTH_SHORT).show()
            }
        }
    }
}