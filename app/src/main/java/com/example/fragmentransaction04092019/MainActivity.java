package com.example.fragmentransaction04092019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    public void addAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.add(R.id.liearlayoutContainer,androidFragment);
        fragmentTransaction.commit();
    }
    public void addIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.add(R.id.liearlayoutContainer,iosFragment);
        fragmentTransaction.commit();
    }
}
