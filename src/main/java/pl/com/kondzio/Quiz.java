package pl.com.kondzio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Phrase> phraseToLearn;
    private Random randomGenerator;


    public Quiz(ArrayList<Phrase> phraseToLearn) {

        this.phraseToLearn = phraseToLearn;
        this.randomGenerator = new Random();
    }

    public void startQuiz() {
        if (phraseToLearn.size() < 2) {
            System.out.println("Za mało słowek! Dodaj więcej.");
            return;
        }
        for (Phrase phrase : phraseToLearn) {

            System.out.println("Znajdz tlumaczenie slowa " + phrase.getWord());
            int i = randomGenerator.nextInt(3) + 1;
            for (int j = 1; j < 4; j++) {
                if (i == j) {
                    System.out.println(j + "-" + phrase.getTranslation());
                } else {
                    System.out.println(j + "-" + randomPhrase(phrase).getTranslation());
                }
            }

            Scanner scanner = new Scanner(System.in);
            if (Integer.parseInt(scanner.nextLine()) == i) {
                phrase.increaseKnowledge();
                phrase.setTrainingDate(new Date());
                System.out.println("dobrze.");
            } else {
                System.out.println("Bład!");
                phrase.decreaseKnowledge();
            }
        }
        System.out.println();
    }

    private Phrase randomPhrase(Phrase except) {
        Phrase phrase = null;
        do {
            int index = randomGenerator.nextInt(phraseToLearn.size());
            phrase = phraseToLearn.get(index);
        } while (phrase == except);
        return phrase;
    }

    public void startQuiz2() {
        for (Phrase phrase : phraseToLearn) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Słówko do przetlumacznia: " + phrase.getWord());
            String translate = scanner.nextLine();
            if (translate.equals(phrase.getTranslation())) {
                System.out.println("Dobrze, przejdźmy do kolejnego słówka.");
                phrase.increaseKnowledge();
                phrase.setTrainingDate(new Date());
            } else {
                System.out.println("Źle!");
                phrase.decreaseKnowledge();
            }
        }
    }
}
