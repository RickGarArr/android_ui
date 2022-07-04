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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;
import com.rga.myapplication.ui.activities.SecondActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar mainActivityToolbar;
    private View mainActivityView;
    private Snackbar snackbar;
    private Button buttonToSnackBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        configToolbar();
        configSnackBar();
        configView();
    }

    private void bindView() {
        mainActivityToolbar = findViewById(R.id.activity_main_toolbar);
        mainActivityView = findViewById(R.id.activity_main);
        buttonToSnackBar = findViewById(R.id.button_show_snackbar);
    }

    private void configToolbar() {
        setSupportActionBar(mainActivityToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);
        actionBar.setElevation(12);
    }

    private void configSnackBar() {
        snackbar = Snackbar.make(mainActivityView, "This is my first Snack Bar", Snackbar.LENGTH_SHORT);
        snackbar.setAction(R.string.snackbar_action_dismiss, view -> snackbar.dismiss());
        snackbar.setActionTextColor(getColor(android.R.color.holo_red_dark));
        snackbar.setBackgroundTint(getColor(android.R.color.black));
    }

    private void configView() {
        buttonToSnackBar.setOnClickListener(view -> {
            if (snackbar.isShown()) {
                snackbar.dismiss();
            } else {
                snackbar.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity_menu, menu);
        configSearchOption(menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void configSearchOption(Menu menu) {
        MenuItem searchItem = menu.findItem(R.id.search_action);
        SearchView searchView = (SearchView) searchItem.getActionView();
        EditText searchEditText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        searchEditText.setTextColor(getColor(R.color.color_on_primary));
        searchItem.setOnActionExpandListener(this.onActionExpandListener());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings_option:
                Intent intentToSecondActivity = new Intent(this, SecondActivity.class);
                startActivity(intentToSecondActivity);
                return true;
            case R.id.share_action:
                Log.i(TAG, "onOptionsItemSelected: action 1");
                return true;
            case R.id.action_2:
                Log.i(TAG, "onOptionsItemSelected: action 2");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private MenuItem.OnActionExpandListener onActionExpandListener() {
        return new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        };
    }
}