package AOC23;
import java.io.IOException;
import java.lang.System;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import javax.swing.text.AttributeSet.CharacterAttribute;
public class question3 {


    public static void main(String[] args) throws IOException {
        question3 q3 = new question3();
        q3.run();
    }
    int around[][] = {   {-1,-1},
                         {-1,0},
                         {-1,1},
                         {0,-1},
                         {0,1},
                         {1,-1},
                         {1,0},
                         {1,1}
                        };

    public void run() throws IOException{
        int[] arr = {1, 3, 6, 2, 23, 54, 21, 76, 33, 91};
        istammeapedo(20, arr);
        String str = Files.readString(Path.of("Stairs.txt"));
        String[] allRows = str.split("\n");
        System.out.println(allRows.length);
        System.out.println(allRows[0].length());
        char[][] grid = arrToMatrix(allRows);

        System.out.println(valuetoSymbol(grid));
    }

    public char[][] arrToMatrix(String [] array){
        char[][] matrix = new char[array.length][array[0].trim().length()]; 
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = array[i].charAt(j);
            }
        }
        return matrix;
    }

    public int valuetoSymbol(char[][] matrix) {
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(isSymbol(matrix[i][j])){
                    int next = 0;
                    int number1 = 1;
                    int number2 = 1;                    
                    for (int i2 = 0; i2 < around.length; i2++) {
                        int row = around[i2][0];
                        int col = around[i2][1];
                            if(!((i + row < 0) || (i + row >=matrix.length) || (j + col < 0) || (j + col >= matrix[0].length))){
                                if (Character.isDigit(matrix[i + row][j + col])) {
                                    next++;
                                    String number = "";
                                    int newCol = j;
                                    while (!(newCol + col < 0) && Character.isDigit(matrix[i + row][newCol + col])) {
                                        number = Character.toString(matrix[i + row][newCol + col]).concat(number);
                                        newCol--;
                                }
                                    newCol = j+ 1;
                                        while (!(newCol + col >= matrix[0].length) && Character.isDigit(matrix[i + row][newCol + col])) {

                                        number = number.concat(Character.toString(matrix[i + row][newCol + col]));
                                        newCol++;
                                        if(around[i2][1] < 1){
                                        i2++;
                                        }
                                        
                                    }
                                    if(next == 1){
                                        number1 = Integer.parseInt(number);

                                    }
                                    else if(next == 2){
                                        number2 = Integer.parseInt(number);
                                    }

                                    if((matrix[i][j] == '*') && next ==2){
                                         value += number1*number2;
                                      //  System.out.println(number1*number2);
                                        //System.out.println("negative " + number1);
                                    }
                                        
                                }
                               
                            }
                    }
                }
            }
        }
        return value;
    }
        




    public boolean isSymbol(char symbol){
        return (!Character.isDigit(symbol) && !('.' == symbol));
    }

    public  void istammeapedo(int womanage, int[] tammedickaccept){
        for(int girl = 0;  girl < tammedickaccept.length; girl++){
            if(tammedickaccept[girl] <= womanage){
                System.out.println("Of course tamme likes a girl that's " + tammedickaccept[girl]+ " years old!");
            }
        }
        
    }

}
