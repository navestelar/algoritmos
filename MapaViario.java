import java.util.Scanner;

public class MapaViario {
    public static void main(String[] args) {
        int iCarro=1;
        int jCarro=1;
        int linha=0;
        int coluna=0;
        String casaAnterior = "i";
        String movimentoAnterior = "nenhum";
        String movimento="1";
        Scanner move = new Scanner(System.in);
        String[][] mapa = {{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","I"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","O"," "," "," "," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "},{"i",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","+",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","E"," "," "," "," "," "," "," "," "," "," "," "}, {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "}, {"O","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","+","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+","=","=","=","=","=","=","X"},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","D","<","<","<","<","<","<","i"},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},{"i","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+",">",">",">",">",">",">",">",">",">","O"},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","E",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","D"," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "},{"i","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","v"," "," "," "," "," "," "," "," "," "},{" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","E",">",">",">",">",">",">",">",">","o"}};
        do {
            for (int i=0;i<mapa.length;i++){
                for (int j=0;j<mapa[0].length;j++){
                    System.out.print(mapa[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("-------------------------------------------");
            System.out.println("Escreva as coordenadas do início desejado: ");
            System.out.print("Linha: ");
            linha = move.nextInt();
            System.out.print("Coluna: ");
            coluna = move.nextInt();
            System.out.println("-------------------------------------------");
            move.nextLine();
            if (mapa[linha][coluna].equals("i")){
                System.out.println("Coordenadas válidas!");
            } else{
                System.out.println("Coordenadas INVÁLIDAS!");
            }
        }while(!(mapa[linha][coluna].equals("i")));
        casaAnterior = mapa[linha][coluna];
        mapa[linha][coluna]="@";
        for (int i=0;i<mapa.length;i++){
            for (int j=0;j<mapa[0].length;j++){
                System.out.print(mapa[i][j]+" ");
            }
            System.out.println();
        }
        while(!(casaAnterior.equals("O"))){
            System.out.println("+--------------+");
            System.out.println("|Movimentos:   |");
            System.out.println("|D     direita |");
            System.out.println("|S     baixo   |");
            System.out.println("|A     esquerda|");
            System.out.println("|W     cima    |");
            System.out.println("+--------------+");
            System.out.print("Digite o movimento: ");
            movimento = move.nextLine();

            if (casaAnterior.equals("D")) {
                if (movimentoAnterior.equals("D")){
                    while (!(movimento.toUpperCase().equals("S"))){
                        System.out.println("----------------------");
                        System.out.println("Sentido obrigatório: S");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                        System.out.println("----------------------");
                    }
                }
                if (movimentoAnterior.equals("S")){
                    while (!(movimento.toUpperCase().equals("A"))){
                        System.out.println("Sentido obrigatório: A");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
                if (movimentoAnterior.equals("A")){
                    while (!(movimento.toUpperCase().equals("W"))){
                        System.out.println("Sentido obrigatório: W");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
                if (movimentoAnterior.equals("W")){
                    while (!(movimento.toUpperCase().equals("D"))){
                        System.out.println("Sentido obrigatório: D");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
            }

            if (casaAnterior.equals("E")) {
                if (movimentoAnterior.equals("D")){
                    while (!(movimento.toUpperCase().equals("W"))){
                        System.out.println("Sentido obrigatório: W");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
                if (movimentoAnterior.equals("S")){
                    while (!(movimento.toUpperCase().equals("D"))){
                        System.out.println("Sentido obrigatório: D");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
                if (movimentoAnterior.equals("A")){
                    while (!(movimento.toUpperCase().equals("S"))){
                        System.out.println("Sentido obrigatório: S");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
                if (movimentoAnterior.equals("W")){
                    while (!(movimento.toUpperCase().equals("A"))){
                        System.out.println("Sentido obrigatório: A");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
            }

            if (casaAnterior.equals(">")) {
                while (!(movimento.toUpperCase().equals("D"))){
                    System.out.println("Sentido obrigatório: D");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (casaAnterior.equals("<")) {
                while (!(movimento.toUpperCase().equals("A"))){
                    System.out.println("Sentido obrigatório: A");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (casaAnterior.equals("v")) {
                while (!(movimento.toUpperCase().equals("S"))){
                    System.out.println("Sentido obrigatório: S");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (casaAnterior.equals("^")) {
                while (!(movimento.toUpperCase().equals("W"))){
                    System.out.println("Sentido obrigatório: W");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (casaAnterior.equals("=")) {
                while (!(movimento.toUpperCase().equals("A")) && !(movimento.toUpperCase().equals("D"))){
                    System.out.println("Sentidos obrigatórios: A ou D");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (casaAnterior.equals("H")) {
                while (!(movimento.toUpperCase().equals("W")) && !(movimento.toUpperCase().equals("S"))){
                    System.out.println("Sentidos obrigatórios: W ou S");
                    System.out.print("Digite o movimento: ");
                    movimento = move.nextLine();
                }
            }

            if (movimento.toUpperCase().equals("D")){
                if (jCarro>=4){
                    System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                }else if (mapa[iCarro][jCarro+1].equals(">") || mapa[iCarro][jCarro+1].equals("=") || mapa[iCarro][jCarro+1].equals("+") || mapa[iCarro][jCarro+1].equals("X") || mapa[iCarro][jCarro+1].equals("D") || mapa[iCarro][jCarro+1].equals("E") || mapa[iCarro][jCarro+1].equals("O") || mapa[iCarro][jCarro+1].equals("i")){
                    mapa[iCarro][jCarro]=casaAnterior;
                    jCarro++;
                    casaAnterior=mapa[iCarro][jCarro];
                    mapa[iCarro][jCarro]="@";
                    movimentoAnterior = "D";
                } else {
                    System.out.println("Este movimento não é permitido pela via!");
                }
            }

            if (movimento.toUpperCase().equals("S")){
                if (iCarro>=3){
                    System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                }else if (mapa[iCarro+1][jCarro].equals("v") || mapa[iCarro][jCarro+1].equals("H") || mapa[iCarro][jCarro+1].equals("+") || mapa[iCarro][jCarro+1].equals("X") || mapa[iCarro][jCarro+1].equals("D") || mapa[iCarro][jCarro+1].equals("E") || mapa[iCarro][jCarro+1].equals("O") || mapa[iCarro][jCarro+1].equals("i")){
                    mapa[iCarro][jCarro]=casaAnterior;
                    jCarro++;
                    casaAnterior=mapa[iCarro][jCarro];
                    mapa[iCarro][jCarro]="@";
                    movimentoAnterior = "D";
                } else {
                    System.out.println("Este movimento não é permitido pela via!");
                }
            }

            if (movimento.toUpperCase().equals("A")){
                if (jCarro<=1){
                    System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                }else if (mapa[iCarro][jCarro+1].equals("<") || mapa[iCarro][jCarro+1].equals("=") || mapa[iCarro][jCarro+1].equals("+") || mapa[iCarro][jCarro+1].equals("X") || mapa[iCarro][jCarro+1].equals("D") || mapa[iCarro][jCarro+1].equals("E") || mapa[iCarro][jCarro+1].equals("O") || mapa[iCarro][jCarro+1].equals("i")){
                    mapa[iCarro][jCarro]=casaAnterior;
                    jCarro++;
                    casaAnterior=mapa[iCarro][jCarro];
                    mapa[iCarro][jCarro]="@";
                    movimentoAnterior = "D";
                } else {
                    System.out.println("Este movimento não é permitido pela via!");
                }
            }

            if (movimento.toUpperCase().equals("W")){
                if (iCarro<=1){
                    System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                }else if (mapa[iCarro+1][jCarro].equals("^") || mapa[iCarro][jCarro+1].equals("H") || mapa[iCarro][jCarro+1].equals("+") || mapa[iCarro][jCarro+1].equals("X") || mapa[iCarro][jCarro+1].equals("D") || mapa[iCarro][jCarro+1].equals("E") || mapa[iCarro][jCarro+1].equals("O") || mapa[iCarro][jCarro+1].equals("i")){
                    mapa[iCarro][jCarro]=casaAnterior;
                    jCarro++;
                    casaAnterior=mapa[iCarro][jCarro];
                    mapa[iCarro][jCarro]="@";
                    movimentoAnterior = "D";
                } else {
                    System.out.println("Este movimento não é permitido pela via!");
                }
            }

            for (int i=0;i<mapa.length;i++){
                for (int j=0;j<mapa[0].length;j++){
                    System.out.print(mapa[i][j]+" ");
                }
                System.out.println();
            }   
        }

        System.out.println("Parabéns, você chegou à saída da cidade!");
        move.close();
    }
}