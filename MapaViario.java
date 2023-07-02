import java.util.Random;
import java.util.Scanner;

public class MapaViario {
    public static void main(String[] args) {
        int iCarro=0;
        int jCarro=0;
        int n=0;
        int pontos = 0;
        String continuar="s";
        String casaAnterior = "i";
        String movimentoAnterior = "nenhum";
        String movimento="1";
        Scanner move = new Scanner(System.in);
        String[][] mapa = {
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","i"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","O"," "," "," "," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "," "},
        {"i",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","+",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","E"," "," "," "," ","E","<","<","<","<","<","<","i"}, 
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "}, 
        {"O","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","<","+","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+","=","=","=","=","=","=","X"},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","^"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
        {"i","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+",">",">",">",">",">",">",">",">","O"},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","E",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">",">","D"," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","v"," "," "," "," "," "," "," "," "," "},
        {"i","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","=","+"," "," "," "," "," "," "," "," "," "},
        {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","E",">",">",">",">",">",">",">",">","O"}};
        Random random = new Random();
        int inicio[][] = {{2,0,2,7,12},{0,30,60,0,0}};
        int sorteio=0;
        do{
            sorteio = random.nextInt(4);
            iCarro=inicio[0][sorteio];
            jCarro=inicio[1][sorteio];
            casaAnterior=mapa[iCarro][jCarro];
            mapa[iCarro][jCarro]="@";
            for (int i=0;i<mapa.length;i++){
                for (int j=0;j<mapa[0].length;j++){
                    System.out.print(mapa[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("+--------------+");
            System.out.println("|Movimentos:   |");
            System.out.println("|D     direita |");
            System.out.println("|S     baixo   |");
            System.out.println("|A     esquerda|");
            System.out.println("|W     cima    |");
            System.out.println("+--------------+");
            System.out.println("ATENÇÃO: você ganha pontos na carteira quando infringe as leis de trânsito e quando chegar a 40 pontos perde a carteira.");
            while((!(casaAnterior.equals("O"))) && (pontos<40)){
                System.out.println("*************************************************************************************************************************");
                System.out.print("Digite o movimento: ");
                movimento = move.nextLine();

                if (casaAnterior.equals("D")) {
                    if (movimentoAnterior.equals("D")){
                        while ((!(movimento.toUpperCase().equals("S"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: S");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("S")){
                        while ((!(movimento.toUpperCase().equals("A"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: A");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("A")){
                        while ((!(movimento.toUpperCase().equals("W"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: W");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("W")){
                        while ((!(movimento.toUpperCase().equals("D"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: D");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                }
    
                if (casaAnterior.equals("E")) {
                    if (movimentoAnterior.equals("D")){
                        while ((!(movimento.toUpperCase().equals("W"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: W");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("S")){
                        while ((!(movimento.toUpperCase().equals("D"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: D");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("A")){
                        while ((!(movimento.toUpperCase().equals("S"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: S");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                    if (movimentoAnterior.equals("W")){
                        while ((!(movimento.toUpperCase().equals("A"))) && (pontos<40)){
                            pontos+=5;
                            System.out.println("ATENÇÃO: +5 pontos na carteira por converção indevida");
                            System.out.println("Pontos na carteira: "+pontos);
                            System.out.println("Sentido obrigatório: A");
                            System.out.print("Digite o movimento: ");
                            movimento = move.nextLine();
                        }
                    }
                }
    
                if (casaAnterior.equals(">")) {
                    while ((!(movimento.toUpperCase().equals("D"))) && (pontos<40)){
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                        System.out.println("Sentido obrigatório: D");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
    
                if (casaAnterior.equals("<")) {
                    while ((!(movimento.toUpperCase().equals("A"))) && (pontos<40)){
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                        System.out.println("Sentido obrigatório: A");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
    
                if (casaAnterior.equals("v")) {
                    while ((!(movimento.toUpperCase().equals("S"))) && (pontos<40)){
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                        System.out.println("Sentido obrigatório: S");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }
    
                if (casaAnterior.equals("^")) {
                    while ((!(movimento.toUpperCase().equals("W"))) && (pontos<40)){
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                        System.out.println("Sentido obrigatório: W");
                        System.out.print("Digite o movimento: ");
                        movimento = move.nextLine();
                    }
                }

                if (movimento.toUpperCase().equals("D")){
                    if (jCarro+1>=mapa[0].length){
                        System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                        pontos+=2;
                        System.out.println("ATENÇÃO: +2 pontos na carteira");
                        System.out.println("Pontos na carteira: "+pontos);
                    }else if (mapa[iCarro][jCarro+1].equals(">") || mapa[iCarro][jCarro+1].equals("=") || mapa[iCarro][jCarro+1].equals("+") || mapa[iCarro][jCarro+1].equals("X") || mapa[iCarro][jCarro+1].equals("D") || mapa[iCarro][jCarro+1].equals("E") || mapa[iCarro][jCarro+1].equals("O") || mapa[iCarro][jCarro+1].equals("i")){
                        mapa[iCarro][jCarro]=casaAnterior;
                        jCarro++;
                        casaAnterior=mapa[iCarro][jCarro];
                        mapa[iCarro][jCarro]="@";
                        movimentoAnterior = "D";
                    }else {
                        System.out.println("Este movimento não é permitido pela via!");
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                    }
                }
    
                if (movimento.toUpperCase().equals("S")){
                    if (iCarro>12){
                        System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                        pontos+=2;
                        System.out.println("ATENÇÃO: +2 pontos na carteira");
                        System.out.println("Pontos na carteira: "+pontos);
                    }else if (mapa[iCarro+1][jCarro].equals("v") || mapa[iCarro+1][jCarro].equals("H") || mapa[iCarro+1][jCarro].equals("+") || mapa[iCarro+1][jCarro].equals("X") || mapa[iCarro+1][jCarro].equals("D") || mapa[iCarro+1][jCarro].equals("E") || mapa[iCarro+1][jCarro].equals("O") || mapa[iCarro+1][jCarro].equals("i")){
                        mapa[iCarro][jCarro]=casaAnterior;
                        iCarro++;
                        System.out.println(iCarro);
                        casaAnterior=mapa[iCarro][jCarro];
                        mapa[iCarro][jCarro]="@";
                        movimentoAnterior = "S";
                    }else {
                        System.out.println("Este movimento não é permitido pela via!");
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                    }
                }
    
                if (movimento.toUpperCase().equals("A")){
                    if (jCarro<1){
                        System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                        pontos+=2;
                        System.out.println("ATENÇÃO: +2 pontos na carteira");
                        System.out.println("Pontos na carteira: "+pontos);
                    }else if (mapa[iCarro][jCarro-1].equals("<") || mapa[iCarro][jCarro-1].equals("=") || mapa[iCarro][jCarro-1].equals("+") || mapa[iCarro][jCarro-1].equals("X") || mapa[iCarro][jCarro-1].equals("D") || mapa[iCarro][jCarro-1].equals("E") || mapa[iCarro][jCarro-1].equals("O") || mapa[iCarro][jCarro-1].equals("i")){
                        mapa[iCarro][jCarro]=casaAnterior;
                        jCarro--;
                        casaAnterior=mapa[iCarro][jCarro];
                        mapa[iCarro][jCarro]="@";
                        movimentoAnterior = "A";
                    } else {
                        System.out.println("Este movimento não é permitido pela via!");
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                    }
                }
    
                if (movimento.toUpperCase().equals("W")){
                    if (iCarro<1){
                        System.out.println("Movimento inválido, pois o carro sairá do mapa!");
                        pontos+=2;
                        System.out.println("ATENÇÃO: +2 pontos na carteira");
                        System.out.println("Pontos na carteira: "+pontos);
                    }else if (mapa[iCarro-1][jCarro].equals("^") || mapa[iCarro-1][jCarro].equals("H") || mapa[iCarro-1][jCarro].equals("+") || mapa[iCarro-1][jCarro].equals("X") || mapa[iCarro-1][jCarro].equals("D") || mapa[iCarro-1][jCarro].equals("E") || mapa[iCarro-1][jCarro].equals("O") || mapa[iCarro-1][jCarro].equals("i")){
                        mapa[iCarro][jCarro]=casaAnterior;
                        iCarro--;
                        casaAnterior=mapa[iCarro][jCarro];
                        mapa[iCarro][jCarro]="@";
                        movimentoAnterior = "W";
                    } else {
                        System.out.println("Este movimento não é permitido pela via!");
                        pontos+=5;
                        System.out.println("ATENÇÃO: +5 pontos na carteira por não seguir o sentido da via");
                        System.out.println("Pontos na carteira: "+pontos);
                    }
                }
              
                for (int i=0;i<mapa.length;i++){
                    for (int j=0;j<mapa[0].length;j++){
                        System.out.print(mapa[i][j]+" ");
                    }
                    System.out.println();
                }   

                if (casaAnterior.equals(">")){
                    n=1;
                    while (mapa[iCarro][jCarro+n].equals(">")||mapa[iCarro][jCarro+n].equals("=")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro][jCarro+n].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if (casaAnterior.equals("<")){
                    n=1;
                    while (mapa[iCarro][jCarro-n].equals("<")|| mapa[iCarro][jCarro-n].equals("=")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro][jCarro-n].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if (casaAnterior.equals("^")){
                    n=1;
                    while (mapa[iCarro-n][jCarro].equals("^")||mapa[iCarro-n][jCarro].equals("H")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro-n][jCarro].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if (casaAnterior.equals("v")){
                    n=1;
                    while (mapa[iCarro+n][jCarro].equals("v")||mapa[iCarro+n][jCarro].equals("H")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro+n][jCarro].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if ((casaAnterior.equals("=")) && (movimentoAnterior.equals("D"))){
                    n=1;
                    while (mapa[iCarro][jCarro+n].equals(">")|| mapa[iCarro][jCarro+n].equals("=")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro][jCarro+n].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro+n].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if ((casaAnterior.equals("=")) && (movimentoAnterior.equals("A"))){
                    n=1;
                    while (mapa[iCarro][jCarro-n].equals(">")|| mapa[iCarro][jCarro-n].equals("=")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro][jCarro-n].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro][jCarro-n].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if ((casaAnterior.equals("H")) && (movimentoAnterior.equals("W"))){
                    n=1;
                    while (mapa[iCarro-n][jCarro].equals("^")||mapa[iCarro-n][jCarro].equals("H")){
                        n++;
                    }
                    if (n<=5) {
                        if (mapa[iCarro-n][jCarro].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro-n][jCarro].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }

                if ((casaAnterior.equals("H")) && (movimentoAnterior.equals("S"))){
                    n=1;
                    while (mapa[iCarro+n][jCarro].equals("v")||mapa[iCarro+n][jCarro].equals("H")){
                        n++;
                    }
                    if (n<=5){
                        if (mapa[iCarro+n][jCarro].equals("D")) {
                            System.out.println("Vire à direita em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("E")) {
                            System.out.println("Vire à esquerda em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("X")) {
                            System.out.println("Rua sem saída em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("O")) {
                            System.out.println("Saída da cidade em "+n*20+" metros");
                        }
                        if (mapa[iCarro+n][jCarro].equals("+")) {
                            System.out.println("Cruzamento em "+n*20+" metros");
                        }
                    }
                }
            }

            if (casaAnterior.equals("O")){
                System.out.println("Parabéns, você chegou à saída da cidade!");
                System.out.println("Pontos na carteira: "+pontos);
            }

            if (pontos>=40){
                System.out.println("ATENÇÃO: você perdeu a carteira. Volte para a autoescola e preste mais atenção nas leis de trânsito.");
            }

            System.out.println("Escreva S para recomeçar ou qualquer outra letra para parar!");
            continuar = move.nextLine();
            mapa[iCarro][jCarro]=casaAnterior;
            pontos=0;
        }while(continuar.toUpperCase().equals("S"));
        move.close();
    }
}