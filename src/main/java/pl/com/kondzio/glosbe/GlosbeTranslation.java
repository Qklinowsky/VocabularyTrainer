package pl.com.kondzio.glosbe;

import java.util.List;

public class GlosbeTranslation {
    private GlosbyPhrase phrase;
    private List<GlosbyPhrase> meanings;

    public GlosbyPhrase getPhrase() {
        return phrase;
    }

    public void setPhrase(GlosbyPhrase phrase) {
        this.phrase = phrase;
    }

    public List<GlosbyPhrase> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<GlosbyPhrase> meanings) {
        this.meanings = meanings;
    }
}
