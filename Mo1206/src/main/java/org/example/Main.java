package org.example;

public class Main {
    public static void main(String[] args) {

        String str1= "rkqodlw";
        String str2= "woorld";

        SCRAMBLE scramble = new SCRAMBLE(str1, str2);

        System.out.println(scramble.scramble());


    }
}