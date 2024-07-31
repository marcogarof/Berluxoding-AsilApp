package it.uniba.berluxoding.AsilApp.controller.sezioneInformativa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.anagrafica.ModificaAnagraficaFragment;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.AggiungiSpeseFragment;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.ConfermaSalvaSpeseFragment;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.VisualizzaSpeseFragment;

public class SezioneInformativaActivity extends AppCompatActivity {

    //L'ID del video è la parte dopo ?v=, quindi in questo caso, https://www.youtube.com/watch?v=Op3hkJND21Q, è Op3hkJND21Q.
    private static final String VIDEO_ID = "Op3hkJND21Q"; // Sostituisci con l'ID del video YouTube

    private FrameLayout fragmentContainer;
    private LinearLayout activityContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sezione_informativa);

        fragmentContainer = findViewById(R.id.fragmentContainer);
        activityContainer = findViewById(R.id.activityContainer);

        /**
         * YOUTUBE
         */
        WebView wvYoutube = findViewById(R.id.youtube_webview);
        WebSettings webSettings = wvYoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //webSettings.setDomStorageEnabled(true); // Abilita lo storage DOM

        //webView.setWebChromeClient(new WebChromeClient());
        wvYoutube.setWebViewClient(new WebViewClient());

        // Carica l'URL del video di YouTube
        wvYoutube.loadUrl("https://www.youtube.com/embed/" + VIDEO_ID + "?autoplay=1&vq=small");

        TextView tvInfoCittaRegione = findViewById(R.id.textViewCittaRegione);
        tvInfoCittaRegione.setOnClickListener(v -> openMapsFragment());



    }

    private void openMapsFragment() {
        activityContainer.setVisibility(View.GONE); // Hide login UI elements
        fragmentContainer.setVisibility(View.VISIBLE); // Show fragment container

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, new MapsFragment())
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }

    public void onFragmentClosed() {
        fragmentContainer.setVisibility(View.GONE); // Nascondi il contenitore del Fragment
        activityContainer.setVisibility(View.VISIBLE); // Mostra il layout dell'Activity
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if(fragment instanceof MapsFragment){
            getSupportFragmentManager().popBackStack();
            onFragmentClosed();
        }
        else {
            super.onBackPressed();
        }
    }


}

