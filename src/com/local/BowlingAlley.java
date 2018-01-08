package com.local;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BowlingAlley {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pC = in.nextInt();
        int totalChance = 3;
        int[][] scores = new int[pC][totalChance];
        int[] pScore = new int[pC];
        PriorityQueue<Integer> mxHeap = new PriorityQueue<Integer>(pC);
        int chance = 0;
       /* while(chance<pC*totalChance){
            int cScore = 0;
            int incValue = 0;
            boolean brk = false;
            if(in.hasNextInt()){
                int s = in.nextInt();
                cScore = s;
                incValue = 1;
            }else{
                if(in.next().equalsIgnoreCase("X")){
                    cScore = 25;
                    incValue = 2;
                    brk = true;
                }
            }
            if(!brk){
                if(in.hasNextInt()){
                    int s = in.nextInt();
                    cScore += s;
                    incValue = incValue +1;
                }else{
                    if(in.next().equalsIgnoreCase("\\")){
                        cScore =15;
                        incValue = incValue +1;
                    }
                }
            }
            scores[(chance)%(pC)][chance/pC] = cScore;
            pScore[chance%(pC-1)] += cScore;
            chance += incValue;
        }
        for (int i = 0; i < pScore.length; i++) {
            System.out.println(pScore[i]);
        }*/
        for (int i = 0; i < scores.length; i++) {
            for(int j = 0;j<pC;j++){
                int cScore = 0;
                int incValue = 0;
                boolean brk = false;
                if(in.hasNextInt()){
                    int s = in.nextInt();
                    cScore = s;
                    incValue = 1;
                }else{
                    if(in.next().equalsIgnoreCase("X")){
                        cScore = 25;
                        incValue = 2;
                        brk = true;
                    }
                }
                if(!brk){
                    if(in.hasNextInt()){
                        int s = in.nextInt();
                        cScore += s;
                        incValue = incValue +1;
                    }else{
                        if(in.next().equalsIgnoreCase("\\")){
                            cScore =15;
                            incValue = incValue +1;
                        }
                    }
                }
                scores[i][j] = cScore;
            }
            System.out.println();
        }

        for (int i = 0; i < scores.length; i++) {
            for(int j = 0;j<pC;j++){
                System.out.println(scores[i][j] + " ");
            }
            System.out.println();
        }

    }
}

