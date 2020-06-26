package com.proofit.business.services.calculator;

import com.proofit.business.domain.Policy;
import com.proofit.business.domain.RiskType;
import com.proofit.business.services.calculator.components.CoefficientCalculator;
import com.proofit.business.services.calculator.components.SumInsuredByRiskCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class PremiumCalculator {

    @Autowired
    private SumInsuredByRiskCalculator sumInsuredByRiskCalculator;
    @Autowired
    private CoefficientCalculator coefficientCalculator;

    public String calculate(Policy policy) {
        BigDecimal calculatedSumInsuredByFire = sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.FIRE);
        BigDecimal calculatedSumInsuredByTheft = sumInsuredByRiskCalculator.calculateSumInsured(policy, RiskType.THEFT);

        BigDecimal calculatedCoefficientForFire = coefficientCalculator.calculateCoefficient(calculatedSumInsuredByFire, RiskType.FIRE);
        BigDecimal calculatedCoefficientForTheft = coefficientCalculator.calculateCoefficient(calculatedSumInsuredByTheft, RiskType.THEFT);

        BigDecimal premiumFire = calculatedSumInsuredByFire.multiply(calculatedCoefficientForFire);
        BigDecimal premiumTheft = calculatedSumInsuredByTheft.multiply(calculatedCoefficientForTheft);

        return premiumFire.add(premiumTheft).setScale(2, RoundingMode.CEILING).toString() + " EUR";
    }
}