package com.assignment.bookshop.service.impl;

import com.assignment.bookshop.service.DiscountService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public BigDecimal getAmountPostTenPercentDiscount(BigDecimal amount) {
        BigDecimal discountedAmount = amount.subtract(amount.multiply(new BigDecimal(.10)));
        return discountedAmount;
    }

    @Override
    public BigDecimal getAmountPostFivePercentDiscount(BigDecimal amount) {
        BigDecimal discountedAmount = amount.subtract(amount.multiply(new BigDecimal(.05)));
        return discountedAmount;
    }
}
