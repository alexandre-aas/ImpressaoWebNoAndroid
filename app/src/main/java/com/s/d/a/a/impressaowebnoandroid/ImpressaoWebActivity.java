package com.s.d.a.a.impressaowebnoandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.content.Context;

public class ImpressaoWebActivity extends AppCompatActivity {

    private WebView mainWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impressao_web);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainWebView = findViewById(R.id.mainWebView);

        mainWebView.loadUrl("https://developer.android.com/studio/intro");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_print) {
            criarTrabalhoImpressaoWeb(mainWebView);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void criarTrabalhoImpressaoWeb(WebView webView) {

        PrintManager gerenciadorDeImpressao = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);

        PrintDocumentAdapter printAdapter =
                webView.createPrintDocumentAdapter("DocumentoWeb");

        String jobName = getString(R.string.app_name) +
                " Teste de impressão documento web";

        gerenciadorDeImpressao.print(jobName, printAdapter, new PrintAttributes.Builder().build());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_impressao_web, menu);
        return true;
    }

}
