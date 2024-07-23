package it.uniba.berluxoding.AsilApp.controller.anagrafica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import it.uniba.berluxoding.AsilApp.R;

public class AnagraficaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_MODIFICA = 1;
    private Button btnModifica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anagrafica);

        btnModifica = findViewById(R.id.btnModifica);

        btnModifica.setOnClickListener(v -> openModificaFragment());
    }

    private void openModificaFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerModifica, new ModificaAnagraficaFragment())
                .commit();
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
