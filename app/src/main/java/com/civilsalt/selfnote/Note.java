package com.civilsalt.selfnote;

public class Note {

    //Variables are prefixed with m to indicate that they ate member variables of the class

    private String mTitle;
    private String mDescription;
    private boolean mIdea;
    private boolean mTodo;
    private boolean mImportant;


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public boolean isIdea() {
        return mIdea;
    }

    public void setIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    //Boolean getter
    public boolean isTodo() {
        return mTodo;
    }

    public void setTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    //Boolean getter
    public boolean isImportant() {
        return mImportant;
    }

    public void setImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }
}
