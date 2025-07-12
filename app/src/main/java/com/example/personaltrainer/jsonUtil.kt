package com.example.personaltrainer.utils

import android.content.Context

fun loadJSONFromAsset(context: Context, fileName: String): String? {
    return try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer)
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}
