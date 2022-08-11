package com.assignment.bookshop.service.impl;

import com.assignment.bookshop.cache.AvailableBooksCache;
import com.assignment.bookshop.model.Book;
import com.assignment.bookshop.service.FileService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<String> extractBooksToBuy(String path) throws IOException {
        String line;
        List<String> books = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                books.add(line);
            }
        } catch (FileNotFoundException fnfe) {
            log.error("File not found at path: {}", path);
            throw new FileNotFoundException("File not found for given path");
        } catch (IOException e) {
            log.error("Exception occurred while reading file at path: {}", path);
            throw new IOException("Exception occurred while reading the file");
        }
        return books;
    }

    @Override
    public void extractAllBooksAvailable(String path) throws IOException {
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while ((line = bufferedReader.readLine()) != null) {
                Gson gson = new Gson();
                JsonObject object = JsonParser.parseString(line).getAsJsonObject();
                Book book = gson.fromJson(object, Book.class);
                AvailableBooksCache.getAllAvailableBooks().putIfAbsent(book.getTitle(), book);
            }
        } catch (FileNotFoundException fnfe) {
            log.error("File not found at path: {}", path);
            throw new FileNotFoundException("File not found for given path");
        } catch (IOException e) {
            log.error("Exception occurred while reading file at path: {}", path);
            throw new IOException("Exception while reading the file");
        }
    }
}
