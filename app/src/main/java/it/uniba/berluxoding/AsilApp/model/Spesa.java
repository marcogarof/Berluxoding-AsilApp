package it.uniba.berluxoding.AsilApp.model;

import java.time.LocalDate;

import it.uniba.berluxoding.AsilApp.model.enumerazioni.MetodoPagamento;
import it.uniba.berluxoding.AsilApp.model.enumerazioni.Tipologia;

public class Spesa {

    private String nomeProdotto;

    private Tipologia tipologia;

    private String utente; //CHIAVE ESTERNA, sarà lo USERNAME

    private double costo;

    private LocalDate data;

    private MetodoPagamento metodoPagamento;

    public Spesa() {
        super();
    }


    public Spesa(String nomeProdotto, Tipologia tipologia, String utente, double costo, LocalDate data, MetodoPagamento metodoPagamento){
        this.nomeProdotto = nomeProdotto;
        this.tipologia = tipologia;
        this.utente = utente;
        this.costo = costo;
        this.data = data;
        this.metodoPagamento = metodoPagamento;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public void setNomeProdotto(String nomeProdotto) {
        this.nomeProdotto = nomeProdotto;
    }

    public Tipologia getTipologia() {
        return tipologia;
    }

    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    @Override
    public String toString() {
        return "Spesa{" +
                "nomeProdotto='" + nomeProdotto + '\'' +
                ", tipologia=" + tipologia +
                ", utente='" + utente + '\'' +
                ", costo=" + costo +
                ", data=" + data +
                ", metodoPagamento=" + metodoPagamento +
                '}';
    }


}
