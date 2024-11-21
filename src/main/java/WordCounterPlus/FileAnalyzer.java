package WordCounterPlus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class FileAnalyzer {
    private String filestr;

    public FileAnalyzer(String filestr) {
        this.filestr = filestr;
    }

    //获取一个文件内的单词数
    public HashMap<String, Word> getWordCount() {
        var result = new HashMap<String, Word>();
        String line;
        //读取文件(try-resource)
        try (BufferedReader in = new BufferedReader(new FileReader(filestr))) {
            while ((line = in.readLine()) != null) {
                String[] words = line.split("\\s+");  //单词间使用空白字符分割
                for (String word : words) {
                    if (word != null && !word.isEmpty()) {
                        if (result.containsKey(word)) {
                            Word w = result.get(word);  //get到的是result里面的Word对象, 所以对它的修改会同步到里面去
                            w.setTimes(w.getTimes() + 1);
                        } else {
                            result.put(word, new Word(word, 1));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
