package it.uniba.berluxoding.AsilApp.controller.sezioneInformativa;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import android.webkit.WebViewClient;
import android.widget.Button;



import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.AggiungiSpeseFragment;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.ConfermaSalvaSpeseFragment;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.VisualizzaSpeseFragment;


public class MapsFragment extends Fragment {

    private WebView wvMaps;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        wvMaps = view.findViewById(R.id.wvMaps);
        // Abilita JavaScript
        WebSettings webSettingsMaps = wvMaps.getSettings();
        webSettingsMaps.setJavaScriptEnabled(true);

        wvMaps.setWebViewClient(new WebViewClient());

        // Carica una mappa di Google Maps tramite URL
        wvMaps.loadUrl("https://www.google.com/maps/search/centri+accoglienza+migranti");


        Button btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> goBackToActivity());

        return view;
    }

    private void goBackToActivity() {
        // Chiama il metodo dell'Activity per aggiornare la visibilità dei layout
        if (getActivity() instanceof SezioneInformativaActivity) {
            ((SezioneInformativaActivity) getActivity()).onFragmentClosed();
        }

        // Rimuove il Fragment dallo stack
        getActivity().getSupportFragmentManager().popBackStack();
    }
}
