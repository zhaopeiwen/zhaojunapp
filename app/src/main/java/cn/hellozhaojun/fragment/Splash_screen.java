package cn.hellozhaojun.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by asus on 2017/5/16.
 */

public class Splash_screen extends Activity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Handler handler = new Handler();
        handler.postDelayed(new Splash_screen.firsthandler(), 4000);
        setContentView(R.layout.splash);
        webView = (WebView) findViewById(R.id.webView1);
        webView.loadUrl("http://www.hellozhaojun.cn/splash");
/*        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }
        });*/
        //内部浏览器浏览
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }
    class firsthandler implements Runnable {

        public void run()
        {

            // TODO Auto-generated method stub
            startActivity(new Intent(Splash_screen.this, MainActivity.class));
            Splash_screen.this.finish();
        }

    }
}