package com.rick;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import com.opencsv.CSVWriter;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        ArrayList<String> inputLines = vraagInput();
        ArrayList<Werkdag> dagen = createWerkdagen(inputLines);
        verwijderVrijeDagen(dagen);

        schrijfNaarCSV(dagen);

        for (int i = 0; i<inputLines.size(); i++){
            System.out.println(inputLines.get(i));
        }
    }

    private static void schrijfNaarCSV(ArrayList<Werkdag> dagen) throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter("result.csv"));
        CSVWriter writer = new CSVWriter(out);
        String[] headers = {"Subject", "Start Date", "Start Time", "EndTime", "EndDate", "Location"};
        writer.writeNext(headers);
        for (Werkdag dag : dagen){
            String startDate = dag.getDatum();
            String startTime = dag.getBeginTijd();
            String endTime = dag.getEindTijd();
            writer.writeNext(new String[]{"Werken", startDate, startTime, endTime, startDate, "Jumbo Bert Vis Steenwijk"});
        }
        writer.close();
    }

    private static void verwijderVrijeDagen(ArrayList<Werkdag> dagen) {
        for (Iterator<Werkdag> iterator = dagen.iterator(); iterator.hasNext();){
            Werkdag dag = iterator.next();
            if (!dag.moetWerken) iterator.remove();
        }
    }

    private static ArrayList<Werkdag> createWerkdagen(ArrayList<String> inputLines) throws ParseException {
        for (int i = 0; i < 7; i++) inputLines.remove(0); //Troep bovenaan tabel eruit
        ArrayList<Werkdag> dagen = new ArrayList<Werkdag>();
        for (int j = 0; j < inputLines.size(); j = j + 6){
            String dagVanWeek = inputLines.get(j);
            String datum = inputLines.get(j + 1);
            String beginTijd = inputLines.get(j + 2);
            String eindTijd = inputLines.get(j + 3);
            Werkdag dag = new Werkdag(beginTijd, dagVanWeek, datum, eindTijd);
            dagen.add(dag);
        }
        return dagen;
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
