package com.proofit.business.services.calculator.components;

import com.proofit.business.SpringConfig;
import com.proofit.business.domain.RiskType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@TestPropertySource(locations = "classpath:application.properties")
public class CoefficientCalculatorTest {

    @Autowired
    private CoefficientCalculator victim;

    @Test
    public void shouldReturnCorrectedCoefficientFire() {
        BigDecimal calculatedCoefficientWhenValue100 = victim.calculateCoefficient(BigDecimal.valueOf(101.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue100, BigDecimal.valueOf(0.024));

        BigDecimal calculatedCoefficientWhenValue200 = victim.calculateCoefficient(BigDecimal.valueOf(200.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue200, BigDecimal.valueOf(0.024));
    }

    @Test
    public void shouldReturnDefaultCoefficientFire() {
        BigDecimal calculatedCoefficientWhenValue10 = victim.calculateCoefficient(BigDecimal.valueOf(10.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue10, BigDecimal.valueOf(0.014));

        BigDecimal calculatedCoefficientWhenValue99 = victim.calculateCoefficient(BigDecimal.valueOf(100.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue99, BigDecimal.valueOf(0.014));
    }

    @Test
    public void shouldReturnCorrectedCoefficientTheft() {
        BigDecimal calculatedCoefficientWhenValue15 = victim.calculateCoefficient(BigDecimal.valueOf(15.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue15, BigDecimal.valueOf(0.05));

        BigDecimal calculatedCoefficientWhenValue20 = victim.calculateCoefficient(BigDecimal.valueOf(20.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue20, BigDecimal.valueOf(0.05));
    }

    @Test
    public void shouldReturnDefaultCoefficientTheft() {
        BigDecimal calculatedCoefficientWhenValue14 = victim.calculateCoefficient(BigDecimal.valueOf(14.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue14, BigDecimal.valueOf(0.11));

        BigDecimal calculatedCoefficientWhenValue5 = victim.calculateCoefficient(BigDecimal.valueOf(5.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue5, BigDecimal.valueOf(0.11));
    }
}