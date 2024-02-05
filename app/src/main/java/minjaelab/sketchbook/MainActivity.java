package minjaelab.sketchbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import minjaelab.sketchbook.app1.Page1Activity;
import minjaelab.sketchbook.app1.fragment.FragmentA;
import minjaelab.sketchbook.app1.fragment.FragmentB;
import minjaelab.sketchbook.app1.fragment.FragmentC;
import minjaelab.sketchbook.app1.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity
{
    private Button app1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectViews();
        addListenersToTheViews();

    }

    private void connectViews() {
        app1    =   findViewById(R.id.app1);
    }

    private void addListenersToTheViews(){
        app1.setOnClickListener(view ->{
            Intent intent = new Intent(MainActivity.this, Page1Activity.class);
            startActivity(intent);
        });
    }
}