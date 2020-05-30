package com.proofit.business.domain;

import java.util.List;

public class PolicyObject {

    private String objectName;
    private List<PolicySubObject> policySubObjects;

    public PolicyObject(String objectName, List<PolicySubObject> policySubObjects) {
        this.objectName = objectName;
        this.policySubObjects = policySubObjects;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public List<PolicySubObject> getPolicySubObjects() {
        return policySubObjects;
    }

    public void setPolicySubObjects(List<PolicySubObject> policySubObjects) {
        this.policySubObjects = policySubObjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PolicyObject that = (PolicyObject) o;

        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        return policySubObjects != null ? policySubObjects.equals(that.policySubObjects) : that.policySubObjects == null;
    }

    @Override
    public int hashCode() {
        int result = objectName != null ? objectName.hashCode() : 0;
        result = 31 * result + (policySubObjects != null ? policySubObjects.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PolicyObject{" +
                "objectName='" + objectName + '\'' +
                ", policySubObjects=" + policySubObjects +
                '}';
    }
}
