package com.nuncsystems.cameraapp.view

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.view.animation.AlphaAnimation
import android.widget.Chronometer

/**
 * Subclass of [Chronometer] which supports additional behaviours like pause, resume and animate.
 */
class CapturerChronometer(context: Context?, attrs: AttributeSet?) : Chronometer(context, attrs) {

    private var currentBase : Long = SystemClock.elapsedRealtime()
    private val alphaAnimation: AlphaAnimation = AlphaAnimation(0f, 1f).apply {
        duration = 800
        repeatMode = AlphaAnimation.RESTART
        repeatCount = AlphaAnimation.INFINITE
    }

    fun pause(){
        currentBase = base - SystemClock.elapsedRealtime()
        this.startAnimation(alphaAnimation)
        stop()
    }

    fun resume(){
        clearFadeAnimation()
        base = SystemClock.elapsedRealtime() + currentBase
        start()
    }

    private fun clearFadeAnimation(){
        this.animation?.let {
            it.cancel()
            this.clearAnimation()
        }
    }

    fun clearAnimationAndStop(){
        clearFadeAnimation()
        stop()
    }
}