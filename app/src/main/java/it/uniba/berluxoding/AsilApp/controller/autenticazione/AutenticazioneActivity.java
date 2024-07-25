package it.uniba.berluxoding.AsilApp.controller.autenticazione;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import it.uniba.berluxoding.AsilApp.R;
import it.uniba.berluxoding.AsilApp.controller.home.HomeActivity;

import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AutenticazioneActivity extends AppCompatActivity {

    private FrameLayout fragmentContainer;
    private LinearLayout loginContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticazione);

        fragmentContainer = findViewById(R.id.fragment_container);
        loginContainer = findViewById(R.id.login_container);

        TextView textViewRegister = findViewById(R.id.textViewRegister);
        textViewRegister.setOnClickListener(v -> openRegistrazioneFragment());
    }

    private void openRegistrazioneFragment() {
        loginContainer.setVisibility(View.GONE); // Hide login UI elements
        fragmentContainer.setVisibility(View.VISIBLE); // Show fragment container

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new RegistrazioneFragment())
                .addToBackStack(null) // Adds the transaction to the back stack so the user can navigate back
                .commit();
    }

    public void redirectToMainActivity(View view) {
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
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }


}

