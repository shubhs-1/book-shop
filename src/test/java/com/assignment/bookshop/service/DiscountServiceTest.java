package com.assignment.bookshop.service;

import com.assignment.bookshop.service.impl.DiscountServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class DiscountServiceTest {

    @InjectMocks
    private DiscountService discountService = Mockito.spy(new DiscountServiceImpl());

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks( this );
    }

    @Test
    public void shouldCorrectlyCalculateFinalAmountPostTenPercentDiscount() {
        BigDecimal discountedAmount = discountService.getAmountPostTenPercentDiscount(new BigDecimal(13.14));
        Assert.assertEquals(discountedAmount, BigDecimal.valueOf(11.83));
    }

    @Test
    public void shouldCorrectlyCalculateFinalAmountPostFivePercentDiscount() {
        BigDecimal discountedAmount = discountService.getAmountPostFivePercentDiscount(new BigDecimal(37.13));
        Assert.assertEquals(discountedAmount, BigDecimal.valueOf(35.27));
    }
}
