// Trabalho executado por Wesley San Peixoto e Natalia Kuramoto Andrade

package com.company;

import Lista.CircularQueue;

import java.util.Scanner;

public class LabExecutavel {

    public static void main(String[] args) {
        LabPrincipal labirinto = new com.company.LabPrincipal();
        CircularQueue circularQueue = new CircularQueue(200);
        String[][] table = labirinto.esqueletoLabirinto();
        Scanner input = new Scanner(System.in);

        while(!labirinto.isEncerraLabirinto()) {
            labirinto.linhaColunaLabirinto(table);
            System.out.println("1 -> Direita | 2 -> Esquerda | 3 -> Baixo | 4 -> Acima | 5 -> Validacao | 6 -> Zerando o The Maze");
            System.out.println("Escolha um numero andar no The Maze");
            Integer entrada = input.nextInt();
            if(entrada >= 1 && entrada <= 4) {
                circularQueue.add(entrada);
            } else if (entrada == 5) {
                labirinto.checaLista(table, circularQueue);
                if(labirinto.isPosicaoInvalida()){
                    circularQueue.clear();
                    table = labirinto.esqueletoLabirinto();
                    System.out.println("Voce nao chegou no 'S'");
                }
            } else if(entrada == 6){
                circularQueue.clear();
                table = labirinto.esqueletoLabirinto();
            } else {
                System.out.println("Entrada invalida! Tente novamente e se atente ao descrito, champz!");
            }
        }
        System.out.println("Labirinto Resolvido");
        labirinto.linhaColunaLabirinto(table);
    }
}

// Trabalho executado por Wesley San Peixoto e Natalia Kuramoto Andrade