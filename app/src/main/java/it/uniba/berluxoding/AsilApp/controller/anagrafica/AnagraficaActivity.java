package it.uniba.berluxoding.AsilApp.controller.anagrafica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.autenticazione.RegistrazioneFragment;

public class AnagraficaActivity extends AppCompatActivity {

    private FrameLayout fragmentContainer;
    private LinearLayout anagraficaContainer;

    private static final int REQUEST_CODE_MODIFICA = 1;
    private Button btnModifica;
    private TextView tvNome, tvCognome, tvUsername, tvPaeseDiProvenienza, tvDataNascita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagrafica);

        // Inizializzazione delle variabili con i riferimenti ai TextView
        tvNome = findViewById(R.id.tvNome);
        tvCognome = findViewById(R.id.tvCognome);
        tvUsername = findViewById(R.id.tvUsername);
        tvPaeseDiProvenienza = findViewById(R.id.tvPaeseDiProvenienza);
        tvDataNascita = findViewById(R.id.tvDataNascita);

        // Simulazione di recupero dei dati dall'istanza utente (sostituire con dati reali)
        String nome = "Mario";
        String cognome = "Rossi";
        String username = "mario.rossi";
        String paeseDiProvenienza = "Italia";
        String dataNascita = "01/01/1990";

        // Impostazione dei dati sui TextView
        tvNome.setText(nome);
        tvCognome.setText(cognome);
        tvUsername.setText(username);
        tvPaeseDiProvenienza.setText(paeseDiProvenienza);
        tvDataNascita.setText(dataNascita);

        fragmentContainer = findViewById(R.id.fragment_container);
        anagraficaContainer = findViewById(R.id.layoutAnagrafica);

        btnModifica = findViewById(R.id.btnModifica);
        btnModifica.setOnClickListener(v -> openModificaFragment());
    }

    private void openModificaFragment() {
        anagraficaContainer.setVisibility(View.GONE); // Hide login UI elements
        fragmentContainer.setVisibility(View.VISIBLE); // Show fragment container

        // Recupera i dati dalla tua scheda anagrafica
        String nome = tvNome.getText().toString();
        String cognome = tvCognome.getText().toString();
        String username = tvUsername.getText().toString();
        String paeseDiProvenienza = tvPaeseDiProvenienza.getText().toString();
        String dataNascita = tvDataNascita.getText().toString();

        // Crea una nuova istanza del fragment con i dati
        ModificaAnagraficaFragment fragment = ModificaAnagraficaFragment.newInstance(nome, cognome, username, "", paeseDiProvenienza, dataNascita);

        openFragment(R.id.fragment_container, fragment);
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
        if (fragment instanceof ModificaAnagraficaFragment) { //condizione per verificare se ci trova sul fragment oppure no
            if (((ModificaAnagraficaFragment) fragment).handleOnBackPressed()) {
                getSupportFragmentManager().popBackStack();
                onFragmentClosed();
            }
        }
        else super.onBackPressed();
    }

    public void onFragmentClosed() {
        fragmentContainer.setVisibility(View.GONE); // Nascondi il contenitore del Fragment
        anagraficaContainer.setVisibility(View.VISIBLE); // Mostra il layout dell'Activity
    }

    // Gestisci il risultato restituito da ModificaAnagraficaFragment
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_MODIFICA) {
            if (resultCode == Activity.RESULT_OK) {
                // Aggiorna la visualizzazione della scheda anagrafica o esegui altre operazioni necessarie
            }
        }
    }



}
