package com.proofit.business.services.calculator.components;

import com.proofit.business.domain.RiskType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CoefficientCalculator {

    @Value( "${DEFAULT_COEFFICIENT_FIRE}" ) protected String defaultCoefficientFire;
    @Value( "${CORRECTED_COEFFICIENT_FIRE}" ) protected String correctedCoefficientFire;
    @Value( "${DEFAULT_COEFFICIENT_THEFT}" ) protected String defaultCoefficientTheft;
    @Value( "${CORRECTED_COEFFICIENT_THEFT}" ) protected String correctedCoefficientTheft;
    @Value( "${FIRE_COEFFICIENT_INFLUENCING_VALUE}" ) protected String fireCoefficientInfluencingValue;
    @Value( "${THEFT_COEFFICIENT_INFLUENCING_VALUE}" ) protected String theftCoefficientInfluencingValue;

    public BigDecimal calculateCoefficient(BigDecimal sumInsured, RiskType riskType) {
        BigDecimal coefficient;
        switch (riskType) {
            case FIRE:
                if (sumInsured.compareTo(BigDecimal.valueOf(Long.parseLong(fireCoefficientInfluencingValue))) > 0) {
                    coefficient = BigDecimal.valueOf(Long.parseLong(correctedCoefficientFire));
                } else {
                    coefficient = BigDecimal.valueOf(Long.parseLong(defaultCoefficientFire));
                }
                break;
            case THEFT:
                if (sumInsured.compareTo(BigDecimal.valueOf(Long.parseLong(theftCoefficientInfluencingValue))) >= 0) {
                    coefficient = BigDecimal.valueOf(Long.parseLong(correctedCoefficientTheft));
                } else {
                    coefficient = BigDecimal.valueOf(Long.parseLong(defaultCoefficientTheft));
                }
                break;
            default:
                coefficient = BigDecimal.ZERO;
        }
        return coefficient;
    }
}