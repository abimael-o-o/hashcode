package com.motion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //static final  String filePath = "a_example.txt";
    //static final  String filePath = "b_small.txt";
    //static final  String filePath = "c_medium.txt";
    static final  String filePath = "d_quite_big.txt";
    //static final  String filePath = "e_also_big.txt";

    static int maxSlice;
    static int length;
    static List<Integer> pizzaArray = new ArrayList<>();


    public static void main(String[] args) {
	    readFile();
	    result(pizzaArray);
    }

    public static void readFile(){
        File file = new File(filePath);
        try(Scanner input = new Scanner(file)) {
            maxSlice = Integer.parseInt(input.next());
            length = Integer.parseInt(input.next());
            int counter = 0;
            while (input.hasNext()){
               pizzaArray.add(Integer.parseInt(input.next()));
               counter++;
           }
        }catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }

    public static void result(List<Integer> arr){
        int max = arr.get(0);
        int starter = arr.get(0);
        int lastIndex = 0;

        for (int i = 1; i<arr.size(); i++){
            int newMax = starter + arr.get(i);
            if(newMax > max && newMax < maxSlice ){
                max = newMax;
                lastIndex = i;
            }
            starter = arr.get(i);
        }
        pizzaArray.remove(lastIndex);
        pizzaArray.remove(lastIndex-1);

        for (int i = 0; i < arr.size(); i++){
            int newMax = max + arr.get(i);
            if(newMax > max && newMax < maxSlice ){
                max = newMax;
            }
        }


        System.out.println("Max: "+maxSlice);
        System.out.println("Result: "+ max);
        System.out.println("Difference: "+ (maxSlice-max));

    }
}
