package com.proofit.business.constants;

import java.math.BigDecimal;

public class Constants {

    public final static BigDecimal DEFAULT_COEFFICIENT_FIRE = BigDecimal.valueOf(0.014);
    public final static BigDecimal CORRECTED_COEFFICIENT_FIRE = BigDecimal.valueOf(0.024);

    public final static BigDecimal DEFAULT_COEFFICIENT_THEFT = BigDecimal.valueOf(0.11);
    public final static BigDecimal CORRECTED_COEFFICIENT_THEFT = BigDecimal.valueOf(0.05);

    public final static BigDecimal FIRE_COEFFICIENT_INFLUENCING_VALUE = BigDecimal.valueOf(100.00);
    public final static BigDecimal THEFT_COEFFICIENT_INFLUENCING_VALUE = BigDecimal.valueOf(15.00);

}