import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to task02.");

        //read all files, and put into List<String> as we are reading, 
        File directory = new File(args[0]); 
        List<String> textList = new LinkedList<>();
        for (File f: directory.listFiles()) {
            String finalAnswer = "";
            
            BufferedReader br = new BufferedReader(new FileReader(f));
            String temp = br.readLine();
            //System.out.println(temp);
            while(temp != null) {
                finalAnswer += temp;
                temp = br.readLine();
            }

            finalAnswer = finalAnswer.replaceAll("[^a-zA-Z ]", "");
            finalAnswer.toLowerCase();
            textList.add(finalAnswer);
        }
        
        //System.out.println(textList.toString());
        //process the data and store them in hashmap<first,hashmap<2nd,count>>
        HashMap<String, SecondWordCount> firstWordToHashMap = new HashMap<>();
        for(int i=0; i<textList.size(); ++i) {
            String[] temp = textList.get(i).split(" ");
            System.out.println(temp[0] + " " + temp[1]);

            for(int j=0; j<temp.length - 1; ++j) {
                String firstWord = temp[j];
                String secondWord = temp[j+1];
                if(firstWordToHashMap.containsKey(firstWord)) { //check if firstWord exists in HashMap, then check secondWord if exist in class
                    firstWordToHashMap.get(firstWord).addWord(secondWord);
                    continue;
                } 
                HashMap<String, Integer> secondWordHash = new HashMap<>();
                secondWordHash.put(secondWord, 1);
                SecondWordCount secondWordCount = new SecondWordCount(firstWord, secondWordHash);
                firstWordToHashMap.put(firstWord, secondWordCount);
            }
        }
        
        //calculate probability and print out
        for(Map.Entry<String, SecondWordCount> set: firstWordToHashMap.entrySet()) {
            //System.out.println(set.getValue().toString());
            String firstWord = set.getKey();
            System.out.println(firstWord);
            HashMap<String, Integer> secondWordHash = set.getValue().getMap();
            for(Map.Entry<String, Integer> set2: secondWordHash.entrySet()) {
                double probability = (double) set2.getValue()/set.getValue().getWordCount();
                System.out.println("    " + set2.getKey() + " " + probability);
            }
        }

    }
}
