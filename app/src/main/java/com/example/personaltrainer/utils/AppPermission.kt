package com.example.personaltrainer.utils


import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.app.ActivityCompat

object AppPermissions {

    const val CAMERA_PERMISSION = Manifest.permission.CAMERA

    fun isCameraPermissionGranted(activity: Activity): Boolean {
        return ActivityCompat.checkSelfPermission(
            activity,
            CAMERA_PERMISSION
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun requestCameraPermission(
        launcher: ActivityResultLauncher<String>
    ) {
        launcher.launch(CAMERA_PERMISSION)
    }
}
