package pl.com.kondzio;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VocabularyImporter {

    public List<Phrase> importResult(File vocabularyfile) {
        List<Phrase> phraseList = new ArrayList<Phrase>();
        if (vocabularyfile.exists()) {
            Scanner phraseScanner = null;

            try {

                phraseScanner = new Scanner(vocabularyfile);
                while (phraseScanner.hasNext()) {
                    String line = phraseScanner.next();
                    String[] words = line.split(",");
                    String word = words[0];
                    String translation = words[1];
                    Integer knowledge = Integer.parseInt(words[2]);
                    String traningDateString = words[3];
                    Date traningDate = Dictionary.DATE_FORMAT.parse(traningDateString);
                    Phrase phrase = new Phrase(word, translation, knowledge, traningDate);
                    phraseList.add(phrase);


                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return phraseList;
    }
}
