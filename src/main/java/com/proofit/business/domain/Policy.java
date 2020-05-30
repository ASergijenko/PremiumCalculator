package com.proofit.business.domain;

import java.util.List;

public class Policy {

    private String policyNumber;
    private PolicyStatus policyStatus;
    private List<PolicyObject> policyObjects;

    public Policy(String policyNumber, PolicyStatus policyStatus, List<PolicyObject> policyObjects) {
        this.policyNumber = policyNumber;
        this.policyStatus = policyStatus;
        this.policyObjects = policyObjects;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public List<PolicyObject> getPolicyObjects() {
        return policyObjects;
    }

    public void setPolicyObjects(List<PolicyObject> policyObjects) {
        this.policyObjects = policyObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Policy policy = (Policy) o;

        if (policyNumber != null ? !policyNumber.equals(policy.policyNumber) : policy.policyNumber != null)
            return false;
        if (policyStatus != policy.policyStatus) return false;
        return policyObjects != null ? policyObjects.equals(policy.policyObjects) : policy.policyObjects == null;
    }

    @Override
    public int hashCode() {
        int result = policyNumber != null ? policyNumber.hashCode() : 0;
        result = 31 * result + (policyStatus != null ? policyStatus.hashCode() : 0);
        result = 31 * result + (policyObjects != null ? policyObjects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyStatus=" + policyStatus +
                ", policyObjects=" + policyObjects +
                '}';
    }
}