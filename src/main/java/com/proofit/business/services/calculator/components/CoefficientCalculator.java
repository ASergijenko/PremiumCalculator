package com.proofit.business.services.calculator.components;

import com.proofit.business.domain.RiskType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoefficientCalculator {

    @Value("${DEFAULT_COEFFICIENT_FIRE}")
    protected Double defaultCoefficientFire;
    @Value("${CORRECTED_COEFFICIENT_FIRE}")
    protected Double correctedCoefficientFire;
    @Value("${DEFAULT_COEFFICIENT_THEFT}")
    protected Double defaultCoefficientTheft;
    @Value("${CORRECTED_COEFFICIENT_THEFT}")
    protected Double correctedCoefficientTheft;
    @Value("${FIRE_COEFFICIENT_INFLUENCING_VALUE}")
    protected Double fireCoefficientInfluencingValue;
    @Value("${THEFT_COEFFICIENT_INFLUENCING_VALUE}")
    protected Double theftCoefficientInfluencingValue;

    public BigDecimal calculateCoefficient(BigDecimal sumInsured, RiskType riskType) {
        BigDecimal coefficient;
        switch (riskType) {
            case FIRE:
                if (sumInsured.compareTo(BigDecimal.valueOf(fireCoefficientInfluencingValue)) > 0) {
                    coefficient = BigDecimal.valueOf(correctedCoefficientFire);
                } else {
                    coefficient = BigDecimal.valueOf(defaultCoefficientFire);
                }
                break;
            case THEFT:
                if (sumInsured.compareTo(BigDecimal.valueOf(theftCoefficientInfluencingValue)) >= 0) {
                    coefficient = BigDecimal.valueOf(correctedCoefficientTheft);
                } else {
                    coefficient = BigDecimal.valueOf(defaultCoefficientTheft);
                }
                break;
            default:
                coefficient = BigDecimal.ZERO;
        }
        return coefficient;
    }
}