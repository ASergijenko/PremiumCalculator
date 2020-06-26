package com.proofit.business.services;

import com.proofit.business.SpringConfig;
import com.proofit.business.domain.*;
import com.proofit.business.services.calculator.PremiumCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
@TestPropertySource(locations = "classpath:application.properties")
public class PremiumCalculatorAcceptanceTest {

    @Autowired
    private PremiumCalculator victim;

    @Test
    public void integrationShouldCalculateCorrectPremium_2_28EUR() {
        List<PolicySubObject> houseSubObjects = new ArrayList<>();
        PolicySubObject subObjectTV = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject subObjectSofa = new PolicySubObject("Sofa", BigDecimal.valueOf(8.00), RiskType.THEFT);
        houseSubObjects.add(subObjectTV);
        houseSubObjects.add(subObjectSofa);

        PolicyObject house = new PolicyObject("House", houseSubObjects);

        List<PolicyObject> policyObjects = new ArrayList<>();
        policyObjects.add(house);

        Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED, policyObjects);

        assertEquals("2.28 EUR", victim.calculate(policy));
    }

    @Test
    public void integrationShouldCalculateCorrectPremium_17_13EUR() {
        List<PolicySubObject> houseSubObjects = new ArrayList<>();
        PolicySubObject subObjectTV = new PolicySubObject("TV", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject subObjectSofa = new PolicySubObject("Sofa", BigDecimal.valueOf(2.51), RiskType.THEFT);
        houseSubObjects.add(subObjectTV);
        houseSubObjects.add(subObjectSofa);

        List<PolicySubObject> officeSubObjects = new ArrayList<>();
        PolicySubObject officeObjectComputer1 = new PolicySubObject("Computer N1", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject officeObjectComputer2 = new PolicySubObject("Computer N2", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject officeObjectComputer3 = new PolicySubObject("Computer N3", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject officeObjectComputer4 = new PolicySubObject("Computer N4", BigDecimal.valueOf(100.00), RiskType.FIRE);
        PolicySubObject officeObjectSofa1 = new PolicySubObject("Sofa N1", BigDecimal.valueOf(50.00), RiskType.THEFT);
        PolicySubObject officeObjectSofa2 = new PolicySubObject("Sofa N2", BigDecimal.valueOf(50.00), RiskType.THEFT);

        officeSubObjects.add(officeObjectComputer1);
        officeSubObjects.add(officeObjectComputer2);
        officeSubObjects.add(officeObjectComputer3);
        officeSubObjects.add(officeObjectComputer4);
        officeSubObjects.add(officeObjectSofa1);
        officeSubObjects.add(officeObjectSofa2);

        PolicyObject house = new PolicyObject("House", houseSubObjects);
        PolicyObject office = new PolicyObject("House", officeSubObjects);

        List<PolicyObject> policyObjects = new ArrayList<>();
        policyObjects.add(house);
        policyObjects.add(office);

        Policy policy = new Policy("LV20-02-100000-5", PolicyStatus.REGISTERED, policyObjects);

        assertEquals("17.13 EUR", victim.calculate(policy));
    }
}