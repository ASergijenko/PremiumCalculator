package com.proofit.business.services.calculator.components;

import com.proofit.business.constants.Constants;
import com.proofit.business.domain.RiskType;
import org.junit.Test;
import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
public class CoefficientCalculatorTest {

    @Test
    public void shouldReturnCorrectedCoefficientFire() {
        CoefficientCalculator victim = new CoefficientCalculator();
        BigDecimal calculatedCoefficient100 = victim.calculateCoefficient(BigDecimal.valueOf(101.00), RiskType.FIRE);
        assertEquals(calculatedCoefficient100, Constants.CORRECTED_COEFFICIENT_FIRE);
        BigDecimal calculatedCoefficient200 = victim.calculateCoefficient(BigDecimal.valueOf(200.00), RiskType.FIRE);
        assertEquals(calculatedCoefficient200, Constants.CORRECTED_COEFFICIENT_FIRE);
    }

    @Test
    public void shouldReturnDefaultCoefficientFire() {
        CoefficientCalculator victim = new CoefficientCalculator();
        BigDecimal calculatedCoefficient10 = victim.calculateCoefficient(BigDecimal.valueOf(10.00), RiskType.FIRE);
        assertEquals(calculatedCoefficient10, Constants.DEFAULT_COEFFICIENT_FIRE);
        BigDecimal calculatedCoefficient99 = victim.calculateCoefficient(BigDecimal.valueOf(100.00), RiskType.FIRE);
        assertEquals(calculatedCoefficient99, Constants.DEFAULT_COEFFICIENT_FIRE);
    }

    @Test
    public void shouldReturnCorrectedCoefficientTheft() {
        CoefficientCalculator victim = new CoefficientCalculator();
        BigDecimal calculatedCoefficient15 = victim.calculateCoefficient(BigDecimal.valueOf(15.00), RiskType.THEFT);
        assertEquals(calculatedCoefficient15, Constants.CORRECTED_COEFFICIENT_THEFT);
        BigDecimal calculatedCoefficient20 = victim.calculateCoefficient(BigDecimal.valueOf(20.00), RiskType.THEFT);
        assertEquals(calculatedCoefficient20, Constants.CORRECTED_COEFFICIENT_THEFT);
    }

    @Test
    public void shouldReturnDefaultCoefficientTheft() {
        CoefficientCalculator victim = new CoefficientCalculator();
        BigDecimal calculatedCoefficient14 = victim.calculateCoefficient(BigDecimal.valueOf(14.00), RiskType.THEFT);
        assertEquals(calculatedCoefficient14, Constants.DEFAULT_COEFFICIENT_THEFT);
        BigDecimal calculatedCoefficient5 = victim.calculateCoefficient(BigDecimal.valueOf(5.00), RiskType.THEFT);
        assertEquals(calculatedCoefficient5, Constants.DEFAULT_COEFFICIENT_THEFT);
    }
}