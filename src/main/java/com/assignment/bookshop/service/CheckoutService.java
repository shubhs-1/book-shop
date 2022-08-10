package com.assignment.bookshop.service;

import com.assignment.bookshop.model.Book;

import java.math.BigDecimal;
import java.util.List;

public interface CheckoutService {
    BigDecimal calculateFinalAmount(List<String> books);
}
