package com.motion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    // Uncomment the filepaths for each of the tests!

    //static final  String filePath = "a_example.txt";
    //static final  String filePath = "b_small.txt";
    static final  String filePath = "c_medium.txt";
    //static final  String filePath = "d_quite_big.txt";
    //static final  String filePath = "e_also_big.txt";

    static int maxSlice;
    static int length;
    static List<Integer> pizzaArray = new ArrayList<>();
    static List<Integer> outPutNums = new ArrayList<>();


    public static void main(String[] args) {
	    readFile(); // Reads the file and populates vars
	    result2(pizzaArray);
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

    public static void result2(List<Integer> arr){
        int max = 0;
        int difference = 0;
        int maxFromBack = 0;
        int maxFromFront = 0;
        int maxMiddle = 0;
        for (int i = arr.size() - 1; i>=0; i--){
            int newMax = arr.get(i) + max;
            if((newMax > max) && newMax <= maxSlice ){
                max = newMax;
                outPutNums.add(i);
                arr.remove(i);
            }else {
                difference = maxSlice - max;
                break;
            }
        }
        for (int i = arr.size() - 1; i>= 0; i--){
            if(maxFromBack + arr.get(i) <= difference){
                maxFromBack += arr.get(i);
            }

            if(maxFromFront + arr.get(arr.size() - i -1) <= difference){
                maxFromFront += arr.get(i);
            }
        }
        if(maxFromBack >= maxFromFront){
            max += maxFromBack;
        }else{
            max += maxFromFront;
        }

        double percentDiff = (1- (double)max / maxSlice) * 100;
        System.out.println("Max: "+maxSlice);
        System.out.println("Result: "+ max);
        System.out.println("Difference: "+ (maxSlice-max));
        System.out.println("Percent Diff: "+percentDiff+"%");

        Collections.reverse(outPutNums);
        System.out.println(outPutNums.size());
        System.out.println(outPutNums);
        System.out.println(arr);
        System.out.println(difference);
    }
}
