package com.assignment.bookshop.service;

import java.math.BigDecimal;

public interface DiscountService {
    BigDecimal getAmountPostTenPercentDiscount(BigDecimal amount);

    BigDecimal getAmountPostFivePercentDiscount(BigDecimal amount);
}
