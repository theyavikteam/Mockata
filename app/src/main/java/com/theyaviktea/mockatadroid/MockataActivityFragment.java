package com.theyaviktea.mockatadroid;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.theyavikteam.mockatacore.core.Mockata;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MockataActivityFragment extends Fragment {

    TextView tv;

    public MockataActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mockata, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
        for (Dog d : dogs){
            if (d != null){
                s += d.toString()+"\n";
                Log.i("Mockata", d.toString());
            }else {
                Log.w("Mockata", "null");
            }
        }


        String[] stockArr = new String[dogs.size()];
        for (int j = 0; j < dogs.size(); j++){
            stockArr[j] = dogs.get(j).toString();
        }


    }
}
