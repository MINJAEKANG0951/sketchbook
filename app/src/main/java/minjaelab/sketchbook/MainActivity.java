package minjaelab.sketchbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import minjaelab.sketchbook.apis.ApiService;
import minjaelab.sketchbook.apis.messengers.NaverMessenger;
import minjaelab.sketchbook.apis.models.ShortURLResponse;
import minjaelab.sketchbook.app1.Page1Activity;
import minjaelab.sketchbook.app1.fragment.FragmentA;
import minjaelab.sketchbook.app1.fragment.FragmentB;
import minjaelab.sketchbook.app1.fragment.FragmentC;
import minjaelab.sketchbook.app1.fragment.FragmentHome;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity
{
    private Button app1;
    private Button apiBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectViews();
        addListenersToTheViews();

    }

    private void connectViews() {
        app1        =   findViewById(R.id.app1);
        apiBtn      =   findViewById(R.id.apiBtn);
    }

    private void addListenersToTheViews(){
        app1.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, Page1Activity.class);
            startActivity(intent);
        });
        apiBtn.setOnClickListener(view -> {

            Retrofit retrofit = NaverMessenger.getRetrofitInstance();
            ApiService apiService = retrofit.create(ApiService.class);

            // Prepare your API call
            Call<ShortURLResponse> call = apiService.getShortUrl("1er3i2rvr9", "N5NgjlEPK0LNyBZYlsSaKY3FyVijhuN4fGiO5N1E", "http://www.google.co.kr");

            // Execute the call asynchronously
            call.enqueue(new Callback<ShortURLResponse>() {
                @Override
                public void onResponse(Call<ShortURLResponse> call, Response<ShortURLResponse> response) {
                    if (response.isSuccessful()) {
                        // Handle successful response
                        ShortURLResponse shortURLResponse = response.body();
                        // Here, you might want to update the UI with the result
                        // For example, display the short URL
                        runOnUiThread(() -> {
                            Toast.makeText(MainActivity.this, shortURLResponse.getResult().getHash(), Toast.LENGTH_SHORT).show();
                        });
                    } else {
                        // Handle request errors depending on status code
                        Log.e("API Error", "Response Code: " + response.code());
                    }
                }

                @Override
                public void onFailure(Call<ShortURLResponse> call, Throwable t) {
                    // Handle failure, such as a network error
                    Log.e("API Error", "Network Error: ", t);
                }
            });
        });
    }
}