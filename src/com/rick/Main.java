package com.rick;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> inputLines = vraagInput();
        for (int i = 0; i<inputLines.size(); i++){
            System.out.println(inputLines.get(i));
        }
    }

    private static ArrayList<String> vraagInput() {
        System.out.println("Plak hier input-tabel");
        Scanner sc = new Scanner(System.in);

        ArrayList<String> inputLines = new ArrayList<String>();
        for (int i = 0; i < 49; i++){
            inputLines.add(sc.nextLine());
        }
        sc.close();
        return inputLines;
    }
}
