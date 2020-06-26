package com.proofit.business.services;

import com.proofit.business.domain.*;
import com.proofit.business.services.calculator.PremiumCalculator;
import com.proofit.business.services.calculator.components.CoefficientCalculator;
import com.proofit.business.services.calculator.components.SumInsuredByRiskCalculator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PremiumCalculatorTest {

    private Policy policy;

    @Mock
    private CoefficientCalculator coefficientCalculator;
    @Mock
    private SumInsuredByRiskCalculator sumInsuredByRiskCalculator;

    @InjectMocks
    private PremiumCalculator victim;

    @Before
    public void initialization() {
        policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED, policyObjects());
    }

    @Test
    public void shouldCalculateCorrectPremiumFor_2_28EUR() {
        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.FIRE)).thenReturn(BigDecimal.valueOf(100.00));
        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.THEFT)).thenReturn(BigDecimal.valueOf(8.00));
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(100.00), RiskType.FIRE)).thenReturn(BigDecimal.valueOf(0.014));
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(8.00), RiskType.THEFT)).thenReturn(BigDecimal.valueOf(0.11));

        String expected = "2.28 EUR";
        String actual = victim.calculate(policy);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculateCorrectPremiumFor_17_13EUR() {
        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.FIRE)).thenReturn(BigDecimal.valueOf(500.00));
        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.THEFT)).thenReturn(BigDecimal.valueOf(102.51));
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(500.00), RiskType.FIRE)).thenReturn(BigDecimal.valueOf(0.024));
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(102.51), RiskType.THEFT)).thenReturn(BigDecimal.valueOf(0.05));

        String expected = "17.13 EUR";
        String actual = victim.calculate(policy);

        assertEquals(expected, actual);
    }

    private List<PolicyObject> policyObjects() {
        List<PolicySubObject> policySubObjects = new ArrayList<>();
        PolicyObject policyObject = new PolicyObject("House", policySubObjects);
        List<PolicyObject> policyObjects = new ArrayList<>();
        policyObjects.add(policyObject);
        return policyObjects;
    }
}