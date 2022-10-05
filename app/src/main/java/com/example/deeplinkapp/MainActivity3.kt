package com.example.deeplinkapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        findViewById<Button>(R.id.button2).setOnClickListener(View.OnClickListener {
            dynamicShortcut()
        })

    }

    fun dynamicShortcut(){
        val shortcut = ShortcutInfoCompat.Builder(this, "dynamic")
            .setShortLabel("Website")
            .setLongLabel("Open the website")
            .setIcon(IconCompat.createWithResource(this, R.drawable.ic_launcher_foreground))
            .setIntent(
                Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            )
            .build()

        ShortcutManagerCompat.pushDynamicShortcut(this, shortcut)
    }
}