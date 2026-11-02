package com.bsassistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var windowManager: WindowManager
    private var panel: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(Color.rgb(25, 35, 65))

        val title = TextView(this)
        title.text = "BS ASSISTANT"
        title.textSize = 24f
        title.setTextColor(Color.WHITE)
        layout.addView(title)

        val info = TextView(this)
        info.text = """
            Witaj w BS Assistant!

            Wykrywanie mapy: w przygotowaniu
            Wykrywanie trybu: w przygotowaniu
            Statystyki: wersja demonstracyjna

            TOP 10 PICK
            Dane pojawią się po podłączeniu źródła statystyk.

            TOP 10 BAN
            Dane pojawią się po podłączeniu źródła statystyk.
        """.trimIndent()
        info.textSize = 16f
        info.setTextColor(Color.WHITE)
        layout.addView(info)

        val close = Button(this)
        close.text = "ZAMKNIJ"
        close.setOnClickListener { finish() }
        layout.addView(close)

        setContentView(layout)
    }
}
