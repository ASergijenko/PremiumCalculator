package com.proofit.business.services.calculator.components;

import com.proofit.business.constants.Constants;
import com.proofit.business.domain.RiskType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoefficientCalculator {
    public BigDecimal calculateCoefficient(BigDecimal sumInsured, RiskType riskType) {
        BigDecimal coefficient;
        switch (riskType) {
            case FIRE:
                if (sumInsured.compareTo(Constants.FIRE_COEFFICIENT_INFLUENCING_VALUE) > 0) {
                    coefficient = Constants.CORRECTED_COEFFICIENT_FIRE;
                } else {
                    coefficient = Constants.DEFAULT_COEFFICIENT_FIRE;
                }
                break;
            case THEFT:
                if (sumInsured.compareTo(Constants.THEFT_COEFFICIENT_INFLUENCING_VALUE) >= 0) {
                    coefficient = Constants.CORRECTED_COEFFICIENT_THEFT;
                } else {
                    coefficient = Constants.DEFAULT_COEFFICIENT_THEFT;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + riskType);
        }
        return coefficient;
    }
}