package it.uniba.berluxoding.AsilApp.controller.sezioneInformativa;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.uniba.berluxoding.AsilApp.R;

public class SezioneInformativaActivity extends AppCompatActivity {

    //L'ID del video è la parte dopo ?v=, quindi in questo caso, https://www.youtube.com/watch?v=Op3hkJND21Q, è Op3hkJND21Q.
    private static final String INFO_UTILI_VIDEO_ID = "Op3hkJND21Q"; // Sostituisci con l'ID del video YouTube
    private static final String HEALTHY_LIFESTYLE_VIDEO_ID = "Y8HIFRPU6pM"; // https://www.youtube.com/watch?v=Y8HIFRPU6pM


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sezione_informativa);

        /**
         * INFO UTILI YOUTUBE
         */
        WebView wvInfoUtiliYoutube = findViewById(R.id.info_utili_youtube_webview);
        WebSettings webSettingsInfoUtili = wvInfoUtiliYoutube.getSettings();
        webSettingsInfoUtili.setJavaScriptEnabled(true);
        //webSettings.setDomStorageEnabled(true); // Abilita lo storage DOM

        //webView.setWebChromeClient(new WebChromeClient());
        wvInfoUtiliYoutube.setWebViewClient(new WebViewClient());

        // Carica l'URL del video di YouTube
        wvInfoUtiliYoutube.loadUrl("https://www.youtube.com/embed/" + INFO_UTILI_VIDEO_ID + "?autoplay=1&vq=small");

        TextView tvInfoCittaRegione = findViewById(R.id.textViewCittaRegione);
        tvInfoCittaRegione.setOnClickListener(v -> openFragment(R.id.fragmentContainer, new MapsFragment()));


        /**
         * STILE DI VITA SALUTARE YOUTUBE
         */
        WebView wvStileDiVitaYoutube = findViewById(R.id.stile_vita_youtube_webview);
        WebSettings webSettingsStileVita = wvStileDiVitaYoutube.getSettings();
        webSettingsStileVita.setJavaScriptEnabled(true);
        //webSettings.setDomStorageEnabled(true); // Abilita lo storage DOM

        //webView.setWebChromeClient(new WebChromeClient());
        wvStileDiVitaYoutube.setWebViewClient(new WebViewClient());

        // Carica l'URL del video di YouTube
        wvStileDiVitaYoutube.loadUrl("https://www.youtube.com/embed/" + HEALTHY_LIFESTYLE_VIDEO_ID + "?autoplay=1&vq=small");



    }

    private void openFragment(@IdRes int idRes, @NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(idRes, fragment)
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }







}

