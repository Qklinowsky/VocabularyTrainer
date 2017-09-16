package pl.com.kondzio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

public class PhraseExporter {
    public void export(File file, List<Phrase> phraseList) {
        try {
            PrintWriter out = new PrintWriter(file);
            for (Phrase phrase : phraseList) {

                LocalDateTime threeDaysAgo = LocalDateTime.now().minus(3, ChronoUnit.DAYS);
                LocalDateTime trainingDateLocal = phrase.getTrainingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                int newKnowledge;
                if (trainingDateLocal.isBefore(threeDaysAgo)) {
                    newKnowledge = phrase.getKnowledge() - 2;
                } else {
                    newKnowledge = phrase.getKnowledge();
                }
                String serializedPhrase = phrase.getWord() + "," + phrase.getTranslation() + "," + newKnowledge + "," + Dictionary.DATE_FORMAT.format(phrase.getTrainingDate());
                out.println(serializedPhrase);
            }
            out.close();
            System.exit(0);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

