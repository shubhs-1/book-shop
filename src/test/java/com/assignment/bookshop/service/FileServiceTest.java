package com.assignment.bookshop.service;

import com.assignment.bookshop.cache.AvailableBooksCache;
import com.assignment.bookshop.model.Book;
import com.assignment.bookshop.service.impl.FileServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {
    @InjectMocks
    private FileService fileService = Mockito.spy(new FileServiceImpl());

    @Mock
    private BufferedReader bufferedReader;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void shouldCorrectlyGenerateBooksListForGivenFile() throws IOException {
        String path = ClassLoader.getSystemResource("books_to_buy.txt").getPath();
        List<String> expected = fileService.extractBooksToBuy(path);

        Assert.assertEquals(Arrays.asList("Still Life With Woodpecker", "Three Men in a Boat", "Great Expectations"), expected);
    }

    @Test
    public void shouldCorrectlyGenerateAvailableBooksCacheListForGivenFile() throws IOException {
        String path = ClassLoader.getSystemResource("available_books.txt").getPath();
        fileService.extractAllBooksAvailable(path);

        Assert.assertEquals(AvailableBooksCache.getAllAvailableBooks(), getAvailableBooksMap());
    }

    @Test (expected = FileNotFoundException.class)
    public void extractBooksToBuyMethodShouldThrowFileNotFoundExceptionIfPathDoesNotContainFile() throws IOException {
        String path = "file_not_present.txt";
        fileService.extractBooksToBuy(path);
    }

    @Test (expected = FileNotFoundException.class)
    public void extractAllBooksAvailableMethodShouldThrowFileNotFoundExceptionIfPathDoesNotContainFile() throws IOException {
        String path = "file_not_present.txt";
        fileService.extractAllBooksAvailable(path);
    }

    private HashMap<String, Book> getAvailableBooksMap() {
        HashMap<String, Book> map = new HashMap<>();
        map.put("Sleeping Murder", new Book("Sleeping Murder", BigDecimal.valueOf(10.24).setScale(2), 1976));
        map.put("The Terrible Privacy of Maxwell Sim", new Book("The Terrible Privacy of Maxwell Sim", BigDecimal.valueOf(13.14).setScale(2), 2010));
        map.put("Three Men in a Boat", new Book("Three Men in a Boat", BigDecimal.valueOf(12.87).setScale(2), 1889));
        map.put("Idle Thoughts of an Idle Fellow", new Book("Idle Thoughts of an Idle Fellow", BigDecimal.valueOf(7.32).setScale(2), 1886));
        map.put("Great Expectations", new Book("Great Expectations", BigDecimal.valueOf(13.21).setScale(2), 1861));
        map.put("Moby Dick", new Book("Moby Dick", BigDecimal.valueOf(15.20).setScale(2), 1851));
        map.put("Still Life With Woodpecker", new Book("Still Life With Woodpecker", BigDecimal.valueOf(11.05).setScale(2), 1980));
        map.put("A Christmas Carol", new Book("A Christmas Carol", BigDecimal.valueOf(4.23).setScale(2), 1843));
        map.put("The Time Machine", new Book("The Time Machine", BigDecimal.valueOf(10.43).setScale(2), 1895));
        map.put("A Tale of Two Cities", new Book("A Tale of Two Cities", BigDecimal.valueOf(6.32).setScale(2), 1859));
        map.put("The Caves of Steel", new Book("The Caves of Steel", BigDecimal.valueOf(8.12).setScale(2), 1954));
        return map;
    }
}
