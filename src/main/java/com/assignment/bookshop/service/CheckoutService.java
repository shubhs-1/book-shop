package com.assignment.bookshop.service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Interface to perform order checkout related tasks/services
 * @author Shubham Kalaria
 */
public interface CheckoutService {
    /**
     * Method to calculate final amount to be paid after applying offers/discounts
     * @param books list of book titles
     * @return final amount to be paid
     */
    BigDecimal calculateFinalAmount(List<String> books);
}
