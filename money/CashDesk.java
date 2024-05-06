package oop.money;

import java.util.ArrayList;
import java.util.List;

public class CashDesk {

    public static List<Double> pay(double price, double amountGiven) {
        if (price < 0 || amountGiven < 0) {
            throw new IllegalArgumentException("Preis und bezahlter Betrag dürfen nicht negativ sein.");
        }
        if (amountGiven < price) {
            throw new IllegalArgumentException("Der bezahlte Betrag muss mindestens so groß wie der Preis sein.");
        }

        double change = amountGiven - price;
        // Die Rundungsgenauigkeit wird eingestellt, um Probleme mit der Genauigkeit von Fließkommazahlen zu minimieren
        change = Math.round(change * 100.0) / 100.0;

        List<Double> changeList = new ArrayList<>();
        double[] denominations = {50.0, 20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

        for (double denomination : denominations) {
            while (change >= denomination) {
                changeList.add(denomination);
                change -= denomination;
                change = Math.round(change * 100.0) / 100.0; // erneute Rundung nach jeder Operation
            }
        }

        return changeList;
    }

    public static void main(String[] args) {
        // Testen der Methode mit dem gegebenen Beispiel
        List<Double> result = pay(35.16, 100.0);
        System.out.println(result);
    }
}
