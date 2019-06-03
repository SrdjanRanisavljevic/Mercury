package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Skener {

    public static final String bulja = String.valueOf('b');

    public String cupanjeOCD() {


        try {

            File file = new File("C:\\Users\\Srdjan.Ranisavljevic\\Desktop\\PROBA.txt");

            ArrayList<String> document = new ArrayList<>();

            Scanner sc = new Scanner(file);


            int i = 0;
            while (sc.hasNextLine()) {
                document.add(sc.nextLine());
                i++;
            }
            String outContractID = (document.get(13));
            String OCD = outContractID.substring(14, 24);
            return OCD;

        } catch (Exception e) {
            System.out.println("JEBGA Eksepshn");
            return bulja;
        }

    }
}
