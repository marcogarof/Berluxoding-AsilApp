package it.uniba.berluxoding.AsilApp.controller.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.anagrafica.AnagraficaActivity;
import it.uniba.berluxoding.AsilApp.controller.profiloSanitario.ProfiloSanitarioActivity;
import it.uniba.berluxoding.AsilApp.controller.sezioneInformativa.SezioneInformativaActivity;
import it.uniba.berluxoding.AsilApp.controller.valutazioni.ValutazioniActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Trova il pulsante della scheda anagrafica nel layout
        Button btnSchedaAnagrafica = findViewById(R.id.btnSchedaAnagrafica);
        // Trova il pulsante del profilo sanitario nel layout
        Button btnProfiloSanitario = findViewById(R.id.btnProfiloSanitario);
        // Trova il pulsante per la sezione informativa nel layout
        Button btnSezioneInformativa = findViewById(R.id.btnSezioneInformativa);
        // Trova il pulsante per le valutazioni nel layout
        Button btnValutazioni = findViewById(R.id.btnValutazioni);

        // Imposta un listener per il click sul pulsante della scheda anagrafica
        btnSchedaAnagrafica.setOnClickListener(v -> {
            // Avvia l'attività della scheda anagrafica
            Intent intent = new Intent(HomeActivity.this, AnagraficaActivity.class);
            startActivity(intent);
        });

        // Imposta un listener per il click sul pulsante del profilo sanitario
        btnProfiloSanitario.setOnClickListener(v -> {
            // Avvia l'attività del profilo sanitario
            Intent intent = new Intent(HomeActivity.this, ProfiloSanitarioActivity.class);
            startActivity(intent);
        });

        // Imposta un listener per il click sul pulsante per la sezione informativa
        btnSezioneInformativa.setOnClickListener(v -> {
            // Avvia l'attività della sezione informativa
            Intent intent = new Intent(HomeActivity.this, SezioneInformativaActivity.class);
            startActivity(intent);
        });

        // Imposta un listener per il click sul pulsante per le valutazioni
        btnValutazioni.setOnClickListener(v -> {
            // Avvia l'attività delle valutazioni
            Intent intent = new Intent(HomeActivity.this, ValutazioniActivity.class);
            startActivity(intent);
        });
    }

}
