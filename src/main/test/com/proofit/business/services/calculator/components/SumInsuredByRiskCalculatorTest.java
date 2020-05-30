package com.proofit.business.services.calculator.components;

import com.proofit.business.domain.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SumInsuredByRiskCalculatorTest {

    @Test
    public void shouldReturnCorrectSumInsuredByRiskFire500() {
        SumInsuredByRiskCalculator victim = new SumInsuredByRiskCalculator();
        PolicySubObject policySubObjectFire1 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire2 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire3 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire4 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire5 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);

        PolicySubObject policySubObjectTheft1 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
        PolicySubObject policySubObjectTheft2 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
        PolicySubObject policySubObjectTheft3 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);

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

        BigDecimal actual = victim.calculateSumInsured(policy, RiskType.FIRE);
        assertEquals(BigDecimal.valueOf(500.00), actual);
    }

    @Test
    public void shouldReturnCorrectSumInsuredByRiskTheft150() {
        SumInsuredByRiskCalculator victim = new SumInsuredByRiskCalculator();
        PolicySubObject policySubObjectFire1 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire2 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire3 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire4 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject policySubObjectFire5 = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);

        PolicySubObject policySubObjectTheft1 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
        PolicySubObject policySubObjectTheft2 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);
        PolicySubObject policySubObjectTheft3 = new PolicySubObject("Smartphone", BigDecimal.valueOf(50.00), RiskType.THEFT);

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

        BigDecimal actual = victim.calculateSumInsured(policy, RiskType.THEFT);
        assertEquals(BigDecimal.valueOf(150.00), actual);
    }
}