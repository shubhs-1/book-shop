package com.assignment.bookshop.service.impl;

import com.assignment.bookshop.cache.AvailableBooksCache;
import com.assignment.bookshop.model.Book;
import com.assignment.bookshop.service.CheckoutService;
import com.assignment.bookshop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Class implementing the CheckoutService interface
 * @author Shubham Kalaria
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private DiscountService discountService;

    /**
     * Method to calculate final amount to be paid after applying offers/discounts
     * @param books list of book titles
     * @return final amount to be paid
     */
    @Override
    public BigDecimal calculateFinalAmount(List<String> books) {
        BigDecimal totalAmount = new BigDecimal(0);

        for(String bookTitle: books) {
            if(AvailableBooksCache.getAllAvailableBooks().containsKey(bookTitle)) {
                Book book = AvailableBooksCache.getAllAvailableBooks().get(bookTitle);
                int year = book.getYear();
                BigDecimal price = book.getPrice();

                if(year > 2000) {
                    BigDecimal discountedPrice = discountService.getAmountPostTenPercentDiscount(price);
                    totalAmount = totalAmount.add(discountedPrice);
                } else {
                    totalAmount = totalAmount.add(price);
                }
                totalAmount = totalAmount.setScale(2, RoundingMode.HALF_EVEN);
            }
        }

        if(totalAmount.compareTo(new BigDecimal(30)) == 1) {
            BigDecimal discountedAmount = discountService.getAmountPostFivePercentDiscount(totalAmount);
            discountedAmount = discountedAmount.setScale(2, RoundingMode.HALF_EVEN);
            return discountedAmount;
        }

        return totalAmount;
    }
}
