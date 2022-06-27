package com.rga.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainActivityToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        configToolbar();
    }

    private void bindView() {
        mainActivityToolbar = findViewById(R.id.activity_main_toolbar);
    }

    private void configToolbar() {
        setSupportActionBar(mainActivityToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Hola Ricardo");
        actionBar.setSubtitle("Cómo estás?");
    }
}