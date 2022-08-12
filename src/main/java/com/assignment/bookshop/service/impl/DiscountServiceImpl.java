package com.assignment.bookshop.service.impl;

import com.assignment.bookshop.service.DiscountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Class implementing DiscountService interface
 * @author Shubham Kalaria
 */
@Service
public class DiscountServiceImpl implements DiscountService {
    /**
     * Method to calculate amount after applying 10% discount
     * @param amount total amount
     * @return discounted amount
     */
    @Override
    public BigDecimal getAmountPostTenPercentDiscount(BigDecimal amount) {
        BigDecimal discountedAmount = amount.subtract(amount.multiply(new BigDecimal(.10)));
        discountedAmount = discountedAmount.setScale(2, RoundingMode.HALF_EVEN);
        return discountedAmount;
    }

    /**
     * Method to calculate amount after applying 5% discount
     * @param amount total amount
     * @return discounted amount
     */
    @Override
    public BigDecimal getAmountPostFivePercentDiscount(BigDecimal amount) {
        BigDecimal discountedAmount = amount.subtract(amount.multiply(new BigDecimal(.05)));
        discountedAmount = discountedAmount.setScale(2, RoundingMode.HALF_EVEN);
        return discountedAmount;
    }
}
