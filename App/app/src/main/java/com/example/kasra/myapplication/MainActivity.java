package com.example.kasra.myapplication;

import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.os.Build;

public class MainActivity extends Activity {

    private WebView webView;

    public void onCreate(Bundle savedInstanceState) {
        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView1);

        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        this.webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.webView.getSettings().setPluginState(android.webkit.WebSettings.PluginState.ON_DEMAND);

        webView.getSettings().setGeolocationDatabasePath(context.getFilesDir().getPath());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            webView.getSettings().setDatabasePath("/data/data/" + webView.getContext().getPackageName() + "/databases/");
        }

        webView.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });

        webView.setWebViewClient(new WebViewClient());

        //webView.loadUrl("http://unlvstudentsupportapp.esy.es/test.html");
        webView.loadUrl("http://unlvstudentsupportapp.esy.es/website/public/index.html");

    }

}
