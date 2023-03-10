package com.company;

import java.util.Scanner;

public class ProblemB {

    public static int altSolve(int q, int m, int s, int l){

        int batches = l/m; //min batches needed to run on each machines
        int mod = l%m;//leftover batches for distribution
        int[] machinesTime = new int[m];

        for (int i = 0; i < m && batches > 0; i++) {
            machinesTime[i] += batches*q;
        }

        int i = 0;
        while (mod != 0){
            machinesTime[i] += q;
            mod--;
            i++;
        }// end of batch time distribution

        //free S time distribution
        while (i < m){
            if(i - 1 >= 0){
                int j = i;
                while (machinesTime[i-1] != machinesTime[j] && s > 0){
                    machinesTime[j]++;
                    s--;
                }
            }
            i++;
        }

        batches = s/m;
        mod = s%m;
        for (i = 0; i < machinesTime.length ; i++) {
            machinesTime[i] += batches;
        }

        if (mod > 0){
            return machinesTime[0] + 1;
        }
        return machinesTime[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        int q,m,s,l;
        q = Integer.parseInt(numbers[0]);
        m = Integer.parseInt(numbers[1]);
        s = Integer.parseInt(numbers[2]);
        l = Integer.parseInt(numbers[3]);

        System.out.println(altSolve(q,m,s,l));
    }
}
