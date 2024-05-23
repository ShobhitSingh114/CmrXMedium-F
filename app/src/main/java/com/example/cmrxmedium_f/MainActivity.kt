package com.example.cmrxmedium_f

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import com.example.cmrxmedium_f.presentation.CameraPreviewScreen
import com.example.cmrxmedium_f.ui.theme.CmrXMediumFTheme

class MainActivity : ComponentActivity() {

    private val cameraPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) {
                setCameraPreview()
            } else {
                // TODO() = Camera Permission denied
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        when(PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) -> {
                // TODO() = Camera Permission granted
                // TODO() = Implement Camera related code
                setCameraPreview()
            }
            else -> {
                cameraPermissionRequest.launch(android.Manifest.permission.CAMERA)
            }

        }
//        setContent {
//            CmrXMediumFTheme {
//
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    CameraPreviewScreen()
//                }
//            }
//        }
    }

    private fun setCameraPreview() {
        setContent {
            CmrXMediumFTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CameraPreviewScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CmrXMediumFTheme {

    }
}