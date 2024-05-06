package it.uniba.berluxoding.AsilApp.model;

import java.time.LocalDate;

public class Utente {

    private String nome, cognome, username, password, paeseDiProvenienza; //USERNAME CHIAVE PRIMARIA

    private int eta;

    private LocalDate dataNascita;

    public Utente() {
        super();
    }

    public Utente(String nome, String cognome, String username, String password, String paeseDiProvenienza,
                  int eta, LocalDate dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.paeseDiProvenienza = paeseDiProvenienza;
        this.eta = eta;
        this.dataNascita = dataNascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getPaeseDiProvenienza() {
        return paeseDiProvenienza;
    }

    public void setPaeseDiProvenienza(String paeseDiProvenienza) {
        this.paeseDiProvenienza = paeseDiProvenienza;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", paeseDiProvenienza='" + paeseDiProvenienza + '\'' +
                ", eta=" + eta +
                ", dataNascita=" + dataNascita +
                '}';
    }



}
