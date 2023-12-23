package anissia.schedule.android

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import anissia.schedule.android.ui.theme.AnissiaScheduleAndroidTheme

class MainActivity : ComponentActivity() {

    private val webview: WebView by lazy {
        findViewById<WebView>(R.id.webview)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview)

        webview.apply {
            setWebViewClient(WebViewClientEx(this@MainActivity))
            settings.apply {
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = true
                allowFileAccess = true //파일 엑세스
                domStorageEnabled = true
            }
            loadUrl("https://anissia.net/schedule/2015")
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webview.canGoBack()) {
                    webview.goBack()
                } else {
                    finish()
                }
            }
        })

    }
}

