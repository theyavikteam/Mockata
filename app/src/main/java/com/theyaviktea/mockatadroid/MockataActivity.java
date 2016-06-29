package com.theyaviktea.mockatadroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.theyavikteam.mockatacore.core.Mockata;

import java.util.ArrayList;
import java.util.List;

public class MockataActivity extends AppCompatActivity {

    TextView tvDog;
    TextView tvList;
    TextView tvComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mockata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDog = (TextView) findViewById(R.id.tv_dog);
        tvList = (TextView) findViewById(R.id.tv_list);
        tvComplete = (TextView) findViewById(R.id.tv_complete);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Dog> dogs = new ArrayList<>();
                dogs = Mockata.createMockata(Dog.class, 10);
                String s = "";
                for (Dog d : dogs) {
                    if (d != null) {
                        s += d.toString() + "\n";
                    }
                }
                if (tvDog != null)
                    tvDog.setText(s);

                List<WithListObject> listObjects = new ArrayList<WithListObject>();

                s = "";
                for (WithListObject withListObject: listObjects) {
                    if (withListObject != null) {
                        s += withListObject.toString() + "\n";
                    }
                }
                if (tvList != null)
                    tvList.setText(s);

                List<CompleteObject> completeObjects = new ArrayList<CompleteObject>();

                s = "";
                for (CompleteObject completeObject: completeObjects) {
                    if (completeObject != null) {
                        s += completeObject.toString() + "\n";
                    }
                }
                if (tvComplete != null)
                    tvComplete.setText(s);

            }
        });
    }
}
