package com.programmers.githubapiRepository.view

import android.content.Context

class ShowToast(private val context: Context) {

    fun toastEvent(string: String) {
        android.widget.Toast.makeText(context, string, android.widget.Toast.LENGTH_SHORT).show()
    }

}