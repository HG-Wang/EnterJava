package WordCounterPlus;

import org.jetbrains.annotations.NotNull;

public class Word implements Comparable<Word>{
    private String text;
    private int times;

    public String getText(){
        return text;
    }
    public int getTimes(){
        return times;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public Word(String text,int times) {
        this.times = times;
        this.text = text;
    }

    //定义两个单词的排序, 逆序输出
    public int compareTo(@NotNull Word a) {
        return (-1)*(this.getTimes() - a.getTimes());
    }
}
