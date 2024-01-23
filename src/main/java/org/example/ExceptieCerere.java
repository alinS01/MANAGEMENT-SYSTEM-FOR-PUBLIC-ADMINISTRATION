package org.example;

public class ExceptieCerere extends Exception {
    String text = null;

    public ExceptieCerere(String text) {
        this.text = text;
    }
}
