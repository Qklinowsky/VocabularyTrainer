package pl.com.kondzio;

import pl.com.kondzio.glosbe.GlosbeClient;
import pl.com.kondzio.glosbe.GlosbeTranslation;
import pl.com.kondzio.glosbe.GlosbyPhrase;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner consoleScanner;
    private GlosbeClient glosbyClient;

    UserInterface() {
        consoleScanner = new Scanner(System.in);
        glosbyClient = new GlosbeClient();
    }

    public void printOptions() {
        System.out.println("Wybierz opcje: \n 1. Dodaj słówko.\n 2. Trening. " +
                "\n 3. Trening opcja 2. \n 4. Zapisz słówka i wyjdź.");
    }

    public String readOption() {

        return consoleScanner.nextLine();
    }

    public Phrase readNewWord() {
        System.out.println("Podaj nowe słowo(Polskie)");
        String newWord = consoleScanner.nextLine();
        List<GlosbeTranslation> translations = glosbyClient.getTranslation(newWord);
        for (int i = 0; i < translations.size(); i++) {
            GlosbeTranslation translation = translations.get(i);
            if (translation.getPhrase() != null) {
                String meaning;
                if (translation.getMeanings() != null) {
                    meaning = translation.getMeanings().get(0).getText();
                } else {
                    meaning = "";
                }
                System.out.println(i + " - " + translation.getPhrase().getText() + " - " + meaning);
            }
        }
        System.out.println("Wybierz opcje lub podaj tłumacznie(Angielski)");
        String translation = consoleScanner.nextLine();
        if (isInteger(translation)) {
            return new Phrase(newWord, translations.get(Integer.parseInt(translation)).getPhrase().getText());
        }

        return new Phrase(newWord, translation);
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        return true;
    }
}
