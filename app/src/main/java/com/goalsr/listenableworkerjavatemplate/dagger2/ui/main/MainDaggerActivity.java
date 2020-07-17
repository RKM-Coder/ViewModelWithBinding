package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.BaseActivity;

public class MainDaggerActivity extends BaseActivity {
    private String TAG="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dagger);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mani_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                sessionManager.logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
