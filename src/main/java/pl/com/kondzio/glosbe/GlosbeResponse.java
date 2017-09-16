package pl.com.kondzio.glosbe;

import java.util.List;

public class GlosbeResponse {
    private String result;
    private List<GlosbeTranslation> tuc;
    private String phrase;
    private String from;
    private String dest;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<GlosbeTranslation> getTuc() {
        return tuc;
    }

    public void setTuc(List<GlosbeTranslation> tuc) {
        this.tuc = tuc;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

}