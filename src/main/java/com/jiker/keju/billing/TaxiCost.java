package com.raven.keju.billing;


import java.math.BigDecimal;

public interface TaxiCost {
    BigDecimal baseCistance=new BigDecimal(2);
    BigDecimal longHaulCistance=new BigDecimal(8);
    BigDecimal baseCost=new BigDecimal(6);
    BigDecimal longHaul=new BigDecimal(0.5);
    BigDecimal waitCost=new BigDecimal(0.25);
    String billing();
}
