package it.uniba.berluxoding.AsilApp.controller.autenticazione;

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
import it.uniba.berluxoding.AsilApp.R;


public class RegistrazioneFragment extends Fragment {

    private EditText editTextNome, editTextCognome, editTextUsername, editTextPassword, editTextPaeseDiProvenienza;
    private EditText editTextGiorno, editTextMese, editTextAnno;
    private EditText editTextEta;
    private Button buttonRegister;

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
        editTextEta = view.findViewById(R.id.editTextEta);
        buttonRegister = view.findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> registrazioneUtente());

        return view;
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

        int eta;
        try {
            eta = Integer.parseInt(editTextEta.getText().toString().trim());
        } catch (NumberFormatException e) {
            eta = 0; // handle the case where eta is not a valid integer
        }

        // Implement your registration logic here
        // For example, save the user data to a database or send it to a server


        if (TextUtils.isEmpty(nome) || TextUtils.isEmpty(cognome) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(paeseDiProvenienza) || TextUtils.isEmpty(String.valueOf(eta)) || TextUtils.isEmpty(dataNascita)) {
            Toast.makeText(getContext(), "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
            return;
        }


        // Qui si può aggiungere il codice per salvare i dati dell'utente
        // ad esempio, salvarli in un database o inviarli a un server

        Toast.makeText(getContext(), "Registrazione completata", Toast.LENGTH_SHORT).show();
    }


}

