package com.proofit.business.services;

import com.proofit.business.constants.Constants;
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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PremiumCalculatorTest {

    @Mock
    private CoefficientCalculator coefficientCalculator;
    @Mock
    private SumInsuredByRiskCalculator sumInsuredByRiskCalculator;

    @InjectMocks
    private PremiumCalculator victim;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCalculateCorrectPremium2_28EUR() {
        PolicySubObject policySubObjectFire = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectTheft = new PolicySubObject("Smartphone", BigDecimal.valueOf(8.00), RiskType.THEFT);

        List<PolicySubObject> policySubObjects = new ArrayList<>();
        policySubObjects.add(policySubObjectFire);
        policySubObjects.add(policySubObjectTheft);

        PolicyObject policyObject = new PolicyObject("House",policySubObjects);
        List<PolicyObject> policyObjects = new ArrayList<>();
        policyObjects.add(policyObject);

        Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED, policyObjects);

        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.FIRE)).thenReturn(BigDecimal.valueOf(100.00));
        Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.THEFT)).thenReturn(BigDecimal.valueOf(8.00));
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(100.00), RiskType.FIRE)).thenReturn(Constants.DEFAULT_COEFFICIENT_FIRE);
        Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(8.00), RiskType.THEFT)).thenReturn(Constants.DEFAULT_COEFFICIENT_THEFT);

        String expected = "2.28 EUR";
        String actual = victim.calculate(policy);

        assertEquals(expected, actual);
    }

   @Test
   public void shouldCalculateCorrectPremium17_13EUR() {
       PolicySubObject policySubObjectFire1 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
       PolicySubObject policySubObjectFire2 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
       PolicySubObject policySubObjectFire3 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
       PolicySubObject policySubObjectFire4 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
       PolicySubObject policySubObjectFire5 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);

       PolicySubObject policySubObjectTheft1 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
       PolicySubObject policySubObjectTheft2 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
       PolicySubObject policySubObjectTheft3 = new PolicySubObject("Smartphone", BigDecimal.valueOf(2.51), RiskType.THEFT);

       List<PolicySubObject> policySubObjects = new ArrayList<>();
       policySubObjects.add(policySubObjectFire1);
       policySubObjects.add(policySubObjectFire2);
       policySubObjects.add(policySubObjectFire3);
       policySubObjects.add(policySubObjectFire4);
       policySubObjects.add(policySubObjectFire5);
       policySubObjects.add(policySubObjectTheft1);
       policySubObjects.add(policySubObjectTheft2);
       policySubObjects.add(policySubObjectTheft3);

       PolicyObject policyObject = new PolicyObject("House",policySubObjects);
       List<PolicyObject> policyObjects = new ArrayList<>();
       policyObjects.add(policyObject);

       Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED, policyObjects);

       Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.FIRE)).thenReturn(BigDecimal.valueOf(500.00));
       Mockito.when(sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.THEFT)).thenReturn(BigDecimal.valueOf(102.51));
       Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(500.00), RiskType.FIRE)).thenReturn(Constants.CORRECTED_COEFFICIENT_FIRE);
       Mockito.when(coefficientCalculator.calculateCoefficient(BigDecimal.valueOf(102.51), RiskType.THEFT)).thenReturn(Constants.CORRECTED_COEFFICIENT_THEFT);

       String expected = "17.13 EUR";
       String actual = victim.calculate(policy);

       assertEquals(expected, actual);
   }
}