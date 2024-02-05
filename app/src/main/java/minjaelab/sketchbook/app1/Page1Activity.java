package minjaelab.sketchbook.app1;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import minjaelab.sketchbook.R;
import minjaelab.sketchbook.app1.fragment.FragmentA;
import minjaelab.sketchbook.app1.fragment.FragmentB;
import minjaelab.sketchbook.app1.fragment.FragmentC;
import minjaelab.sketchbook.app1.fragment.FragmentHome;

public class Page1Activity extends AppCompatActivity
{
    private TextView sayData;
    private TextView homeBtn;
    private TextView currentFragment;

    private TextView btnA;
    private TextView btnB;
    private TextView btnC;

    private String savedData;


    // SketchBook - place for tests, Android - Java
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);

        sayData         =   findViewById(R.id.sayData);
        homeBtn         =   findViewById(R.id.homeBtn);
        currentFragment =   findViewById(R.id.currentFragment);
        btnA            =   findViewById(R.id.btnA);
        btnB            =   findViewById(R.id.btnB);
        btnC            =   findViewById(R.id.btnC);


        if (savedInstanceState == null) // savedInstance  =  where android saves an activity's state. when an activity is first created, it has no state. so it's null.
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentHome())
                    .commit();
        }

        sayData.setOnClickListener(view -> {
            if(savedData!=null) {
                Toast.makeText(this, savedData, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
            }
        });
        homeBtn.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentHome())
                    .addToBackStack(null)
                    .commit();
        });
        btnA.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentA())
                    .addToBackStack(null)
                    .commit();
        });
        btnB.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentB())
                    .addToBackStack(null)
                    .commit();
        });
        btnC.setOnClickListener(view -> {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.section, new FragmentC())
                    .addToBackStack(null)
                    .commit();
        });




    }
}
