package minjaelab.sketchbook.app1;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import minjaelab.sketchbook.R;
import minjaelab.sketchbook.app1.fragment.FragmentA;
import minjaelab.sketchbook.app1.fragment.FragmentB;
import minjaelab.sketchbook.app1.fragment.FragmentC;
import minjaelab.sketchbook.app1.fragment.FragmentHome;
import minjaelab.sketchbook.app1.fragment.callbackinterface.FragmentCommunicationInterface;

public class Page1Activity extends AppCompatActivity implements FragmentCommunicationInterface {
    private Context context;

    private TextView sayData;
    private TextView homeBtn;
    private TextView dataBag;

    private TextView btnA;
    private TextView btnB;
    private TextView btnC;

    private String savedData;

    private boolean turnOffNow;

    private OnBackPressedCallback onBackPressedCallback;


    // SketchBook - place for tests, Android - Java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);
        context = this;

        sayData = findViewById(R.id.sayData);
        homeBtn = findViewById(R.id.homeBtn);
        dataBag = findViewById(R.id.dataBag);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);


        if (savedInstanceState == null) // savedInstance  =  where android saves an activity's state. when an activity is first created, it has no state. so it's null.
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentHome())
                    .commit();
        }

        sayData.setOnClickListener(view -> {
            if (savedData != null) {
                Toast.makeText(this, savedData, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            }
        });
        homeBtn.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentHome())
                    .commit();
        });
        btnA.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentA())
                    .commit();
        });
        btnB.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentB())
                    .commit();
        });
        btnC.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentC())
                    .commit();
        });


        onBackPressedCallback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.section);

                if (fragment instanceof FragmentHome) {

                    if (!turnOffNow) {
                        turnOffNow = true;
                        Toast shortToast = Toast.makeText(context, "The app will close if the back button is clicked again.", Toast.LENGTH_SHORT);
                        shortToast.show();
                        new Handler().postDelayed(shortToast::cancel, 1000);
                        return;
                    }
                    finish();

                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.section, new FragmentHome())
                            .commit();
                    turnOffNow = false;
                }
            }
        };
        // Add the callback to the OnBackPressedDispatcher
        getOnBackPressedDispatcher().addCallback(this, onBackPressedCallback);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        onBackPressedCallback.remove();
    }

    @Override
    public void onFragmentInteraction(String data) {
        dataBag.setText(data);
    }
}
