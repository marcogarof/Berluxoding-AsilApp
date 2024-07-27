package it.uniba.berluxoding.AsilApp.controller.autenticazione;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.time.LocalDate;
import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.home.HomeActivity;
import it.uniba.berluxoding.AsilApp.model.Utente;


public class RegistrazioneFragment extends Fragment {

    private EditText editTextNome, editTextCognome, editTextUsername, editTextPassword, editTextPaeseDiProvenienza;
    private EditText editTextGiorno, editTextMese, editTextAnno;
    private EditText editTextConfermaPassword;
    private View inserimentoDati, confermaPassword, benvenuto;
    private Button buttonRegister, buttonConfirm, buttonAvanti;
    private Utente utente;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registrazione, container, false);

        editTextNome = view.findViewById(R.id.editTextNome);
        editTextCognome = view.findViewById(R.id.editTextCognome);
        editTextUsername = view.findViewById(R.id.editTextUsername);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        editTextPaeseDiProvenienza = view.findViewById(R.id.editTextPaeseDiProvenienza);
        editTextGiorno = view.findViewById(R.id.editTextGiorno);
        editTextMese = view.findViewById(R.id.editTextMese);
        editTextAnno = view.findViewById(R.id.editTextAnno);

        editTextConfermaPassword = view.findViewById(R.id.editTextConfermaPassword);


        // Inizializza le schermate
        inserimentoDati = view.findViewById(R.id.inserimentoDati);
        confermaPassword = view.findViewById(R.id.confermaPassword);
        benvenuto = view.findViewById(R.id.benvenuto);

        // Inizializza i bottoni
        buttonRegister = view.findViewById(R.id.buttonRegister);
        buttonConfirm = view.findViewById(R.id.buttonConfirm);
        buttonAvanti = view.findViewById(R.id.buttonAvanti);

        // Setta i click listener
        buttonRegister.setOnClickListener(v -> registrazioneUtente());
        buttonConfirm.setOnClickListener(v -> confermaPassword());
        buttonAvanti.setOnClickListener(v -> finishRegistration());

        return view;
    }

    private void showScreen(View screenToShow) {
        inserimentoDati.setVisibility(View.GONE);
        confermaPassword.setVisibility(View.GONE);
        benvenuto.setVisibility(View.GONE);

        screenToShow.setVisibility(View.VISIBLE);
    }

    public boolean handleOnBackPressed() {
        if (benvenuto.getVisibility() == View.VISIBLE) {
            showScreen(confermaPassword);
            return false;
        } else if (confermaPassword.getVisibility() == View.VISIBLE) {
            showScreen(inserimentoDati);
            return false;
        } else {
            return true;
        }
    }

    private void registrazioneUtente() {
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
            Toast.makeText(getContext(), "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            dateExceptions(anno, mese, giorno);
        }
        catch (java.time.DateTimeException | IllegalArgumentException e){
            Toast.makeText(getContext(), "Valore invalido", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(getContext(), "Registrazione completata", Toast.LENGTH_SHORT).show();

        LocalDate dataNascitadate = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));
        utente = new Utente(nome, cognome, username, password, paeseDiProvenienza, dataNascitadate);

        showScreen(confermaPassword);
    }

    private void confermaPassword(){
        if(  editTextPassword.getText().toString().trim().equals(editTextConfermaPassword.getText().toString().trim()) ) {
            // Qui si può aggiungere il codice per salvare i dati dell'utente
            // ad esempio, salvarli in un database o inviarli a un server
            Toast.makeText(getContext(), "Password corretta", Toast.LENGTH_SHORT).show();
            showScreen(benvenuto);
        }
        else {
            Toast.makeText(getContext(), "Password errata", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    private void finishRegistration() {
        // Avvia la nuova Activity
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        // Chiudi l'activity corrente se necessario
        requireActivity().finish();
    }



    private  void dateExceptions(String anno, String mese, String giorno){
        // la creazione di un dato LocalDate serve per verificare che l'utente non abbia inseirito valori invalidi in ciascuno dei campi della data di nascita
        LocalDate dataNascita = LocalDate.of(Integer.valueOf(anno), Integer.valueOf(mese), Integer.valueOf(giorno));

        if( dataNascita.isAfter(LocalDate.now()) || (LocalDate.now().getYear() - Integer.valueOf(anno) < 18) || (LocalDate.now().getYear() - Integer.valueOf(anno) > 80) )
            throw new IllegalArgumentException();
    }


}

