package com.assignment.bookshop.service.impl;

import com.assignment.bookshop.cache.AvailableBooksCache;
import com.assignment.bookshop.model.Book;
import com.assignment.bookshop.service.FileService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<String> extractBooksToBuy(String path) {
        String line;
        List<String> books = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Line: " +line);
                books.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public void extractAllBooksAvailable(String path) {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                JsonObject object = JsonParser.parseString(line).getAsJsonObject();
                Book book = gson.fromJson(object, Book.class);
                System.out.println("Cache book: " +book);
                AvailableBooksCache.getAllAvailableBooks().putIfAbsent(book.getTitle(), book);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
