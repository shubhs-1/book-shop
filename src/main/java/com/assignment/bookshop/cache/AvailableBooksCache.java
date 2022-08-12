package com.assignment.bookshop.cache;

import com.assignment.bookshop.model.Book;

import java.util.HashMap;
import java.util.Objects;

/**
 * Cache layer to store all the books available
 * @author Shubham Kalaria
 */
public class AvailableBooksCache {
    public static HashMap<String, Book> availableBooks = new HashMap<>();

    /**
     * Method to get all the available books in cache
     * @return Map to store required details of a book given book's title
     */
    public static HashMap<String, Book> getAllAvailableBooks() {
        if (Objects.isNull(availableBooks)) {
            availableBooks = new HashMap<>();
        }
        return availableBooks;
    }
}
