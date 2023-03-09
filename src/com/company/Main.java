package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 11;
        while(sc.hasNextInt()){
            number = sc.nextInt();
            if(number % 2 == 0){
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
        }
    }
}
