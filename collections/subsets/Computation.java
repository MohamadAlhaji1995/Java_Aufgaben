package oop.collections.subsets;

import java.util.HashSet;
import java.util.Set;

public class Computation
{
    public static <T> Set<Set<T>> computeAllSubsets(Set<T> set)
    {
        Set<Set<T>> powerSet = new HashSet<>();
        // Starte mit der leeren Menge
        powerSet.add(new HashSet<>());

        // Für jedes Element in der ursprünglichen Menge
        for (T element : set)
        {
            // Erstelle eine Liste von Teilmengen, die das aktuelle Element
            // enthalten
            Set<Set<T>> newSubsets = new HashSet<>();
            for (Set<T> subset : powerSet)
            {
                // Erstelle eine neue Teilmenge, die das aktuelle Element
                // enthält
                Set<T> newSubset = new HashSet<>(subset);
                newSubset.add(element);
                newSubsets.add(newSubset);
            }
            // Füge alle neuen Teilmengen zur Potenzmenge hinzu
            powerSet.addAll(newSubsets);
        }

        return powerSet;
    }

    // Ein Testprogramm
    public static void main(String[] args)
    {
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);
        mySet.add(3);

        Set<Set<Integer>> powerSet = computeAllSubsets(mySet);
        System.out.println("Potenzmenge von {1, 2, 3}: ");
        for (Set<Integer> subset : powerSet)
        {
            System.out.println(subset);
        }
    }

}
