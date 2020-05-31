package com.proofit.business.services.calculator.components;

import com.proofit.business.constants.Constants;
import com.proofit.business.domain.RiskType;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class CoefficientCalculatorTest {

    private CoefficientCalculator victim;

    @Before
    public void initialization(){
        victim = new CoefficientCalculator();
    }

    @Test
    public void shouldReturnCorrectedCoefficientFire() {
        BigDecimal calculatedCoefficientWhenValue100 = victim.calculateCoefficient(BigDecimal.valueOf(101.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue100, Constants.CORRECTED_COEFFICIENT_FIRE);

        BigDecimal calculatedCoefficientWhenValue200 = victim.calculateCoefficient(BigDecimal.valueOf(200.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue200, Constants.CORRECTED_COEFFICIENT_FIRE);
    }

    @Test
    public void shouldReturnDefaultCoefficientFire() {
        BigDecimal calculatedCoefficientWhenValue10 = victim.calculateCoefficient(BigDecimal.valueOf(10.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue10, Constants.DEFAULT_COEFFICIENT_FIRE);

        BigDecimal calculatedCoefficientWhenValue99 = victim.calculateCoefficient(BigDecimal.valueOf(100.00), RiskType.FIRE);
        assertEquals(calculatedCoefficientWhenValue99, Constants.DEFAULT_COEFFICIENT_FIRE);
    }

    @Test
    public void shouldReturnCorrectedCoefficientTheft() {
        BigDecimal calculatedCoefficientWhenValue15 = victim.calculateCoefficient(BigDecimal.valueOf(15.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue15, Constants.CORRECTED_COEFFICIENT_THEFT);

        BigDecimal calculatedCoefficientWhenValue20 = victim.calculateCoefficient(BigDecimal.valueOf(20.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue20, Constants.CORRECTED_COEFFICIENT_THEFT);
    }

    @Test
    public void shouldReturnDefaultCoefficientTheft() {
        BigDecimal calculatedCoefficientWhenValue14 = victim.calculateCoefficient(BigDecimal.valueOf(14.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue14, Constants.DEFAULT_COEFFICIENT_THEFT);

        BigDecimal calculatedCoefficientWhenValue5 = victim.calculateCoefficient(BigDecimal.valueOf(5.00), RiskType.THEFT);
        assertEquals(calculatedCoefficientWhenValue5, Constants.DEFAULT_COEFFICIENT_THEFT);
    }
}