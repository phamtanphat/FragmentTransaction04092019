package com.example.fragmentransaction04092019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
        fragmentTransaction.add(R.id.liearlayoutContainer, androidFragment , "android");
        fragmentTransaction.addToBackStack("android");
        fragmentTransaction.commit();
    }

    public void addIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.add(R.id.liearlayoutContainer, iosFragment,"ios");
        fragmentTransaction.addToBackStack("ios");
        fragmentTransaction.commit();
    }

    public void replaceAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.replace(R.id.liearlayoutContainer, androidFragment);
        fragmentTransaction.commit();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB", fragmentManager.getFragments().size() + "");
            }
        },2000);
    }


    public void replaceIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.replace(R.id.liearlayoutContainer, iosFragment);
        fragmentTransaction.commit();
    }
    public void removeAndroid(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("android");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(androidFragment);
            fragmentTransaction.commit();
        }
    }
    public void removeIos(View view) {
        IosFragment iosFragment = (IosFragment) fragmentManager.findFragmentByTag("ios");
        if (iosFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(iosFragment);
            fragmentTransaction.commit();
        }
    }
    public void popbackstack(View view) {
        fragmentManager.popBackStack(0, 0);
    }

    public void Detach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("android");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(androidFragment);
            fragmentTransaction.commit();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB", fragmentManager.getFragments().size() + "");
            }
        },2000);
    }

    public void Attach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("android");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(androidFragment);
            fragmentTransaction.commit();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("BBB", fragmentManager.getFragments().size() + "");
            }
        },2000);
    }
}
