package br.com.drogariaappdemonstracao;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class NavegadorLocalActivity extends AppCompatActivity {

    WebView webview;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador_local);
        init();

      //  webview.setJavaScriptEnabled(true);


    }

    private void init(){
        webview = (WebView)findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/index.html");
        webview.setHapticFeedbackEnabled(true);
        //permite o botão de retorno
        webview.canGoBack();
        //permite alterações com javascript habilitado
        webview.getSettings().setJavaScriptEnabled(true);

        webview.requestFocus();

        progressDialog = new ProgressDialog(NavegadorLocalActivity.this);
        progressDialog.setMessage(getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();

        webview.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                try {
                    progressDialog.dismiss();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (webview.canGoBack()) {
                        webview.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}