package it.uniba.berluxoding.AsilApp.controller.gestioneSpese;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.anagrafica.AnagraficaActivity;

public class AggiungiSpeseFragment extends Fragment {

    private EditText etNomeProdotto;
    private EditText etCosto;
    private Spinner spTipologia;
    private Spinner spMetodoPagamento;
    private ListView lvSpese;
    private TextView tvTotaleSpese;
    private SpeseAdapter speseAdapter;
    private List<String> speseList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            speseList = savedInstanceState.getStringArrayList("speseList");
        } else {
            speseList = new ArrayList<>();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aggiungi_spese, container, false);

        etNomeProdotto = view.findViewById(R.id.etNomeProdotto);
        etCosto = view.findViewById(R.id.etCosto);
        spTipologia = view.findViewById(R.id.spTipologia);
        spMetodoPagamento = view.findViewById(R.id.spMetodoPagamento);
        lvSpese = view.findViewById(R.id.lvSpese);
        tvTotaleSpese = view.findViewById(R.id.tvTotaleSpese);

        // Popolare i tipi di spesa e i metodi di pagamento con dati simulati
        ArrayAdapter<CharSequence> tipologiaAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.tipologia_array, android.R.layout.simple_spinner_item);
        tipologiaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipologia.setAdapter(tipologiaAdapter);

        ArrayAdapter<CharSequence> metodoPagamentoAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.metodo_pagamento_array, android.R.layout.simple_spinner_item);
        metodoPagamentoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMetodoPagamento.setAdapter(metodoPagamentoAdapter);

        speseAdapter = new SpeseAdapter(getContext(), speseList, this);
        lvSpese.setAdapter(speseAdapter);

        // Calcolare il totale delle spese
        calcolaTotaleSpese();

        Button btnAggiungiSpesa = view.findViewById(R.id.btnAggiungiSpesa);
        btnAggiungiSpesa.setOnClickListener(v -> aggiungiSpesa());

        Button btnSalvaSpese = view.findViewById(R.id.btnSalvaSpese);
        btnSalvaSpese.setOnClickListener(v -> openConfermaSalvaSpeseFragment());

        Button btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> goBackToActivity());

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("speseList", new ArrayList<>(speseList));
    }

    public void calcolaTotaleSpese() {
        double totale = 0.0;
        for (String spesa : speseList) {
            String[] parts = spesa.split(" - ");
            String costoStr = parts[1].replace("€", "");
            totale += Double.parseDouble(costoStr);
        }
        tvTotaleSpese.setText("Totale Spese: €" + totale);
    }

    public void aggiungiSpesa() {
        String nomeProdotto = etNomeProdotto.getText().toString();

        if( etCosto.getText().toString().equals(".")) { //Altrimenti viene lanciata eccezione che fa crashare tutta l'app
            Toast.makeText(getContext(), "Valore costo errato", Toast.LENGTH_SHORT).show();
            return;
        }

        double costo = Double.parseDouble(etCosto.getText().toString());
        String tipologia = spTipologia.getSelectedItem().toString();
        String metodoPagamento = spMetodoPagamento.getSelectedItem().toString();
        LocalDate data = LocalDate.now();

        if ( TextUtils.isEmpty(nomeProdotto) || TextUtils.isEmpty(String.valueOf(costo)) || TextUtils.isEmpty(tipologia) || TextUtils.isEmpty(metodoPagamento) ||
                nomeProdotto == null || tipologia == null || metodoPagamento == null ) {
            Toast.makeText(getContext(), "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
            return;
        }

        String spesa = nomeProdotto + " - € " + costo + " - " + data.toString() + " - " + metodoPagamento;
        speseList.add(spesa);
        speseAdapter.notifyDataSetChanged();

        calcolaTotaleSpese();
    }

    private void openConfermaSalvaSpeseFragment() {
        if (!speseList.isEmpty()) {
            // Passa la lista delle spese al frammento di conferma
            ConfermaSalvaSpeseFragment confermaFragment = new ConfermaSalvaSpeseFragment();
            Bundle args = new Bundle();
            args.putStringArrayList("speseList", new ArrayList<>(speseList));
            confermaFragment.setArguments(args);

            // Mostra il frammento di conferma
            openFragment(R.id.fragment_container, confermaFragment);
        }
        else Toast.makeText(getContext(), "Lista della spesa vuota", Toast.LENGTH_SHORT).show();
    }

    private void goBackToActivity() {
        // Chiama il metodo dell'Activity per aggiornare la visibilità dei layout
        if (getActivity() instanceof GestioneSpeseActivity) {
            ((GestioneSpeseActivity) getActivity()).onFragmentClosed();
        }

        // Rimuove il Fragment dallo stack
        getActivity().getSupportFragmentManager().popBackStack();
    }

    private void openFragment(@IdRes int idRes, @NonNull Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(idRes, fragment)
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }

}

