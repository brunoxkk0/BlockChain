package br.dev.brunoxkk0.bc;

import br.dev.brunoxkk0.bc.core.BlockChain;
import br.dev.brunoxkk0.bc.core.Transaction;
import br.dev.brunoxkk0.bc.statistics.Overview;

public class Teste {

    public static void main(String[] args) {

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

    }

}
