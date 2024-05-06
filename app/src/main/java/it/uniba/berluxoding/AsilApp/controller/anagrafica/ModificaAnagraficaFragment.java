package it.uniba.berluxoding.AsilApp.controller.anagrafica;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.uniba.berluxoding.AsilApp.R;
import android.widget.Button;
import android.widget.EditText;


public class ModificaAnagraficaFragment extends Fragment {

    private EditText editTextNome;
    private Button btnConfermaModifiche;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modifica_anagrafica, container, false);

        // Inizializza le view
        editTextNome = view.findViewById(R.id.editTextNome);
        btnConfermaModifiche = view.findViewById(R.id.btnConfermaModifiche);

        // Aggiungi un listener al pulsante "Conferma"
        btnConfermaModifiche.setOnClickListener(v -> confermaModifiche());

        return view;
    }

    private void confermaModifiche() {
        // Ottieni il nuovo valore inserito dall'utente
        String nuovoNome = editTextNome.getText().toString();

        // Esegui qui le operazioni per salvare il nuovo valore

        // Rimuovi il fragment corrente
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ModificaAnagraficaFragment.this).commit();
    }

}

