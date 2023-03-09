package com.company;

import java.util.Scanner;

class Node{
    private String ch;
    private Node dirUp, dirRight, dirDown, dirLeft;

    public void mirrorY(){
        Node temp = dirRight;
        dirRight = dirLeft;
        dirLeft = temp;
    }

    public void mirrorX(){
        Node temp = dirUp;
        dirUp = dirDown;
        dirDown = temp;
    }
    //rotate 90° to the left
    public void rotate(){
        Node temp = dirUp;
        dirUp = dirRight;
        dirRight = dirDown;
        dirDown = dirLeft;
        dirLeft = temp;
    }

    public Node(){
        ch = ".";
        dirUp = null;
        dirRight = null;
        dirDown = null;
        dirLeft = null;
    }

    public Node(String str){
        ch = str;
        dirLeft = null;
        dirDown = null;
        dirRight = null;
        dirUp = null;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public Node getDirUp() {
        return dirUp;
    }

    public void setDirUp(Node dirUp) {
        this.dirUp = dirUp;
    }

    public Node getDirRight() {
        return dirRight;
    }

    public void setDirRight(Node dirRight) {
        this.dirRight = dirRight;
    }

    public Node getDirDown() {
        return dirDown;
    }

    public void setDirDown(Node dirDown) {
        this.dirDown = dirDown;
    }

    public Node getDirLeft() {
        return dirLeft;
    }

    public void setDirLeft(Node dirLeft) {
        this.dirLeft = dirLeft;
    }



}

public class ProblemC {

    public static Node build(int i, int j){
        return null;
    }

    public static void main(String[] args){
        int inputLines = 6;
        Scanner sc = new Scanner(System.in);
        String[][] input = new String[inputLines][];
        for (int i = 0; i < inputLines; i++) {
            input[i] = sc.nextLine().split("");
        }

        for (int i = 0; i < inputLines; i++) {
            for (int j = 0; j < inputLines; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
}
