package com.assignment.bookshop.cache;

import com.assignment.bookshop.model.Book;

import java.util.HashMap;
import java.util.Objects;

public class AvailableBooksCache {
    public static HashMap<String, Book> availableBooks = new HashMap<>();

    public static HashMap<String, Book> getAllAvailableBooks() {
        if (Objects.isNull(availableBooks)) {
            availableBooks = new HashMap<>();
        }
        return availableBooks;
    }
}
