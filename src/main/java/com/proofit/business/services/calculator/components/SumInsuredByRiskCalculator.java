package com.proofit.business.services.calculator.components;

import com.proofit.business.domain.Policy;
import com.proofit.business.domain.PolicySubObject;
import com.proofit.business.domain.RiskType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SumInsuredByRiskCalculator {
    public BigDecimal calculateSumInsured(Policy policy, RiskType riskType) {
        return policy.getPolicyObjects().stream()
                .flatMap(PolicyObject -> PolicyObject.getPolicySubObjects().stream())
                .filter(policySubObject -> policySubObject.getRiskType().equals(riskType))
                .map(PolicySubObject::getSumInsured)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}