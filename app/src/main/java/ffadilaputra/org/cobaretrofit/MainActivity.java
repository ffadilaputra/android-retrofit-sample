package ffadilaputra.org.cobaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ffadilaputra.org.cobaretrofit.generator.ServiceGenerator;
import ffadilaputra.org.cobaretrofit.model.ChuckNorrisQuote;
import ffadilaputra.org.cobaretrofit.services.ChuckServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ChuckServices chuckServices ;
    TextView txtData;
    ImageView imgChuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chuckServices = ServiceGenerator.createService(ChuckServices.class);
        txtData = (TextView)findViewById(R.id.txtData);
        imgChuck = (ImageView)findViewById(R.id.imgChuck);
        Call<ChuckNorrisQuote> call = chuckServices.getQuote();
        call.enqueue(new Callback<ChuckNorrisQuote>() {
            @Override
            public void onResponse(Call<ChuckNorrisQuote> call, Response<ChuckNorrisQuote> response) {
                txtData.setText(response.body().getValue());
                Picasso.with(getApplicationContext()).load(response.body().getIconUrl()).into(imgChuck);
            }


            @Override
            public void onFailure(Call<ChuckNorrisQuote> call, Throwable t) {
                txtData.setText(t.getMessage());
            }
        });



    }
}
