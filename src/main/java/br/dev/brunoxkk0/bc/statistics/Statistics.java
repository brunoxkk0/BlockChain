package br.dev.brunoxkk0.bc.statistics;

public class Statistics {

    private final String finalHash;
    private final long startTime;
    private final long endTime;
    private final long times;
    private final int difficulty;

    public Statistics(String finalHash, long startTime, long endTime, long times, int difficulty) {
        this.finalHash = finalHash;
        this.startTime = startTime;
        this.endTime = endTime;
        this.times = times;
        this.difficulty = difficulty;
    }

    public String getFinalHash() {
        return finalHash;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long getConsumedTime(){
        return (endTime - startTime);
    }

    public long getTimes() {
        return times;
    }

    public int getDifficulty() {
        return difficulty;
    }

}
