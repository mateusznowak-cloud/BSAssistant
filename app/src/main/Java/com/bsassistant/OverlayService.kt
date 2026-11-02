package com.bsassistant

import android.app.Service
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.WindowManager
import android.widget.TextView

class OverlayService : Service() {

    private lateinit var windowManager: WindowManager
    private var icon: TextView? = null

    override fun onCreate() {
        super.onCreate()

        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val bubble = TextView(this)
        bubble.text = "BS"
        bubble.textSize = 18f
        bubble.setTextColor(Color.WHITE)
        bubble.setBackgroundColor(Color.rgb(20, 100, 230))
        bubble.gravity = Gravity.CENTER
        bubble.setPadding(18, 18, 18, 18)

        bubble.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )

        params.gravity = Gravity.TOP or Gravity.END
        params.x = 20
        params.y = 250

        windowManager.addView(bubble, params)
        icon = bubble
    }

    override fun onDestroy() {
        icon?.let { windowManager.removeView(it) }
        icon = null
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
