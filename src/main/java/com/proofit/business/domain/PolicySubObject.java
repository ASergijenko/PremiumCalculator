package com.proofit.business.domain;

import java.math.BigDecimal;

public class PolicySubObject {

    private String subObjectName;
    private BigDecimal sumInsured;
    private RiskType riskType;

    public PolicySubObject(String subObjectName, BigDecimal sumInsured, RiskType riskType) {
        this.subObjectName = subObjectName;
        this.sumInsured = sumInsured;
        this.riskType = riskType;
    }

    public String getSubObjectName() {
        return subObjectName;
    }

    public void setSubObjectName(String subObjectName) {
        this.subObjectName = subObjectName;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public RiskType getRiskType() {
        return riskType;
    }

    public void setRiskType(RiskType riskType) {
        this.riskType = riskType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PolicySubObject that = (PolicySubObject) o;

        if (subObjectName != null ? !subObjectName.equals(that.subObjectName) : that.subObjectName != null)
            return false;
        if (sumInsured != null ? !sumInsured.equals(that.sumInsured) : that.sumInsured != null) return false;
        return riskType == that.riskType;
    }

    @Override
    public int hashCode() {
        int result = subObjectName != null ? subObjectName.hashCode() : 0;
        result = 31 * result + (sumInsured != null ? sumInsured.hashCode() : 0);
        result = 31 * result + (riskType != null ? riskType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PolicySubObject{" +
                "subObjectName='" + subObjectName + '\'' +
                ", sumInsured=" + sumInsured +
                ", riskType=" + riskType +
                '}';
    }
}