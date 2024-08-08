package com.juanma.exercise.camerax.home

import android.Manifest
import android.view.ViewGroup
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import java.io.File
import java.util.concurrent.Executor

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun HomeScreen() {
    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val context = LocalContext.current
    val cameraController = remember {
        LifecycleCameraController(context)
    }
    val lifeCycle = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        permissionState.launchPermissionRequest()
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            val executor = ContextCompat.getMainExecutor(context)
            FloatingActionButton(onClick = {
                takePicture(cameraController, executor)
            }) {
                Text(text = "Camara")
            }
        }
    ) { paddingValues ->
    if (permissionState.status.isGranted) {
            CameraComposable(
                cameraController = cameraController,
                lifeCycle = lifeCycle,
                modifier = Modifier.padding(paddingValues))
        } else {
            Text(text = "Permiso denegado", modifier = Modifier.padding(paddingValues))
        }
    }
}

private fun takePicture(cameraController: LifecycleCameraController, executor: Executor){
    val file = File.createTempFile("imagetest", ".jpg")
    val outputDirectory = ImageCapture.OutputFileOptions.Builder(file).build()
    cameraController.takePicture(
        outputDirectory,
        executor,
        object : ImageCapture.OnImageSavedCallback{
        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
            println(outputFileResults.savedUri)
        }

        override fun onError(exception: ImageCaptureException) {
            println()
        }

    })
}

@Composable
fun CameraComposable(
    modifier: Modifier = Modifier,
    cameraController: LifecycleCameraController,
    lifeCycle: LifecycleOwner
) {
    cameraController.bindToLifecycle(lifeCycle)

    AndroidView(modifier = modifier, factory = { context ->
        val previewView = PreviewView(context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        previewView.controller = cameraController
        previewView
    })
}