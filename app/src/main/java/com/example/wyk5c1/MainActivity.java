package com.example.wyk5c1;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.wyk5c1.callback.ToolbarCallback;

public class MainActivity extends FragmentActivity
                          implements ToolbarCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            ToolbarFragment toolbarFragment = new ToolbarFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transactionManager = fragmentManager.beginTransaction();
            transactionManager.add(R.id.activity, toolbarFragment);
            transactionManager.commit();
        }
    }

    @Override
    public void onButtonClick(int position, String text) {
        TextFragment textFragment = TextFragment.newInstance(position, text);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transactionManager = fragmentManager.beginTransaction();
        transactionManager.replace(R.id.activity, textFragment);
        transactionManager.addToBackStack(null);
        transactionManager.commit();
    }
}