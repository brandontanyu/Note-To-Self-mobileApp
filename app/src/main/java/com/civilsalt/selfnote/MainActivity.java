package com.civilsalt.selfnote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Note> noteList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NoteAdapter mAdapter;

    //adding items of type Note to the array list
    public void createNewNote(Note n){
        noteList.add(n);
        mAdapter.notifyDataSetChanged();
    }

   /*
   This function is responsible for showing details of the list when it receives a click from the recyclerview.
   noteToShow parameter is the position of the item to be displayed
    */
    public void showNote(int noteToShow){
        DialogShowNote dialog = new DialogShowNote();
        dialog.sendNoteSelected(noteList.get(noteToShow));
        dialog.show(getSupportFragmentManager(), "");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogNewNote dialog = new DialogNewNote();
        dialog.show(getSupportFragmentManager(), "");
        Button button = findViewById(R.id.btnAdd);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            DialogNewNote dialog = new DialogNewNote();
            dialog.show(getSupportFragmentManager(), "");
            }
        });

        recyclerView  = findViewById(R.id.recyclerView);
        mAdapter = new NoteAdapter(this,noteList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Add a neat dividing line between items in the list
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //set Adapter

        recyclerView.setAdapter(mAdapter);
    }
}