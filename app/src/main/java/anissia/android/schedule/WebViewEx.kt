package anissia.android.schedule

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.AttributeSet
import android.webkit.*
import androidx.core.content.ContextCompat

@SuppressLint("SetJavaScriptEnabled")
class WebViewEx : WebView {

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        // 기본 정책 설정
        settings.apply {
            javaScriptEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            allowFileAccess = true
            domStorageEnabled = true
        }

        // alert 설정
        webChromeClient = object: WebChromeClient() {
            override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
                AlertDialog.Builder(context).create().apply {
                    setMessage(message)
                    setButton(AlertDialog.BUTTON_POSITIVE, "OK") { dialog, which -> dialog.dismiss() }
                    show()
                }
                return false
            }
        }

        // WebViewClient 설정
        setWebViewClient(object: WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return request?.url?.let { handleUrl(it) } ?: true
            }

            private fun handleUrl(url: Uri): Boolean {
                val allowedDomain = "https://anissia.net/schedule/2015"
                if (url.toString().startsWith(allowedDomain)) {
                    return false
                }

                return openExternalBrowser(url)
            }

            private fun openExternalBrowser(url: Uri): Boolean {
                val intent = Intent(Intent.ACTION_VIEW, url)
                ContextCompat.startActivity(context, intent, null)
                return true
            }
        })

        // 로드
        loadUrl("https://anissia.net/schedule/2015")
    }
}