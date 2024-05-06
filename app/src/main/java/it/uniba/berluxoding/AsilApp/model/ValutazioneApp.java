package it.uniba.berluxoding.AsilApp.model;

import java.time.LocalDate;

public class ValutazioneApp {

    private String utente;
    private LocalDate data;
    private int punteggio; // da 1 a 5
    private String feedback; //commento aggiuntivo facoltativo

    public ValutazioneApp(String utente, int punteggio, String feedback) {
        this.utente = utente;
        this.data = LocalDate.now();
        this.punteggio = punteggio;
        this.feedback = feedback;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }






}
