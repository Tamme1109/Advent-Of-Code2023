package AOC23;
import java.io.IOException;
import java.lang.System;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class question1 {
    public static void main(String[] args) throws IOException{

        new question1().Program();
    }

    public String[] stringDigits = new String[]{"one","two","three","four","five","six","seven","eight","nine"};
    public char[] digitchars = new char[]{'1','2','3','4','5','6','7','8','9'};
    
    void Program() throws IOException{

        String stairsMap = Files.readString(Path.of("Stairs.txt"));
        String[] arrayCode = stairsMap.split("\n");


        System.out.println(allStringDigits(arrayCode));
        System.out.println(stringDigit("six2eight579hlbgjnjkqrxrdlhnpfour"));
    }

    //-----------------------------------------TASK BELOW----------------------------------------//



    public int allStringDigits(String[] s){
        int count = 0;
        for(String codes : s){
          //  System.out.println(stringDigit(codes));
            count += stringDigit(codes);
        }
        return count;
    }
 

    public int stringDigit(String s){
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> digits = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){ 
           if (isDigit(s.charAt(i))){
               digits.add(s.charAt(i));
            }
            else if(isStringDigit(s.substring(i)) != 0){
                digits.add(isStringDigit(s.substring(i)));
            }
        }

        if(digits.size() > 1){
            sb.append(digits.get(0));
            sb.append(digits.get(digits.size() - 1));

            return Integer.parseInt(sb.toString());
        }
        else if(digits.size() == 1){
            sb.append(digits.get(0));
            sb.append(digits.get(0));
            return Integer.parseInt(sb.toString());
        }
        else{
            return 0;
        }
    }

    public boolean isDigit(char s){
        String chs = Character.toString(s);
        return ("123456789").contains(chs);
    }

    public char isStringDigit(String s){
       for (int i = 0; i < stringDigits.length; i++) {
            if(s.startsWith(stringDigits[i])){
            return digitchars[i];
            }
        }
        return 0;
    }
}

// abcone2threexyz