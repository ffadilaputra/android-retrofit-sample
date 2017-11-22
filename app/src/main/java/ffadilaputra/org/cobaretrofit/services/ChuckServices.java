package ffadilaputra.org.cobaretrofit.services;

import ffadilaputra.org.cobaretrofit.model.ChuckNorrisQuote;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ardha_winata on 22-Nov-17.
 */

public interface ChuckServices {
    @GET("jokes/random")
    Call<ChuckNorrisQuote> getQuote();
}
