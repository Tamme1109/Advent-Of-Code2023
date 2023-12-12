package AOC23;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class question4 {
    public static void main(String[] args) throws IOException{
        question4 q4 = new question4();
        q4.run();
    }
    public void run() throws IOException{
        String scratchTextAll = Files.readString(Path.of("Stairs.txt"));
        String[] scratchText1 = scratchTextAll.split("\n");
     //   System.out.println(sumOfAllWins(scratchText1));
       // System.out.println(sumOfAllWins(copyAllCards(scratchText1)));
        System.out.println(allTickets(scratchText1));

        System.out.println("Dick");
    }

    public int sumOfAllWins(List <String> allScratchcards){
        int result = 0;
        for (String string : allScratchcards) {
            result += copyCards(string);
        }
        return result;
    }

    public int oneWin(String strArr){
        int result = 0;
        String[] splitValues = strArr.split("\\s+");
        for (int i = 2; i < findMiddle(splitValues) ; i++) {
            for (int j = findMiddle(splitValues); j < splitValues.length; j++) {
            if(splitValues[i].equals(splitValues[j])){
              //  System.out.println("Values: "+splitValues[i] +" and " + splitValues[j] );
                if(result == 0){
                    result = 1;
                    break;
                }
                else{
                    result *= 2;
                    break;
                }
            }
        }
        }
        return result;

    }

    public int copyCards(String strArr){
        int result = 0;
        String[] splitValues = strArr.split("\\s+");
        for (int i = 2; i < findMiddle(splitValues) ; i++) {
            for (int j = findMiddle(splitValues); j < splitValues.length; j++) {
            if(splitValues[i].equals(splitValues[j])){
             //   System.out.println("Values: "+splitValues[i] +" and " + splitValues[j] );
                result++;
            }
        }
        }
      //  System.out.println(result);
        return result;
    }

    public List<String> copyAllCards(String[] stringArray){
        List <String> allGames = new ArrayList<>();
        for (int i = 0; i < stringArray.length; i++) {
            for (int j  = i+1; j < i+1 + copyCards(stringArray[i]); j++) {
                allGames.add(stringArray[j]);
            }
        }
        for (int i = 0; i < stringArray.length; i++) {
            allGames.add(stringArray[i]);
        }
        return allGames;
    }


    public int allTickets(String[] games){
        int[] everyTicket = new int[games.length];
        for (int i = 0; i < everyTicket.length; i++) {
            everyTicket[i] = 1;
        }
        for (int i = 0; i < games.length; i++) {
            int j = copyCards(games[i]);
            for (int k = i + 1; k < 1+ i + j; k++) {
                everyTicket[k] += everyTicket[i];
                System.out.println(everyTicket[i]);
            }
            
        }
        int result = 0;
        for (int i = 0; i < everyTicket.length; i++) {
            result += everyTicket[i];
        }
        return result;
    }


    public int findMiddle(String[] str){        
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals("|")){
                return i;
            }
        }
        return -1;
    }
}
