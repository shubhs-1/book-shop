package com.assignment.bookshop.service;

import java.math.BigDecimal;

/**
 * Interface to perform discount related tasks/services
 * @author Shubham Kalaria
 */
public interface DiscountService {
    /**
     * Method to calculate amount after applying 10% discount
     * @param amount total amount
     * @return discounted amount
     */
    BigDecimal getAmountPostTenPercentDiscount(BigDecimal amount);

    /**
     * Method to calculate amount after applying 5% discount
     * @param amount total amount
     * @return discounted amount
     */
    BigDecimal getAmountPostFivePercentDiscount(BigDecimal amount);
}
