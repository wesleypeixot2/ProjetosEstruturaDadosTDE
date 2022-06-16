// Trabalho executado por Wesley San Peixoto e Natalia Kuramoto Andrade

package com.company;

import Lista.CircularQueue;

public class LabPrincipal {

    private int idxLin;
    private int idxCol;
    private boolean encerraLabirinto = false;
    private boolean posicaoInvalida = false;

    public boolean isPosicaoInvalida() {
        return posicaoInvalida;
    }

    public void setPosicaoInvalida(boolean posicaoInvalida) {
        this.posicaoInvalida = posicaoInvalida;
    }

    public boolean isEncerraLabirinto() {
        return encerraLabirinto;
    }

    public void setEncerraLabirinto(boolean encerraLabirinto) {
        this.encerraLabirinto = encerraLabirinto;
    }

    //Esqueleto do Labiritno
    public String[][] esqueletoLabirinto(){
        idxCol = 3;
        idxLin = 2;
        String [][] labirinto = {
                {"0","1","2","3","4","5","6","7","8","9","0","1","2","3"},
                {"1","|","#","#","#","#","#","#","#","#","#","#","#","|"},
                {"2","|","#","E","#","S"," "," ","#"," ","#"," ","#","|"},
                {"3","|","#"," ","#","#","#"," ","#"," ","#"," ","#","|"},
                {"4","|","#"," "," ","#"," "," ","#"," "," "," ","#","|"},
                {"5","|","#"," ","#","#","#"," ","#","#","#"," ","#","|"},
                {"6","|","#"," ","#"," "," "," "," "," ","#"," ","#","|"},
                {"7","|","#"," ","#"," ","#","#","#","#","#"," ","#","|"},
                {"8","|","#"," ","#"," "," "," "," "," "," "," ","#","|"},
                {"9","|","#"," ","#","#","#","#","#","#","#"," ","#","|"},
                {"0","|","#"," "," "," "," "," "," "," "," "," ","#","|"},
                {"1","|","#","#","#","#","#","#","#","#","#","#","#","|"}
        };
        return labirinto;
    }

    //Numeração e ordenação da quantidade de linhas e colunas do labirinto
    public void linhaColunaLabirinto(String[][] labirinto){
        for (int linha = 0; linha < 12; linha++) {
            System.out.println();
            for (int coluna = 0; coluna < 14; coluna++) {
                System.out.print(labirinto[linha][coluna] + " ");
            }
        }
        System.out.println();
    }

    //Controle utilizado pelo usuário para gravar os valores da lista
    public String[][] checaLista(String[][] labirinto, CircularQueue circularQueue){
        while (!circularQueue.isEmpty()){
            int coordenada = circularQueue.remove();
            int linPosicao = idxLin;
            int colPosicao = idxCol;

            if(coordenada == 1){
                colPosicao++;
            } else if (coordenada == 2){
                colPosicao--;
            } else if (coordenada == 3) {
                linPosicao++;
            } else if (coordenada == 4) {
                linPosicao--;
            }
            if(labirinto[linPosicao][colPosicao] == " ") {
                labirinto[linPosicao][colPosicao] = "P";
                labirinto[idxLin][idxCol] = " ";
                idxLin = linPosicao;
                idxCol = colPosicao;
            } else if (labirinto[linPosicao][colPosicao] == "S") {
                System.out.println("Jogo finalizado!");
                labirinto[linPosicao][colPosicao] = "P";
                labirinto[idxLin][idxCol] = " ";
                idxLin = linPosicao;
                idxCol = colPosicao;
                linhaColunaLabirinto(labirinto);
                setEncerraLabirinto(true);
                return labirinto;
            } else {
                setPosicaoInvalida(true);
                System.out.println("Posicao invalida, inicie o jogo novamente!");
                return labirinto;
            }
            linhaColunaLabirinto(labirinto);
        }
        return labirinto;
    }
}

// Trabalho executado por Wesley San Peixoto e Natalia Kuramoto Andrade
