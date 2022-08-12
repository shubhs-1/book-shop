package com.assignment.bookshop.service;

import java.io.IOException;
import java.util.List;

/**
 * Interface to perform read/write file related tasks/services
 * @author Shubham Kalaria
 */
public interface FileService {
    /**
     * Method to get the list of books to buy given file path
     * @param path path of the file
     * @return list of books to buy
     * @throws IOException
     */
    List<String> extractBooksToBuy(String path) throws IOException;

    /**
     * Method to store all the available books in a cache given file path
     * @param path path of the file
     * @throws IOException
     */
    void extractAllBooksAvailable(String path) throws IOException;
}
