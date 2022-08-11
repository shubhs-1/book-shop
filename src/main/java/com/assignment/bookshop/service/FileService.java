package com.assignment.bookshop.service;

import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> extractBooksToBuy(String path) throws IOException;

    void extractAllBooksAvailable(String path) throws IOException;
}
