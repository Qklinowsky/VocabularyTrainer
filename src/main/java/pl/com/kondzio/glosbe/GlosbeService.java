package pl.com.kondzio.glosbe;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GlosbeService {
    @GET("gapi/translate")
    Call<GlosbeResponse> fetchTranslation(@Query("from") String fromLanguage,
                                          @Query("dest") String destinationLanguage,
                                          @Query("format") String format,
                                          @Query("phrase") String phrase,
                                          @Query("pretty") boolean pretty);
    //https://glosbe.com/gapi/translate?from=pol&dest=eng&format=json&phrase=witaj&pretty=true
}
