package br.dev.brunoxkk0.bc.statistics;

import java.util.HashMap;

public class StatisticStack {

    private static final HashMap<String, Statistics> statisticMap = new HashMap<>();

    public static void add(Statistics statistics){
        statisticMap.put(statistics.getFinalHash(), statistics);
    }

    public static void registerAndShow(Statistics statistics){
        add(statistics);
        Overview.show(statistics);
    }

    public static HashMap<String, Statistics> getStatisticMap() {
        return statisticMap;
    }

}
