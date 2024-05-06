package it.uniba.berluxoding.AsilApp.controller.autenticazione;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import it.uniba.berluxoding.AsilApp.MainActivity;
import it.uniba.berluxoding.AsilApp.R;
import android.content.Intent;
import android.view.View;

public class AutenticazioneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticazione);
    }

    public void redirectToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish(); // Opzionale: chiude l'activity corrente
    }
}

