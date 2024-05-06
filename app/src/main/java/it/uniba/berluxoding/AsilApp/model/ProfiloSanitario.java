package it.uniba.berluxoding.AsilApp.model;

import java.util.HashMap;

public class ProfiloSanitario {

    private String utente;// sia chiave esterna che primaria
    private String patologie; // la stringa sarà tipo : pat1,pat2,pat3,... (con valori separati da virgola)
    private String allergie; // con valori separati da virgola
    private String terapieInCorso; // con valori separati da virgola
    private String vaccinazioni; // con valori separati da virgola
    private HashMap<String, String> parametriMedici; // avvolorati dalla MedBox
    private String storiaClinica;
    private String noteMediche;

    // Costruttore
    public ProfiloSanitario(String utente, String patologie, String allergie,
                            String terapieInCorso, String vaccinazioni, HashMap<String, String> parametriMedici,
                            String storiaClinica, String noteMediche) {
        this.utente = utente;
        this.patologie = patologie;
        this.allergie = allergie;
        this.terapieInCorso = terapieInCorso;
        this.vaccinazioni = vaccinazioni;
        this.parametriMedici = parametriMedici;
        this.storiaClinica = storiaClinica;
        this.noteMediche = noteMediche;
    }

    public ProfiloSanitario(String utente) {
        this.utente = utente;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getPatologie() {
        return patologie;
    }

    public void setPatologie(String patologie) {
        this.patologie = patologie;
    }

    public String getAllergie() {
        return allergie;
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public String getTerapieInCorso() {
        return terapieInCorso;
    }

    public void setTerapieInCorso(String terapieInCorso) {
        this.terapieInCorso = terapieInCorso;
    }

    public String getVaccinazioni() {
        return vaccinazioni;
    }

    public void setVaccinazioni(String vaccinazioni) {
        this.vaccinazioni = vaccinazioni;
    }

    public HashMap<String, String> getParametriMedici() {
        return parametriMedici;
    }

    public void setParametriMedici(HashMap<String, String> parametriMedici) {
        this.parametriMedici = parametriMedici;
    }

    public String getStoriaClinica() {
        return storiaClinica;
    }

    public void setStoriaClinica(String storiaClinica) {
        this.storiaClinica = storiaClinica;
    }

    public String getNoteMediche() {
        return noteMediche;
    }

    public void setNoteMediche(String noteMediche) {
        this.noteMediche = noteMediche;
    }


    @Override
    public String toString() {
        return "ProfiloSanitario{" +
                "utente='" + utente + '\'' +
                ", patologie=" + patologie +
                ", allergie=" + allergie +
                ", terapieInCorso=" + terapieInCorso +
                ", vaccinazioni=" + vaccinazioni +
                ", parametriMedici=" + parametriMedici +
                ", storiaClinica='" + storiaClinica + '\'' +
                ", noteMediche='" + noteMediche + '\'' +
                '}';
    }






}
