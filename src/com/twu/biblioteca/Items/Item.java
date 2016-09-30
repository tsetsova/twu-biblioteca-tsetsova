package com.twu.biblioteca.Items;

import java.util.HashMap;

public abstract class Item {

    private final String title;

    Item(String title){
      this.title = title;
    }
    public String getTitle() {return title;}

    public Boolean titleMatches(String otherTitle) {return title.equals(otherTitle);}

    public abstract HashMap<String,String> details();
}
