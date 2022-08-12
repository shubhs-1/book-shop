package com.assignment.bookshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * POJO class to represent a Book
 * @author Shubham Kalaria
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    String title;
    // assuming currency to be same
    BigDecimal price;
    int year;
}
