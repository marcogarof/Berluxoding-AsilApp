package it.uniba.berluxoding.AsilApp.controller.gestioneSpese;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import it.uniba.berluxoding.AsilApp.R;

public class ConfermaSalvaSpeseFragment extends Fragment {

    private List<String> speseList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_conferma_salva_spese, container, false);

        // Recupera la lista delle spese passata come argomento
        if (getArguments() != null) {
            speseList = getArguments().getStringArrayList("speseList");
        }

        Button btnSi = view.findViewById(R.id.btnSi);
        Button btnNo = view.findViewById(R.id.btnNo);

        btnSi.setOnClickListener(v -> salvaSpese());

        btnNo.setOnClickListener(v -> getActivity().getSupportFragmentManager().popBackStack());

        return view;
    }

    private void salvaSpese() {

        // TODO: Implementare la logica per salvare le spese
        Toast.makeText(getContext(), "Spese salvate con successo", Toast.LENGTH_SHORT).show();

        goBackToActivity();
    }

    private void goBackToActivity() {
        // Chiama il metodo dell'Activity per aggiornare la visibilità dei layout
        if (getActivity() instanceof GestioneSpeseActivity) {
            ((GestioneSpeseActivity) getActivity()).onFragmentClosed();
        }

        // Rimuove tutti i frammenti dallo stack
        getActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}

