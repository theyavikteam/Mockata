package com.theyaviktea.mockatadroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.theyavikteam.mockatacore.core.Mockata;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MockataActivity extends AppCompatActivity {

    TextView tvDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mockata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDog = (TextView) findViewById(R.id.tv_dog);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Dog> dogs = new ArrayList<>();
                try {
                    dogs = Mockata.createMockata(Dog.class, 10);
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (java.lang.InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                String s = "";
                for (Dog d : dogs) {
                    if (d != null) {
                        s += d.toString() + "\n";
                    }
                }
                if (tvDog != null)
                    tvDog.setText(s);
            }
        });
    }
}
