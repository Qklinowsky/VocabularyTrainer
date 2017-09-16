package pl.com.kondzio;

import java.util.Date;

public class Phrase {

    private String word;
    private String translation;
    private Integer knowledge;
    private Date trainingDate;

    public Phrase(String word, String translation) {
        this(word, translation, 0, new Date(0));
    }

    public Phrase(String word, String translation, Integer knowledge, Date date) {
        this.word = word;
        this.translation = translation;
        this.knowledge = knowledge;
        this.trainingDate = date;
    }

    public int getKnowledge() {
        return knowledge;
    }

    public String getTranslation() {
        return translation;
    }

    public String getWord() {
        return word;
    }

    public void increaseKnowledge() {
        knowledge += 1;
    }

    public void decreaseKnowledge() {
        if (knowledge > 0) {
            knowledge -= 1;
        }
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(Date trainingDate) {
        this.trainingDate = trainingDate;
    }


}
