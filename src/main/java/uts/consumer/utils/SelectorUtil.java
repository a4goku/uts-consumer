package uts.consumer.utils;

public class SelectorUtil {

    public static Pair<Integer, Integer> getDataBaseAndTableNumber(String uuid){
        int hashCode = Math.abs(uuid.hashCode());

        System.err.println("haseCOde: " + hashCode);

        int selectDataBaseNumber = (hashCode/10) % 4 + 1;

        int selectTableNumber = hashCode % 10;

        System.err.println("-------------------selectDataBaseNumber" + selectDataBaseNumber + "-------------------");
        System.err.println("-------------------selectTableNumber" + selectTableNumber + "-------------------");

        return new Pair<Integer, Integer>(selectDataBaseNumber, selectTableNumber);
    }
}
