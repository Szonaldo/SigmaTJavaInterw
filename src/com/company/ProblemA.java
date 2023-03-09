package com.company;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loops = sc.nextInt();
        int number = -21;
        for(int i = 0; i < loops; i++){
            number = sc.nextInt();
            if(number % 2 == 0){
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }
        }
    }
}
