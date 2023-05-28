package com.civilsalt.selfnote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.listItemHolder> {

    private List<Note> mNoteList;
    private MainActivity mMainActivity;

    //NoteAdapter constructor
    public NoteAdapter(MainActivity mainActivity, List<Note> noteList){
        mNoteList = noteList;
        mMainActivity = mainActivity;

    }

    //This method is called when a layout for list item is required
    @NonNull
    @Override
    public NoteAdapter.listItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView  = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem,parent,false);
        return new listItemHolder(itemView);
    }

    //Method is called when RecyclerAdapter is bound to RecyclerView in layout
    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.listItemHolder holder, int position) {
        Note note = mNoteList.get(position);
        holder.mTitle.setText(note.getTitle());
        /*
         Show the first 15 characters of the actual note
         Unless a short note then show half
         */

        if(note.getDescription().length() > 15) {
            holder.mDescription.setText(note.getDescription()
                    .substring(0, 15));
        }
        else{
            holder.mDescription.setText(note.getDescription()
                    .substring(0, note.getDescription().length() /2 ));
        }
       // What is the status of the note?
        if(note.isIdea()){
            holder.mStatus.setText(R.string.idea_text);
        }
        else if(note.isImportant()){
            holder.mStatus.setText(R.string.important_text);
        }
        else if(note.isTodo()){
            holder.mStatus.setText(R.string.todo_text);
        }


    }

    //This method returns the number of items found in arrayList `mNoteList in our case here`
    @Override
    public int getItemCount() {
        return mNoteList.size();
    }

    /*
    Chosen class as holder for each item element And this implements the onclickListener
    to respond to clicks on each list item on the list.

     */
    public class listItemHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        TextView mTitle;
        TextView mDescription;
        TextView mStatus;

        public listItemHolder(@NonNull View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.txtViewTextTitle);
            mDescription =itemView.findViewById(R.id.txtViewDescription);
            mStatus =itemView.findViewById(R.id.txtViewStatus);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mMainActivity.showNote(getAdapterPosition());
        }
    }
}

