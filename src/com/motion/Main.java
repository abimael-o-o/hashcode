package com.motion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static final  String filePath = "b_small.txt";
    static int maxSlice;
    static int length;
    static int[] pizzaArray;

    public static void main(String[] args) {
	    readFile();
    }

    public static void readFile(){
        File file = new File(filePath);
        try(Scanner input = new Scanner(file)) {
            maxSlice = Integer.parseInt(input.next());
            length = Integer.parseInt(input.next());
            pizzaArray = new int[length];
            int counter = 0;
            while (input.hasNext()){
               pizzaArray[counter] = Integer.parseInt(input.next());
               counter++;
           }
            
        }catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
