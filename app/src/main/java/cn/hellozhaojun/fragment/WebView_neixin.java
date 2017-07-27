package cn.hellozhaojun.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

/**
 * Created by asus on 2017/5/17.
 */

public class WebView_neixin extends Activity {
    private WebView mWebView_neixin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neixin);
        mWebView_neixin = (WebView) findViewById(R.id.webView_neixin);
        mWebView_neixin.loadUrl("http://www.hellozhaojun.cn/neixin_problem");
        mWebView_neixin.setWebViewClient(new WebViewClient(){
            @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return shouldOverrideUrlLoading(view,url);
            }
        });
    }

}
