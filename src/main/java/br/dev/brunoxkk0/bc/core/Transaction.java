package br.dev.brunoxkk0.bc.core;

import java.io.Serializable;

public class Transaction implements Serializable {

    private final String fromAdress;
    private final String toAdress;
    private final double ammount;


    public Transaction(String fromAdress, String toAdress, double ammount) {
        this.fromAdress = fromAdress;
        this.toAdress = toAdress;
        this.ammount = ammount;
    }

    public String getFromAdress() {
        return fromAdress;
    }

    public String getToAdress() {
        return toAdress;
    }

    public double getAmmount() {
        return ammount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "fromAdress='" + fromAdress + '\'' +
                ", toAdress='" + toAdress + '\'' +
                ", ammount=" + ammount +
                '}';
    }
}
