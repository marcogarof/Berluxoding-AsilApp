package it.uniba.berluxoding.AsilApp.controller.profiloSanitario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import it.uniba.berluxoding.AsilApp.R;


public class ProfiloSanitarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo_sanitario);

        // Inizializza i TextView
        TextView textViewPatologieContent = findViewById(R.id.textViewPatologieContent);
        TextView textViewAllergieContent = findViewById(R.id.textViewAllergieContent);

        // Simulazione dei dati dell'utente (puoi sostituire con i dati reali)
        String patologie = "Ipertensione, Diabete";
        String allergie = "Polleni, Farmaci";

        // Aggiorna i TextView con i dati simulati dell'utente
        textViewPatologieContent.setText(patologie);
        textViewAllergieContent.setText(allergie);

        // Aggiungi ulteriori operazioni per popolare gli altri TextView e gestire il bottone se necessario
    }
}
