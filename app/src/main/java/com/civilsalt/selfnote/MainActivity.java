package com.civilsalt.selfnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public void createNewNote(Note n){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DialogNewNote dialog = new DialogNewNote();
        dialog.show(getSupportFragmentManager(), "");


    }
}