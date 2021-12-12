package br.dev.brunoxkk0.bc;

import br.dev.brunoxkk0.bc.core.BlockChain;
import br.dev.brunoxkk0.bc.core.Transaction;
import br.dev.brunoxkk0.bc.statistics.Overview;

public class Teste {

    public static void main(String[] args) {

        System.out.println(BlockChain.getInstance().isValid());

        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));

        System.out.println("Saldo: " + BlockChain.getInstance().getAddressBalance("id5"));

        BlockChain.getInstance().minePendingTransactions("id5");


        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));


        System.out.println("Saldo: " + BlockChain.getInstance().getAddressBalance("id5"));

        BlockChain.getInstance().minePendingTransactions("id5");


//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().insertTransaction(new Transaction("id1", "id2", 100));
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().minePendingTransactions("id5");
//        BlockChain.getInstance().insertTransaction(new Transaction("id2", "id1", 5));
//        BlockChain.getInstance().minePendingTransactions("id5");


        System.out.println("Saldo: " + BlockChain.getInstance().getAddressBalance("id5"));
        Overview.create();

        System.out.println(BlockChain.getInstance().isValid());
        System.out.println();
        BlockChain.getInstance().getChain().forEach(block -> {
            System.out.println("Bloco " + block);
            System.out.println("Bloco: " + block.getHash());
            System.out.println("  |  -> Previous Hash: " + block.getPreviousHash());
            System.out.println("  |  -> Timeout: " + block.getTimestamp());
            System.out.println("  |  -> Calculated Hash 1: " + block.calculateHash());
            System.out.println("  |  -> Calculated Hash 2: " + block.calculateHash());
            System.out.println("  |  -> Calculated Hash 3: " + block.calculateHash());
            System.out.println("  | - Transações:");

            block.getTransactions().forEach(transaction -> {
                System.out.println("  | | " + transaction.getFromAdress() + " -> " + transaction.getToAdress() + " : " + transaction.getAmmount());
            });

        });

    }

}
