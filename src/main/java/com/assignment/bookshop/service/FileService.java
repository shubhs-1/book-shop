package com.assignment.bookshop.service;

import java.util.List;

public interface FileService {
    List<String> extractBooksToBuy(String path);

    void extractAllBooksAvailable(String path);
}
