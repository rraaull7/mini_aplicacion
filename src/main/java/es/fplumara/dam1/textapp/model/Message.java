package es.fplumara.dam1.textapp.model;

import java.time.LocalDateTime;

public class Message {

    private String texto;
    private LocalDateTime timestamp;
    private int numerodepalabras;

    public  Message(String texto) {
        this.texto = texto;
        this.timestamp = LocalDateTime.now();
        String[] palabras = texto.trim().split("\\s+");
        numerodepalabras = palabras.length;

    }

    public String getTexto() {
        return texto;
    }

    public int getNumeropalabras() {
        return numerodepalabras;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
