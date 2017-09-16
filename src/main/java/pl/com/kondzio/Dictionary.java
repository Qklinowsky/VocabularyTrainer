package pl.com.kondzio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    List<Phrase> phraseList = new ArrayList();

    public Dictionary(List<Phrase> phraseList) {
        this.phraseList = phraseList;
    }

    public void add(Phrase newPhrase) {
        phraseList.add(newPhrase);
    }

    public ArrayList<Phrase> get10PhraseToLearn() {
        ArrayList<Phrase> phrasesToLearn = new ArrayList<>();
        for (Phrase phrase : phraseList) {
            if (phrase.getKnowledge() < 5) {
                phrasesToLearn.add(phrase);
            }
            if (phrasesToLearn.size() == 10) {
                break;
            }

        }
        return phrasesToLearn;
    }

    public List<Phrase> getAllPhrases() {
        return phraseList;
    }

}
