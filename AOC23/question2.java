package AOC23;
import java.io.IOException;
import java.lang.System;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class question2 {

    public IntColor red = new IntColor(12, "red");
    public IntColor green = new IntColor(13, "green");
    public IntColor blue = new IntColor(14, "blue");

    public static void main(String[] args) throws IOException{

        new question2().Program();
    }
    void Program() throws IOException{
        String str = Files.readString(Path.of("Stairs.txt"));
        String[] allGames = str.split("\n");
        System.out.println(allCorrectGames(allGames));
        System.out.println(lowestBallAmountMulitplicationallGames(allGames));


    }
    //----------------------------------------Part A-------------------------------------------------//
    public int allCorrectGames(String[] strArr){
        int total = 0;
         for (int i = 0; i < strArr.length; i++) {
            if(singleGameExists(strArr[i])){
            total += (i+1);
            }

        }
        return total;
    }

    public boolean singleGameExists(String str){
        boolean existsRed = false;
        boolean existsGreen = false;
        boolean existsBlue = false;
        
        String[] newStr = str.split(" ");
        for (int i = 0; i < newStr.length; i++) {
            if (newStr[i].startsWith(red.color)) {
                if (Integer.parseInt(newStr[i-1]) <= red.amount)
                 {
                    existsRed = true;
                }
                else{
                    existsRed = false;
                    break;
                }
                
            }
            else if (newStr[i].startsWith(green.color)) {
                if (Integer.parseInt(newStr[i-1]) <= green.amount) {
                    existsGreen = true;
                }
                else{
                    existsGreen = false;
                    break;
                }

            }

            else if (newStr[i].startsWith(blue.color)) {
                if (Integer.parseInt(newStr[i-1]) <= blue.amount) {
                    existsBlue = true;
                }
                else{
                    existsBlue = false;
                    break;
                }
            }

        }
        return existsRed && existsGreen && existsBlue;


    }
    //----------------------------------------Part B-------------------------------------------------//

    public int lowestBallAmountMulitplicationallGames(String[] strArr){
        int amount = 0;
        for (String string : strArr) {
            amount += lowestBallAmountMulitplication(string);
        }
        return amount;
    }


    public int lowestBallAmountMulitplication(String str){
        IntColor allReds = new IntColor(0, "red");;
        IntColor allGreens = new IntColor(0, "green");;
        IntColor allBlue = new IntColor(0, "blue");;
        
        String[] newStr = str.split(" ");
        for (int i = 0; i < newStr.length; i++) {
            if (newStr[i].startsWith(allReds.color)) {
                if (Integer.parseInt(newStr[i-1]) > allReds.amount){
                    allReds.amount = Integer.parseInt(newStr[i-1]);
                }   
            }
            else if (newStr[i].startsWith(allGreens.color)) {
                if (Integer.parseInt(newStr[i-1]) > allGreens.amount){
                    allGreens.amount = Integer.parseInt(newStr[i-1]);
                }   
            }

            else if (newStr[i].startsWith(allBlue.color)) {
             if (Integer.parseInt(newStr[i-1]) > allBlue.amount){
                allBlue.amount = Integer.parseInt(newStr[i-1]);
                }             
            }

        }
        return allReds.amount * allGreens.amount * allBlue.amount;
    }

    //----------------------------------------Classes-------------------------------------------------//

    public class IntColor{
         int amount;
         String color;

        public IntColor(int amount, String color){
            this.amount = amount;
            this.color = color;
        }
    }
}