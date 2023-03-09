package com.company;

import java.util.Scanner;

public class ProblemB {

    public static int slowSolver(int q, int m, int s, int l){
        //buckets létrehozás
        int[] machinesTime = new int[m];

        int temp1 = l/m;//min starting value
        int temp2 = l%m;//leftover for distribution
        int firstUneven = -1;

        for (int i = 0; i < machinesTime.length; i++) {
            //min starting value
            machinesTime[i] += temp1*q;
            //distribute leftover
            if (temp2 > 0){
                machinesTime[i] += q;
                temp2--;
            } else if(firstUneven == -1){
                firstUneven = i;
            }
        }

        if (s == 0 || s < q){
            return machinesTime[0];
        }

        temp1 = s/m;
        temp2 = s%m;

        for (int i = firstUneven; i < machinesTime.length && temp1 != 0; i++) {
            machinesTime[i] += temp1;
            temp1 -= temp1;
        }

        /*if (temp1 == 0){

        }*/

        for (int i = 0; i < machinesTime.length && temp2 != 0; i++) {
            machinesTime[i] += temp2;
            temp2 -= temp2;
        }

        return machinesTime[0];
    }

    public static int solve(int q, int m, int s, int l){
        //buckets létrehozás
        int[] machinesTime = new int[m];

        int temp1 = l/m;//min starting value
        int temp2 = l%m;//leftover for distribution

        for (int i = 0; i < machinesTime.length; i++) {
            //min starting value
            machinesTime[i] += temp1*q;
            //
            if (temp2 > 0){
                machinesTime[i] += q;
                temp2--;
            } else if (s > 0 && s >= q){
                machinesTime[i] += q;
                s -= q;
                if (s < q){
                    //todo: s > 0 && s < q; DONE?
                    return machinesTime[0];
                }
            }
        }

        if (s == 0){
            return machinesTime[0];
        }

        temp1 = s/m;
        temp2 = s%m;
        for (int i = 0; i < machinesTime.length; i++) {
            if(temp1 > 0) {
                machinesTime[i] += temp1;
                temp1 -= temp1;
            } else if(temp2 > 0) {
                machinesTime[i] += temp2;
                temp2--;
            } else {
                return machinesTime[0];
            }
        }

        return machinesTime[0];
    }

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
        while (i < m && s > q){
            //todo :s>q ki venni
                machinesTime[i] += q;
                s -= q;
                i++;
            /*
            else {
                if (m > 1 && i !=0){

                }
                i++;
                //machinesTime[i] += s;
                //return machinesTime[0];
            }*/
        }
        if(i > 0){
            return machinesTime[0];
        }

        batches = s/m;
        mod = s%m;
        for (i = 0; i < m ; i++) {
            machinesTime[i] += batches;
        }

        if (mod > 0){
            return machinesTime[0] + 1;
        }
        return machinesTime[0];
    }

    public static int evenSolve(int q, int m, int s, int l){
        int[] machinesTime = new int[m];
        int batches = l + s/q; // free time steps divided into batches adding free batches with stander batches
        int divBatches = batches/m; // sum of batches evenly divided between the number of machines
        int modBatches = batches % m; // the number of leftover batches for distribution
        int modFreeTime = s%q; // leftover free time
        int disFreeTime;
        for (int i = 0; i < machinesTime.length; i++) {
            machinesTime[i] += divBatches*q;
        }

        int i = 0;
        while (i < machinesTime.length && modBatches != 0){
            machinesTime[i] += q;
            modBatches--;
            i++;
        }

        if(i < machinesTime.length) {
            disFreeTime = modFreeTime / (m - i); // free time div number of machines for even distribution
            modFreeTime %= m - i; // leftover free time after even distribution between machines;
        } else {
            disFreeTime = modFreeTime / m; // free time div number of machines for even distribution
            modFreeTime %= m; // leftover free time after even distribution between machines;
            i = 0;
        }

        for (int j = i; j < machinesTime.length; j++) {
            machinesTime[j] += disFreeTime;
        }

        if (modFreeTime > 0){
            return machinesTime[0] + 1;
        } else{
            return machinesTime[0];
        }

    }

    public static int stackSolve(int q, int m, int s, int l){
        int[] machinesTime = new int[m];
        int i = 0;
        while (i < m){
            machinesTime[i] += l / m * q ;
            i++;
        }
        i = (i >= m) ? 0 : i;
        while (i< l%m){
            machinesTime[i] += q;
            i++;
        }

        i = (i >= m) ? 0 : i;
        while (i < s%m){
            machinesTime[i] += s%m;
            i++;
        }

        return  machinesTime[0];
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
        //System.out.println(stackSolve(q,m,s,l));
        //System.out.println(evenSolve(q,m,s,l));
    }
}
