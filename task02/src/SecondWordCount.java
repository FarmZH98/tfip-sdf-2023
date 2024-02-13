import java.util.HashMap;

public class SecondWordCount {

    private String firstWord;
    private HashMap<String, Integer> map;
    private Integer wordCount;

    public SecondWordCount(String firstWord, HashMap<String, Integer> map) {
        this.firstWord = firstWord;
        this.map = map;
        this.wordCount = 1;
    }

    public HashMap<String, Integer> getMap() {
        return this.map;
    }


    public void setMap(HashMap<String, Integer> map) {
        this.map = map;
    }

    public void addWord(String word) {
        //System.out.println(word);
        if(this.map.containsKey(word)) {
            this.map.put(word, this.map.get(word) + 1);
        } else {
            this.map.put(word, 1);
        }
        this.wordCount++;
    }

    public Integer getWordCount() {
        return wordCount;
    }

    @Override
    public String toString() {
        return "SecondWordCount [firstWord=" + firstWord + ", map=" + map + ", wordCount=" + wordCount + "]";
    }

    
    
}
