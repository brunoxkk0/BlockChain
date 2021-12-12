package br.dev.brunoxkk0.bc.gui;

import br.dev.brunoxkk0.bc.core.Block;
import br.dev.brunoxkk0.bc.core.BlockChain;
import br.dev.brunoxkk0.bc.core.Transaction;
import br.dev.brunoxkk0.bc.statistics.Overview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GUI {

    public static BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int op;

        do{
            Object[] opt = draw(0);
            op = Integer.parseInt("" + opt[0]);

            switch (op) {
                case 1 -> {
                    opt = draw(1);
                    BlockChain.getInstance().insertTransaction(new Transaction((String) opt[0], (String) opt[1], (double) opt[2]));
                    System.out.println("Transação adicionada com sucesso.");
                }
                case 2 -> draw(2);
                case 3 -> draw(3);
                case 4 -> draw(4);
                case 5 -> draw(5);
                case 6 -> draw(6);
            }

        }while (op != 7);

    }

    public static Object[] draw(int screen) throws IOException {

        switch (screen){

            case 0:{

                clean();

                System.out.println("+========================================+");
                System.out.println();
                System.out.println("    Blocos: " + (BlockChain.getInstance().getChain().size() - 1));
                System.out.println("    Transações Pendentes: " + BlockChain.getInstance().getPendingTransactions().size());
                System.out.println("    Block Chain Válida: " + BlockChain.getInstance().isValid());
                System.out.println("    Dificuldade: " + BlockChain.getInstance().getDifficulty() + " | Recompensa ao Minerar: " + BlockChain.getInstance().getMiningReward());
                System.out.println();
                System.out.println("__________________________________________");
                System.out.println();
                System.out.println("Opções: ");
                System.out.println();
                System.out.println(" 1 - Adicionar Transação");
                System.out.println(" 2 - Minerar Transações pendentes");
                System.out.println(" 3 - Mostrar Block Chain");
                System.out.println(" 4 - Gerar Estatísticas");
                System.out.println(" 5 - Teste de Consistência");
                System.out.println(" 6 - Consultar Saldo");
                System.out.println(" 7 - Sair");
                System.out.println();
                System.out.println("Digite uma opção: ");
                System.out.println("+========================================+");

                int pos = Integer.parseInt(read());
                return new Object[]{pos};
            }

            case 1:{
                clean();

                System.out.println("Digite sua carteira: ");
                String from = read();

                System.out.println("Digite a carteira de destino: ");
                String to = read();

                System.out.println("Digite a quantia: ");
                String value = read();

                System.out.println();
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[]{from, to, Double.parseDouble(value)};
            }

            case 2:{
                clean();

                System.out.println("Digite sua carteira: ");
                String from = read();

                BlockChain.getInstance().minePendingTransactions(from);
                System.out.println();
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[0];
            }

            case 3:{
                clean();

                System.out.println("Block Chain: ");
                System.out.println();

                BlockChain.getInstance().getChain().forEach(block -> {

                    System.out.println("Bloco: " + block.getHash());
                    System.out.println("  |  -> Previous Hash: " + block.getPreviousHash());
                    System.out.println("  |  -> Timeout: " + block.getTimestamp());
                    System.out.println("  | - Transações:");

                    block.getTransactions().forEach(transaction -> {
                        System.out.println("  | | " + transaction.getFromAdress() + " -> " + transaction.getToAdress() + " : " + transaction.getAmmount());
                    });

                });

                System.out.println();
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[0];
            }

            case 4:{
                clean();
                Overview.create();

                System.out.println();
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[0];
            }

            case 5:{
                clean();

                if(BlockChain.getInstance().getChain().size() > 1){
                    int pos = 1 + new Random().nextInt(BlockChain.getInstance().getChain().size() - 1);
                    Block block = BlockChain.getInstance().getChain().get(pos);

                    System.out.println("Alterado uma transação do bloco " + pos);
                    System.out.println("Hash Original do bloco: " + block.getHash());
                    System.out.println("Alterando transação....");
                    block.getTransactions().add(new Transaction("000","111", 0.1));
                    block.recalculateHash();
                    System.out.println("Recalculando Hash: " + block.getHash());
                    BlockChain.getInstance().getChain().set(pos, block);
                    System.out.println("__________________________________________");
                    System.out.println("Block Chain está válida: " + BlockChain.getInstance().isValid());
                    System.out.println("__________________________________________");
                }else{
                    System.out.println("É necessário mais 2 blocos para poder realizar o teste.");
                }

                System.out.println();
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[0];
            }

            case 6:{
                clean();

                System.out.println("Digite sua carteira: ");
                String from = read();
                System.out.println("Saldo: " + BlockChain.getInstance().getAddressBalance(from));
                System.out.println("Digite enter para continuar.");
                read();
                return new Object[0];
            }

            case 7:{
                clean();
                return new Object[0];
            }

        }
        return new Object[0];
    }

    public static String read() throws IOException {
        String a;

        if((a = scanner.readLine()) != null)
            return a;

        return a;
    }

    public static void clean(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

}
