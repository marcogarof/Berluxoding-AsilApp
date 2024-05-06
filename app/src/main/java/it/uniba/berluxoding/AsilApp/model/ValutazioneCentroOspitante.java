package it.uniba.berluxoding.AsilApp.model;

import java.time.LocalDate;

public class ValutazioneCentroOspitante {

    private String utente;
    private String centroOspitante;
    private LocalDate data;
    private int punteggio; // da 1 a 5
    private String feedback; //commento aggiuntivo facoltativo
    public ValutazioneCentroOspitante(String utente, String centroOspitante, int punteggio, String feedback) {
        this.utente = utente;
        this.centroOspitante = centroOspitante;
        this.data = LocalDate.now();
        this.punteggio = punteggio;
        this.feedback = feedback;
    }

    // Metodi getter e setter per gli attributi
    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getCentroOspitante() {
        return centroOspitante;
    }

    public void setIdCentroOspitante(String idCentroOspitante) {
        this.centroOspitante = idCentroOspitante;
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
