package it.uniba.berluxoding.AsilApp.controller.autenticazione;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.home.HomeActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AutenticazioneActivity extends AppCompatActivity {

    private FrameLayout fragmentContainer;
    private LinearLayout loginContainer;

    private EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticazione);

        fragmentContainer = findViewById(R.id.fragment_container);
        loginContainer = findViewById(R.id.login_container);

        etUsername = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);

        TextView textViewRegister = findViewById(R.id.textViewRegister);
        Button btnLogin = findViewById(R.id.btnLogin);

        textViewRegister.setOnClickListener(v -> openRegistrazioneFragment());
        btnLogin.setOnClickListener(view -> login());
    }

    private void openRegistrazioneFragment() {
        loginContainer.setVisibility(View.GONE); // Hide login UI elements
        fragmentContainer.setVisibility(View.VISIBLE); // Show fragment container

        openFragment(R.id.fragment_container, new RegistrazioneFragment());
    }

    private void openFragment(@IdRes int idRes, @NonNull Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(idRes, fragment)
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if ( TextUtils.isEmpty(username) || TextUtils.isEmpty(password) ) {
            Toast.makeText(this, "Tutti i campi sono obbligatori", Toast.LENGTH_SHORT).show();
            return;
        }

        //VERIFICARE CHE L'UTENTE ESISTE MEDIANTE QUERY AL DB
        // e nel caso -> Toast.makeText(this, "Login avvenuto con successo", Toast.LENGTH_SHORT).show();
        //altrimenti -> Toast.makeText(this, "Credenziali errate", Toast.LENGTH_SHORT).show(); return;

        redirectToHomeActivity();
    }

    public void redirectToHomeActivity(View view) {
        redirectToHomeActivity();
    }

    public void redirectToHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        //se si volesse NON dare la possibilità di tornare indietro a questa activity basterebbe chiamare il metodo finish()
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment instanceof RegistrazioneFragment) {
            if (((RegistrazioneFragment) fragment).handleOnBackPressed()) {
                fragmentContainer.setVisibility(View.GONE);
                loginContainer.setVisibility(View.VISIBLE);
                getSupportFragmentManager().popBackStack();
            }
        } else {
            super.onBackPressed();
        }
    }


}

