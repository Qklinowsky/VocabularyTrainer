package pl.com.kondzio.glosbe;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GlosbeClient {
    private GlosbeService glosbeService;
    public GlosbeClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://glosbe.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        glosbeService = retrofit.create(GlosbeService.class);
    }

    public List<GlosbeTranslation> getTranslation(String word) {
        try {
            GlosbeResponse body = glosbeService.fetchTranslation("pol", "eng", "json", word, true).execute().body();
            return body.getTuc();
        } catch (IOException e) {
            e.printStackTrace();

        }


        return Collections.EMPTY_LIST;
    }
}
