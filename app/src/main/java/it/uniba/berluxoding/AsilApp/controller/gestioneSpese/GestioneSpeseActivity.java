package it.uniba.berluxoding.AsilApp.controller.gestioneSpese;


import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.anagrafica.ModificaAnagraficaFragment;
import it.uniba.berluxoding.AsilApp.controller.autenticazione.RegistrazioneFragment;

public class GestioneSpeseActivity extends AppCompatActivity {

    private Button vediSpese, aggiungiSpese;

    private LinearLayout buttonsContainer;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestione_spese);

        vediSpese = findViewById(R.id.btnVediSpese);
        aggiungiSpese = findViewById(R.id.btnAggiungiSpese);

        buttonsContainer = findViewById(R.id.buttons_container);
        fragmentContainer = findViewById(R.id.fragment_container);

        vediSpese.setOnClickListener(v -> openNewFragment(R.id.fragment_container, new VisualizzaSpeseFragment()));
        aggiungiSpese.setOnClickListener(v -> openNewFragment(R.id.fragment_container, new AggiungiSpeseFragment()));
    }

    private void openNewFragment(int idRes, Fragment fragment){
        buttonsContainer.setVisibility(View.GONE); // Hide login UI elements
        fragmentContainer.setVisibility(View.VISIBLE); // Show fragment container

        openFragment(idRes, fragment);
    }

    private void openFragment(@IdRes int idRes, @NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(idRes, fragment)
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment instanceof AggiungiSpeseFragment || fragment instanceof ConfermaSalvaSpeseFragment) {
            getSupportFragmentManager().popBackStack();
            if (fragment instanceof AggiungiSpeseFragment) {
                onFragmentClosed();
            }
        } else if(fragment instanceof VisualizzaSpeseFragment){
            getSupportFragmentManager().popBackStack();
            onFragmentClosed();
        }
        else {
            super.onBackPressed();
        }
    }

    public void onFragmentClosed() {
        fragmentContainer.setVisibility(View.GONE); // Nascondi il contenitore del Fragment
        buttonsContainer.setVisibility(View.VISIBLE); // Mostra il layout dell'Activity
    }


}
