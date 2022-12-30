package com.programmers.githubapimvvm

import android.opengl.GLSurfaceView
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gl_surface_view.setEGLContextClientVersion(2)
        gl_surface_view.setRenderer(MyRenderer())
    }
}