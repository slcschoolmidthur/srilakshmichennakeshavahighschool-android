package com.srilakshmichennakeshavahighschoolmidthur;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.view.Window;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class MainActivity extends Activity {

    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // START -- copy from here
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // END -- copy till here

        setContentView(R.layout.activity_main);

        CustomWebViewClient client = new CustomWebViewClient(this);
        webView = findViewById(R.id.webView);
        webView.setWebViewClient(client);
/*
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowFileAccess(true);

        webView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView.loadUrl("file:///error.html");

            }
        });

 */
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://slc-school.com/post");

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && this.webView.canGoBack()){
            this.webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}

class CustomWebViewClient extends WebViewClient{
    private Activity activity;

    public CustomWebViewClient(Activity activity){
        this.activity = activity;
    }

    //API level less than 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url){
/*
        if (url != null && url.contains("slc-school.com")) {
            //do what you want here
            return false;
        } else {
            return true;
        }

 */
        return false;
    }


/*
    //API level greater than= 24
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request){
        return false;
    }
*/






}
