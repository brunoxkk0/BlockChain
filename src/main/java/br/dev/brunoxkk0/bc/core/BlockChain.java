package br.dev.brunoxkk0.bc.core;

import br.dev.brunoxkk0.bc.statistics.StatisticStack;
import br.dev.brunoxkk0.bc.statistics.Statistics;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;

public class BlockChain {

    public static final Logger logger = Logger.getLogger("BlockChain");
    private static final BlockChain instance = new BlockChain();

    public static BlockChain getInstance() {
        return instance;
    }

    private final LinkedList<Block> chain = new LinkedList<>();

    private final int difficulty;
    private final double miningReward;

    public int getDifficulty() {
        return difficulty;
    }

    public double getMiningReward() {
        return miningReward;
    }

    private final ArrayList<Transaction> pendingTransactions = new ArrayList<>();

    public ArrayList<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

    public BlockChain(){
        createGenesisBlock();
        this.difficulty = 3;
        this.miningReward = 10;
    }

    private void createGenesisBlock(){
        Block block = new Block(System.currentTimeMillis(), new ArrayList<>());
        block.setPreviousHash("0");
        block.recalculateHash();
        chain.add(block);
    }

    public LinkedList<Block> getChain() {
        return chain;
    }

    public Block getLastBlock(){
        return chain.getLast();
    }

    public boolean isValid(){

        boolean valid = true;

        for(int i = 1; i < chain.size(); i++){

            Block block = chain.get(i);
            Block lastBlock = chain.get(i - 1);

            if(!(valid = block.getHash().equals(block.calculateHash())))
                break;

            if(!(valid = lastBlock.getHash().equals(block.getPreviousHash())))
                break;
        }

        return valid;
    }

    public void minePendingTransactions(String rewardAddress) {
        Block block = new Block(System.currentTimeMillis(), pendingTransactions);
        block.setPreviousHash(getLastBlock().getHash());
        block.recalculateHash();
        Statistics statistics = block.mineBlock(difficulty);
        StatisticStack.registerAndShow(statistics);
        chain.add(block);

        pendingTransactions.clear();
        insertTransaction(new Transaction(null, rewardAddress, miningReward));
    }

    public void insertTransaction(Transaction transaction){
        pendingTransactions.add(transaction);
    }

    public double getAddressBalance(String address){
        double balance = 0;

        for(Block block : chain){
            for(Transaction transaction : block.getTransactions()){

                if(transaction.getFromAdress() != null && transaction.getFromAdress().equals(address))
                    balance -= transaction.getAmmount();

                if(transaction.getToAdress() != null && transaction.getToAdress().equals(address))
                    balance += transaction.getAmmount();
            }
        }

        return balance;
    }

    @Override
    public String toString() {
        return "BlockChain{" +
                "chain=" + chain +
                '}';
    }
}
