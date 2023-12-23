package anissia.schedule.android

import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity

class WebViewClientEx(
    private val activity: ComponentActivity
) : WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return request?.url?.let { handleUrl(it) } ?: true
    }

    private fun handleUrl(url: Uri): Boolean {
        openExternalBrowser(url)
        return true
    }

    private fun openExternalBrowser(url: Uri) {
        val intent = Intent(Intent.ACTION_VIEW, url)
        startActivity(activity, intent, null)
    }
}