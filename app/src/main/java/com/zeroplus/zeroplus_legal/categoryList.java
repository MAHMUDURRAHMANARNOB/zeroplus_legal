package com.zeroplus.zeroplus_legal;

public class categoryList {
    private  String categoryId, title;


    public categoryList() {
    }
    public categoryList(String categoryId, String title) {

        this.categoryId = categoryId;
        this.title = title;

    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


/*@NonNull
    @Override
    public String toString() {
        return this.title; // What to display in the Spinner list.
    }*/
}
