package com.bharathwaj.interesta;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class Rad extends AppCompatActivity {
    WebView web;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_rad );
        web = (WebView) findViewById( R.id.Webview1 );
        progressBar = (ProgressBar) findViewById( R.id.progressbar1 );
        web.setWebViewClient( new Rad.myWebClient() );
        web.getSettings().setJavaScriptEnabled( true );
        web.loadUrl("http://www.india.fm/");
    }
    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted( view, url, favicon );
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub
            progressBar.setVisibility( View.VISIBLE );
            view.loadUrl( url );
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished( view, url );
            progressBar.setVisibility( View.GONE );
        }
    }
    // To handle "Back" key press event for WebView to go back to previous screen.
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web.canGoBack()) {
            web.goBack();
            return true;
        }
        return super.onKeyDown( keyCode, event );
    }
}
