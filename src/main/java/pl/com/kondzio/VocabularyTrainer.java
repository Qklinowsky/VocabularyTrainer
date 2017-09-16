package pl.com.kondzio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class VocabularyTrainer {

    private static final String VOCABULARY_PLIK = "vocabulary.txt";

    public static void main(String[] args) {
        File vocabulary = new File(VOCABULARY_PLIK);
        VocabularyImporter vocabularyImporter = new VocabularyImporter();
        List<Phrase> phraseList = vocabularyImporter.importResult(vocabulary);
        Dictionary dictionary = new Dictionary(phraseList);

        UserInterface userInterface = new UserInterface();


        while (true) {
            userInterface.printOptions();
            String option = userInterface.readOption();

            switch (option) {
                case "1":
                    Phrase newWord = userInterface.readNewWord();
                    dictionary.add(newWord);
                    break;
                case "2":
                    ArrayList<Phrase> phraseToLearn = dictionary.get10PhraseToLearn();
                    Quiz quiz = new Quiz(phraseToLearn);
                    quiz.startQuiz();
                    break;
                case "3":
                phraseToLearn = dictionary.get10PhraseToLearn();
                Quiz quiz2 = new Quiz(phraseToLearn);
                quiz2.startQuiz2();
                break;
                case "4":
                    System.out.println("Zapisuje do pliku.");
                    List<Phrase>allPhrases = dictionary.getAllPhrases();
                    PhraseExporter phraseExporter = new PhraseExporter();
                    phraseExporter.export(vocabulary, allPhrases);



            }

        }
    }
}
