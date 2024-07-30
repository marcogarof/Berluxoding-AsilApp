package it.uniba.berluxoding.AsilApp.controller.gestioneSpese;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class VisualizzaSpeseFragment extends Fragment {

    private Spinner spTipologia;
    private ListView lvSpese;
    private ArrayAdapter<String> speseAdapter;
    private TextView tvTotaleSpese;
    private TextView tvGiorno, tvMese, tvAnno;
    private EditText etGiorno, etMese, etAnno;
    private List<String> speseList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_visualizza_spese, container, false);

        tvGiorno = view.findViewById(R.id.tvGiorno);
        tvMese = view.findViewById(R.id.tvtMese);
        tvAnno = view.findViewById(R.id.tvAnno);

        etGiorno = view.findViewById(R.id.etGiorno);
        etMese = view.findViewById(R.id.etMese);
        etAnno = view.findViewById(R.id.etAnno);

        spTipologia = view.findViewById(R.id.spTipologia);
        lvSpese = view.findViewById(R.id.lvSpese);
        tvTotaleSpese = view.findViewById(R.id.tvTotaleSpese);

        speseList = new ArrayList<>();

        // Popolare i tipi di spesa e i metodi di pagamento con dati simulati
        ArrayAdapter<CharSequence> tipologiaAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.tipologia_per_la_visualizzazione_array, android.R.layout.simple_spinner_item);
        tipologiaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipologia.setAdapter(tipologiaAdapter);

        // Inizializza l'adapter e collegalo alla ListView
        speseAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, speseList);
        lvSpese.setAdapter(speseAdapter);

        tvGiorno.setText(String.valueOf(LocalDate.now().getDayOfMonth()));
        tvMese.setText(String.valueOf(LocalDate.now().getMonthValue()));
        tvAnno.setText(String.valueOf(LocalDate.now().getYear()));

        Button btnCercaSpese = view.findViewById(R.id.btnCercaSpese);
        btnCercaSpese.setOnClickListener(v -> cercaSpese());

        Button btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> goBackToActivity());

        return view;
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

    public void cercaSpese() {

        // Concatenate day, month, and year to form the date of birth
        String giorno = etGiorno.getText().toString().trim();
        String mese = etMese.getText().toString().trim();
        String anno = etAnno.getText().toString().trim();
        String data = giorno + "/" + mese + "/" + anno;
        String tipologia = spTipologia.getSelectedItem().toString();

        if ( TextUtils.isEmpty(giorno) || TextUtils.isEmpty(mese) || TextUtils.isEmpty(anno) || TextUtils.isEmpty(tipologia) ) {
            Toast.makeText(getContext(), "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
            return;
        }

        speseList.clear();

        // TODO: Implementare la logica per fare le query per ricavare le spese in base alla tipologia e all'intervallo temporale
        // TODO: e aggiungere i dati ricavati  a speseList
        // TODO: Implementare anche il controllo qui sottostante
        /**
         * if(speseList.isEmpty()) {
         *             Toast.makeText(getContext(), "Non ci sono spese registrate in questo periodo", Toast.LENGTH_SHORT).show();
         *             return;
         *         }
         */

        String spesa1 = "Puttane" + " - € " + "40" + " - " + "11/09/2001" + " - " + "Altro";
        String spesa2 = "Cocaina" + " - € " + "90" + " - " + "11/09/2001" + " - " + "Farmaco";
        String spesa3 = "Dildo" + " - € " + "40" + " - " + "11/09/2001" + " - " + "Altro";
        String spesa4 = "Autobus" + " - € " + "1" + " - " + "11/09/2001" + " - " + "Tarsporti";
        String spesa5 = "Perizoma" + " - € " + "40" + " - " + "11/09/2001" + " - " + "Abbigliamento";
        String spesa6 = "Puttane" + " - € " + "40" + " - " + "11/09/2001" + " - " + "Altro";

        speseList.add(spesa1);
        speseList.add(spesa2);
        speseList.add(spesa3);
        speseList.add(spesa4);
        speseList.add(spesa5);
        speseList.add(spesa6);

        // Notifica l'adapter che i dati sono cambiati
        speseAdapter.notifyDataSetChanged();

        calcolaTotaleSpese();
    }

    private void goBackToActivity() {
        // Chiama il metodo dell'Activity per aggiornare la visibilità dei layout
        if (getActivity() instanceof GestioneSpeseActivity) {
            ((GestioneSpeseActivity) getActivity()).onFragmentClosed();
        }

        // Rimuove il Fragment dallo stack
        getActivity().getSupportFragmentManager().popBackStack();
    }

}
