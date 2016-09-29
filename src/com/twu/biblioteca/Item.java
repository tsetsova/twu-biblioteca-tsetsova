package com.twu.biblioteca;

import java.util.HashMap;

public interface Item {
    String getTitle();
    Boolean titleMatches(String otherTitle);
    HashMap<String, String> details();
}
