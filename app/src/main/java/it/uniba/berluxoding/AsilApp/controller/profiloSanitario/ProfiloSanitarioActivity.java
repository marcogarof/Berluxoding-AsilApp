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
        TextView textViewTerapieInCorsoContent = findViewById(R.id.textViewTerapieInCorsoContent);
        TextView textViewVaccinazioniContent = findViewById(R.id.textViewVaccinazioniContent);
        TextView textViewParametriMediciContent = findViewById(R.id.textViewParametriMediciContent);
        TextView textViewStoriaClinicaContent = findViewById(R.id.textViewStoriaClinicaContent);
        TextView textViewNoteMedicheContent = findViewById(R.id.textViewNoteMedicheContent);

        // Simulazione dei dati dell'utente (poi sostituire con i dati reali presi da DB)
        String patologie = "Ipertensione, Diabete",
               allergie = "Polleni, Farmaci",
               terapieInCorso = "Metformina, Lisinopril",
               vaccinazioni = "Tetano, Epatite B",
               parametriMedici = "Pressione: 120/80, Glicemia: 90 mg/dl",
               storiaClinica = "Intervento chirurgico nel 2018, Frattura del polso nel 2020",
               noteMediche = "Paziente necessita di controllo annuale della glicemia";

        // Aggiorna i TextView con i dati simulati dell'utente
        textViewPatologieContent.setText(patologie);
        textViewAllergieContent.setText(allergie);
        textViewTerapieInCorsoContent.setText(terapieInCorso);
        textViewVaccinazioniContent.setText(vaccinazioni);
        textViewParametriMediciContent.setText(parametriMedici);
        textViewStoriaClinicaContent.setText(storiaClinica);
        textViewNoteMedicheContent.setText(noteMediche);
        // Aggiungi ulteriori operazioni per popolare gli altri TextView e gestire il bottone se necessario
    }
}
