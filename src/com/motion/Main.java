package com.motion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static final  String filePath = "b_small.txt";

    public static void main(String[] args) {
	    readFile();
    }

    public static void readFile(){
        File file = new File(filePath);
        try(Scanner input = new Scanner(file)) {
            if(input.hasNext()){
                System.out.println(input.next());
            }

        }catch (FileNotFoundException e){
            System.out.println(e.fillInStackTrace());
        }
    }
}
