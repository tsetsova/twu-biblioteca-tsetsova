package com.twu.biblioteca.Items;

import java.util.HashMap;

public interface Item {
    String getTitle();
    Boolean titleMatches(String otherTitle);
    HashMap<String, String> details();
}
