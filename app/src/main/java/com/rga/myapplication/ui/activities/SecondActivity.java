package com.rga.myapplication.ui.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.rga.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();

    private Toolbar toolbar;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bindView();
        configToolbar();
    }

    private void bindView() {
        toolbar = findViewById(R.id.second_activity_toolbar);
    }

    private void configToolbar() {
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        configActionBar();
    }

    private void configActionBar() {
        actionBar.setTitle(R.string.app_name);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_backspace);
//        toolbar.setNavigationOnClickListener(view -> finish());
    }
}