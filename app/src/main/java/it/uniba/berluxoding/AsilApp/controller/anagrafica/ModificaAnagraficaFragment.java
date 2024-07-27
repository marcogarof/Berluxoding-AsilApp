package it.uniba.berluxoding.AsilApp.controller.anagrafica;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.model.Utente;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;

public class ModificaAnagraficaFragment extends Fragment {

    private static final String ARG_NOME = "nome",
                                ARG_COGNOME = "cognome",
                                ARG_USERNAME = "username",
                                ARG_PASSWORD = "password",
                                ARG_PAESE_DI_PROVENIENZA = "paese",
                                ARG_DATA_NASCITA = "data_nascita";

    private String nome, cognome, username, password, paeseDiProvenienza, dataNascita;


    private View modificaAnagrafica, confermaModifiche;

    private EditText editTextNome, editTextCognome, editTextUsername, editTextPassword, editTextPaeseDiProvenienza;
    private EditText editTextGiorno, editTextMese, editTextAnno;
    private Button btnSalvaModifiche, btnSi, btnNo ;
    private Utente utente;

    public static ModificaAnagraficaFragment newInstance(String nome, String cognome, String username, String password, String paeseDiProvenienza, String dataNascita) {
        ModificaAnagraficaFragment fragment = new ModificaAnagraficaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NOME, nome);
        args.putString(ARG_COGNOME, cognome);
        args.putString(ARG_USERNAME, username);
        args.putString(ARG_PASSWORD, password);
        args.putString(ARG_PAESE_DI_PROVENIENZA, paeseDiProvenienza);
        args.putString(ARG_DATA_NASCITA, dataNascita);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_modifica_anagrafica, container, false);

        if (getArguments() != null) {
            nome = getArguments().getString(ARG_NOME);
            cognome = getArguments().getString(ARG_COGNOME);
            username = getArguments().getString(ARG_USERNAME);
            password = getArguments().getString(ARG_PASSWORD);
            paeseDiProvenienza = getArguments().getString(ARG_PAESE_DI_PROVENIENZA);
            dataNascita = getArguments().getString(ARG_DATA_NASCITA);
        }

        editTextNome = view.findViewById(R.id.editTextNome);
        editTextCognome = view.findViewById(R.id.editTextCognome);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextPaeseDiProvenienza = view.findViewById(R.id.editTextPaeseDiProvenienza);
        editTextGiorno = view.findViewById(R.id.editTextGiorno);
        editTextMese = view.findViewById(R.id.editTextMese);
        editTextAnno = view.findViewById(R.id.editTextAnno);

        // Popola i campi con i dati passati
        if (nome != null) editTextNome.setText(nome);
        if (cognome != null) editTextCognome.setText(cognome);
        if (username != null) editTextUsername.setText(username);
        if (password != null) editTextPassword.setText(password);
        if (paeseDiProvenienza != null) editTextPaeseDiProvenienza.setText(paeseDiProvenienza);

        if (dataNascita != null) {
            String[] parts = dataNascita.split("/");
            if (parts.length == 3) {
                editTextGiorno.setText(parts[0]);
                editTextMese.setText(parts[1]);
                editTextAnno.setText(parts[2]);
            }
        }

        // Inizializza le schermate
        modificaAnagrafica = view.findViewById(R.id.modificaAnagrafica);
        confermaModifiche = view.findViewById(R.id.confermaModifiche);

        // Inizializza i bottoni
        btnSalvaModifiche = view.findViewById(R.id.btnSalavaModifiche);
        btnSi = view.findViewById(R.id.btnSi);
        btnNo = view.findViewById(R.id.btnNo);

        // Setta i click listener
        btnSalvaModifiche.setOnClickListener(v -> salvaModifiche());
        btnSi.setOnClickListener(v -> confermaSalvaModifiche());
        btnNo.setOnClickListener(v -> goBackToActivity());

        return view;
    }

    private void showScreen(View screenToShow) {
        modificaAnagrafica.setVisibility(View.GONE);
        confermaModifiche.setVisibility(View.GONE);

        screenToShow.setVisibility(View.VISIBLE);
    }

    public boolean handleOnBackPressed() {
        if (confermaModifiche.getVisibility() == View.VISIBLE) {
            showScreen(modificaAnagrafica);
            return false;
        } else {
            return true;
        }
    }

    private void salvaModifiche() {
        String nome = editTextNome.getText().toString().trim();
        String cognome = editTextCognome.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String paeseDiProvenienza = editTextPaeseDiProvenienza.getText().toString().trim();

        // Concatenate day, month, and year to form the date of birth
        String giorno = editTextGiorno.getText().toString().trim();
        String mese = editTextMese.getText().toString().trim();
        String anno = editTextAnno.getText().toString().trim();
        String dataNascita = giorno + "/" + mese + "/" + anno;

        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(cognome) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(paeseDiProvenienza) || TextUtils.isEmpty(dataNascita)) {
            Toast.makeText(getContext(), "Valore invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            dateExceptions(anno, mese, giorno);
        }
        catch (java.time.DateTimeException | IllegalArgumentException e){
            Toast.makeText(getContext(), "Valore invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        LocalDate dataNascitadate = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));
        utente = new Utente(nome, cognome, username, password, paeseDiProvenienza, dataNascitadate);

        showScreen(confermaModifiche);
    }

    private void confermaSalvaModifiche() {
        // Qui si può aggiungere il codice per salvare i dati dell'utente
        // ad esempio, salvarli in un database o inviarli a un server
        Toast.makeText(getContext(), "Modifiche apportate correttamente", Toast.LENGTH_SHORT).show();

        goBackToActivity();
    }

    private void goBackToActivity() {
        // Chiama il metodo dell'Activity per aggiornare la visibilità dei layout
        if (getActivity() instanceof AnagraficaActivity) {
            ((AnagraficaActivity) getActivity()).onFragmentClosed();
        }

        // Rimuove il Fragment dallo stack
        getActivity().getSupportFragmentManager().popBackStack();
    }


    private  void dateExceptions(String anno, String mese, String giorno){
        // la creazione di un dato LocalDate serve per verificare che l'utente non abbia inseirito valori invalidi in ciascuno dei campi della data di nascita
        LocalDate dataNascita = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));

        if( dataNascita.isAfter(LocalDate.now()) || (LocalDate.now().getYear() - Integer.valueOf(anno) < 18) || (LocalDate.now().getYear() - Integer.valueOf(anno) > 80) )
            throw new IllegalArgumentException();
    }

}

