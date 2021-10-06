package com.example.animationdemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(),
    View.OnClickListener,
    Animation.AnimationListener {
    var seekSpeedProgress: Int = 0
    private lateinit var animFadeIn: Animation
    private lateinit var animFadeOut: Animation
    private lateinit var animFadeInOut: Animation
    private lateinit var animZoomIn: Animation
    private lateinit var animZoomOut: Animation
    private lateinit var animLeftRight: Animation
    private lateinit var animRightLeft: Animation
    private lateinit var animTopBottom: Animation
    private lateinit var animBounce: Animation
    private lateinit var animFlash: Animation
    private lateinit var animRotateLeft: Animation
    private lateinit var animRotateRight: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadAnimations()

        val btnFadeIn = findViewById<Button>(R.id.btnFadeIn)
        val btnFadeOut = findViewById<Button>(R.id.btnFadeOut)
        val btnFadeInOut = findViewById<Button>(R.id.btnFadeInOut)
        val btnZoomIn = findViewById<Button>(R.id.btnZoomIn)
        val btnZoomOut = findViewById<Button>(R.id.btnZoomOut)
        val btnLeftRight = findViewById<Button>(R.id.btnLeftRight)
        val btnRightLeft = findViewById<Button>(R.id.btnRightLeft)
        val btnTopBottom = findViewById<Button>(R.id.btnTopBottom)
        val btnBounce = findViewById<Button>(R.id.btnBounce)
        val btnFlash = findViewById<Button>(R.id.btnFlash)
        val btnRotateLeft = findViewById<Button>(R.id.btnRotateLeft)
        val btnRotateRight = findViewById<Button>(R.id.btnRotateRight)
        val seekBarSpeed = findViewById<SeekBar>(R.id.seekBarSpeed)
        val textSeekerSpeed= findViewById<TextView>(R.id.textSeekerSpeed)


        btnFadeIn.setOnClickListener(this)
        btnFadeOut.setOnClickListener(this)
        btnFadeInOut.setOnClickListener(this)
        btnZoomIn.setOnClickListener(this)
        btnZoomOut.setOnClickListener(this)
        btnLeftRight.setOnClickListener(this)
        btnRightLeft.setOnClickListener(this)
        btnTopBottom.setOnClickListener(this)
        btnBounce.setOnClickListener(this)
        btnFlash.setOnClickListener(this)
        btnRotateLeft.setOnClickListener(this)
        btnRotateRight.setOnClickListener(this)
        seekBarSpeed.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                @SuppressLint("SetTextI18n")
                override fun onProgressChanged(
                    seekBar: SeekBar, value: Int,
                    fromUser: Boolean) {
                    seekSpeedProgress = value
                    textSeekerSpeed.text =
                        "$seekSpeedProgress of ${seekBarSpeed.max}"
                }
                override fun onStartTrackingTouch(seekBar: SeekBar) {}
                override fun onStopTrackingTouch(seekBar: SeekBar) {}
            })


    }
    private fun loadAnimations() {
        animFadeIn = AnimationUtils.loadAnimation(
            this, R.anim.fade_in)
        animFadeIn.setAnimationListener(this)
        animFadeOut = AnimationUtils.loadAnimation(
            this, R.anim.fade_out)
        animFadeInOut = AnimationUtils.loadAnimation(
            this, R.anim.fade_in_out)
        animZoomIn = AnimationUtils.loadAnimation(
            this, R.anim.zoom_in)
        animZoomOut = AnimationUtils.loadAnimation(
            this, R.anim.zoom_out)
        animLeftRight = AnimationUtils.loadAnimation(
            this, R.anim.left_right)
        animRightLeft = AnimationUtils.loadAnimation(
            this, R.anim.right_left)
        animTopBottom = AnimationUtils.loadAnimation(
            this, R.anim.top_bot)
        animBounce = AnimationUtils.loadAnimation(
            this, R.anim.bounce)
        animFlash = AnimationUtils.loadAnimation(
            this, R.anim.flash)
        animRotateLeft = AnimationUtils.loadAnimation(
            this, R.anim.rotate_left)
        animRotateRight = AnimationUtils.loadAnimation(
            this, R.anim.rotate_right)
    }
    override fun onAnimationEnd(animation: Animation) {
        val textStatus=findViewById<TextView>(R.id.textStatus)
        textStatus.text = "STOPPED"
    }
    override fun onAnimationRepeat(animation: Animation) {
    }
    override fun onAnimationStart(animation: Animation) {
        val textStatus=findViewById<TextView>(R.id.textStatus)
        textStatus.text = "RUNNING"
    }
    override fun onClick(v: View) {
        val imageView=findViewById<ImageView>(R.id.imageView)
        when (v.id) {
            R.id.btnFadeIn -> {
                animFadeIn.duration = seekSpeedProgress.toLong()
                animFadeIn.setAnimationListener(this)

                imageView.startAnimation(animFadeIn)
            }

            R.id.btnFadeOut -> {
                animFadeOut.duration = seekSpeedProgress.toLong()
                animFadeOut.setAnimationListener(this)
                imageView.startAnimation(animFadeOut)
            }
            R.id.btnFadeInOut -> {
                animFadeInOut.duration = seekSpeedProgress.toLong()
                animFadeInOut.setAnimationListener(this)
                imageView.startAnimation(animFadeInOut)
            }
            R.id.btnZoomIn -> {
                animZoomIn.duration = seekSpeedProgress.toLong()
                animZoomIn.setAnimationListener(this)
                imageView.startAnimation(animZoomIn)
            }
            R.id.btnZoomOut -> {
                animZoomOut.duration = seekSpeedProgress.toLong()
                animZoomOut.setAnimationListener(this)
                imageView.startAnimation(animZoomOut)
            }
            R.id.btnLeftRight -> {
                animLeftRight.duration = seekSpeedProgress.toLong()
                animLeftRight.setAnimationListener(this)
                imageView.startAnimation(animLeftRight)
            }
            R.id.btnRightLeft -> {
                animRightLeft.duration = seekSpeedProgress.toLong()
                animRightLeft.setAnimationListener(this)
                imageView.startAnimation(animRightLeft)
            }
            R.id.btnTopBottom -> {
                animTopBottom.duration = seekSpeedProgress.toLong()
                animTopBottom.setAnimationListener(this)
                imageView.startAnimation(animTopBottom)
            }
            R.id.btnBounce -> {
            /*Divide seekSpeedProgress by 10 because with
                 the seekbar having a max value of 5000 it
                    will make the animations range between
                       almost instant and half a second
                           5000 / 10 = 500 milliseconds        */
                animBounce.duration =
                (seekSpeedProgress / 10).toLong()
                animBounce.setAnimationListener(this)
                imageView.startAnimation(animBounce)
            }
            R.id.btnFlash -> {
                animFlash.duration = (seekSpeedProgress / 10).toLong()
                animFlash.setAnimationListener(this)
                imageView.startAnimation(animFlash)
            }
            R.id.btnRotateLeft -> {
                animRotateLeft.duration = seekSpeedProgress.toLong()
                animRotateLeft.setAnimationListener(this)
                imageView.startAnimation(animRotateLeft)
            }
            R.id.btnRotateRight -> {
                animRotateRight.duration = seekSpeedProgress.toLong()
                animRotateRight.setAnimationListener(this)
                imageView.startAnimation(animRotateRight)
            }
    }

}
}
