package br.dev.brunoxkk0.bc.statistics;

import br.dev.brunoxkk0.bc.core.BlockChain;

import java.util.Comparator;

public class Overview {

    public static void create(){

        if(StatisticStack.getStatisticMap().isEmpty()){
            BlockChain.logger.info("Statistics is empty, has nothing to see.");
            return;
        }

        Statistics temp;

        long elapsedTotalTime = StatisticStack.getStatisticMap().values().stream().mapToLong(Statistics::getConsumedTime).sum();
        long maxTime =          (temp = StatisticStack.getStatisticMap().values().stream().max(Comparator.comparingLong(Statistics::getConsumedTime)).orElse(null)) != null ? temp.getConsumedTime() : -1;
        long mediumTime =       elapsedTotalTime / StatisticStack.getStatisticMap().size();

        BlockChain.logger.info("Total consumed time: " + elapsedTotalTime + "MS.");
        BlockChain.logger.info("Max time consumed by a block: " + maxTime + "MS.");
        BlockChain.logger.info("Medium time for a block: " + mediumTime + "MS.");

    }

    public static void show(Statistics statistics){
        BlockChain.logger.info("Block with Hash " + statistics.getFinalHash() + " created. [Difficulty: " + statistics.getDifficulty() + " | Consumed Time: " + statistics.getConsumedTime() + "MS | Times: " + statistics.getTimes() + "].");
    }

}
