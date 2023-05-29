package com.civilsalt.selfnote;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.DialogFragment;

public class DialogShowNote extends DialogFragment {
    private Note mNote;

    // Receive a note from the MainActivity
    public void sendNoteSelected(Note noteSelected) {
        this.mNote = noteSelected;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
   // All the other code goes here

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_show_note, null);
        TextView txtTitle = dialogView.findViewById(R.id.txtTitle);
        TextView txtDescription = dialogView.findViewById(R.id.txtDescription);

        txtTitle.setText(mNote.getTitle());
        txtDescription.setText(mNote.getDescription());

        TextView txtImportant = dialogView.findViewById(R.id.txtViewImportant);
        TextView txtTodo = dialogView.findViewById(R.id.txtViewTodo);
        TextView txtIdea = dialogView.findViewById(R.id.txtViewIdea);

        /*
        We now check whether or not the note selected isImportant,isTodo or isIdead.
        If not, we hide the the textview holding that widget.

         */
        if (!mNote.isImportant()){
            txtImportant.setVisibility(View.GONE);
        }
        if (!mNote.isTodo()){
            txtTodo.setVisibility(View.GONE);
        }
        if (!mNote.isIdea()){
            txtIdea.setVisibility(View.GONE);
        }

        Button btnOK = (Button) dialogView.findViewById(R.id.btnOK);
        builder.setView(dialogView).setMessage("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return builder.create();
    }

}