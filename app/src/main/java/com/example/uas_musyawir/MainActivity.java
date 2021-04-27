package com.example.uas_musyawir;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView txtJSON;
    Button btnJSON;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.username);
         editText = findViewById(R.id.password);
        btnJSON = findViewById(R.id.button);

        btnJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = APIConfig.loadData();

                APIConfig showData = retrofit.create(APIConfig.class);
                showData.postData().enqueue(new Callback<MahasantriResponse>() {
                    @Override
                    public void onResponse(Call<MahasantriResponse> call, Response<MahasantriResponse> response) {
                        if (response != null){
                            MahasantriResponse mahasantriResponse = response.body();
                            List<DataMahasantri> dataMahasantri = mahasantriResponse.getDataMahasantri();

                            if (dataMahasantri == null){
                                Toast.makeText(MainActivity.this,"Data null", Toast.LENGTH_SHORT);
                            }else {
                                for (int i = 0; i < dataMahasantri.size(); i++){
                                    txtJSON.append(

                                            dataMahasantri.get(i).getId()+". "+
                                                    dataMahasantri.get(i).getNama()+" "+
                                                    dataMahasantri.get(i).getKelas()+"\n\n"

                                    );
                                }
                            }
                        }else {
                            Toast.makeText(MainActivity.this,"Response null", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MahasantriResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}