package it.uniba.berluxoding.AsilApp.controller.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.anagrafica.AnagraficaActivity;
import it.uniba.berluxoding.AsilApp.controller.gestioneSpese.GestioneSpeseActivity;
import it.uniba.berluxoding.AsilApp.controller.profiloSanitario.ProfiloSanitarioActivity;
import it.uniba.berluxoding.AsilApp.controller.sezioneInformativa.SezioneInformativaActivity;
import it.uniba.berluxoding.AsilApp.controller.valutazioni.ValutazioniActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnSchedaAnagrafica = findViewById(R.id.btnSchedaAnagrafica);
        Button btnProfiloSanitario = findViewById(R.id.btnProfiloSanitario);
        Button btnSezioneInformativa = findViewById(R.id.btnSezioneInformativa);
        Button btnValutazioni = findViewById(R.id.btnValutazioni);
        Button btnGestioneSpese = findViewById(R.id.btnGestioneSpese);

        btnSchedaAnagrafica.setOnClickListener(v -> startActivityWithIntent(AnagraficaActivity.class));
        btnProfiloSanitario.setOnClickListener(v -> startActivityWithIntent(ProfiloSanitarioActivity.class));
        btnSezioneInformativa.setOnClickListener(v -> startActivityWithIntent(SezioneInformativaActivity.class));
        btnValutazioni.setOnClickListener(v -> startActivityWithIntent(ValutazioniActivity.class));
        btnGestioneSpese.setOnClickListener(v -> startActivityWithIntent(GestioneSpeseActivity.class));

    }

    private void startActivityWithIntent(Class<?> targetActivity) {
        Intent intent = new Intent(HomeActivity.this, targetActivity);
        startActivity(intent);
    }

}
