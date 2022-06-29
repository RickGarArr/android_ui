package com.rga.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.rga.myapplication.ui.activities.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

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
        actionBar.setTitle(R.string.app_name);
        actionBar.setElevation(12);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_option:
                Intent intentToSecondActivity = new Intent(this, SecondActivity.class);
                startActivity(intentToSecondActivity);
                return true;
            case R.id.action_1:
                Log.i(TAG, "onOptionsItemSelected: action 1");
                return true;
            case R.id.action_2:
                Log.i(TAG, "onOptionsItemSelected: action 2");
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}