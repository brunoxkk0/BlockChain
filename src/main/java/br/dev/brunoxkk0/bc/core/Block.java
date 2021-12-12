package br.dev.brunoxkk0.bc.core;

import br.dev.brunoxkk0.bc.statistics.Statistics;
import br.dev.brunoxkk0.bc.utils.HashUtils;

import java.io.Serializable;
import java.util.ArrayList;

public class Block implements Serializable{

    private final long timestamp;
    private final ArrayList<Transaction> transactions;

    private String previousHash;
    private String hash;

    private long nonce = 0;

    public Block(long timestamp, ArrayList<Transaction> transactions){
        this.timestamp = timestamp;
        this.transactions = new ArrayList<>(transactions);
        this.hash = calculateHash();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public void recalculateHash(){
        this.hash = calculateHash();
    }

    public String calculateHash(){
        return HashUtils.calculateHash(this.timestamp, this.transactions, this.previousHash, this.nonce);
    }

    public Statistics mineBlock(int difficulty){

        BlockChain.logger.info("Iniciando a mineração de um bloco...");

        long initTime = System.currentTimeMillis();

        String matchString = HashUtils.genString('0', difficulty);

        long times = 0;

        while (!this.hash.substring(0, difficulty).equals(matchString)){
            times++;
            this.nonce++;
            this.hash = calculateHash();
        }

        long finalTime = System.currentTimeMillis();

        return new Statistics(this.hash, initTime, finalTime, times, difficulty);
    }

    @Override
    public String toString() {
        return "Block{" +
                "timestamp=" + timestamp +
                ", transactions=" + transactions +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}
