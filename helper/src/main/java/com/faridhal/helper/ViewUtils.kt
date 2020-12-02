package com.faridhal.helper

import android.os.SystemClock
import android.view.View
import android.widget.TextView

object ViewUtils {

    fun View.gone() {
        visibility = View.GONE
    }

    fun View.visible() {
        visibility = View.VISIBLE
    }

    fun View.invisible() {
        visibility = View.INVISIBLE
    }

    fun TextView.stringTrim(): String {
        return text.toString().trim()
    }

    fun View.isGone() = visibility == View.GONE

    fun View.isVisible() = visibility == View.VISIBLE

    fun View.isInVisible() = visibility == View.INVISIBLE

    fun View.safeClick(listener: View.OnClickListener) {
        safeClick(1000, listener)
    }

    fun View.safeClick(blockInMillis: Long, listener: View.OnClickListener) {
        var lastClickTime: Long = 0
        this.setOnClickListener {
            if (SystemClock.elapsedRealtime() - lastClickTime < blockInMillis) return@setOnClickListener
            lastClickTime = SystemClock.elapsedRealtime()
            listener.onClick(this)
        }
    }
}