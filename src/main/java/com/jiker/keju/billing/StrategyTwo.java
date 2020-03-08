package com.raven.keju.billing;

import com.raven.keju.utils.MathUtils;

import java.math.BigDecimal;

public class StrategyTwo implements TaxiCost{
    private BigDecimal cistance;
    private BigDecimal waitingTime;

    public StrategyTwo(BigDecimal cistance, BigDecimal waitingTime) {
        this.cistance = cistance;
        this.waitingTime = waitingTime;
    }

    @Override
    public String billing() {
        String cost="收费";
        String unit="元\\n";
        BigDecimal manyParts=MathUtils.subtract(cistance,baseCistance);
        BigDecimal waitPart=MathUtils.multiply(waitingTime,waitCost);
        BigDecimal other=MathUtils.add(baseCost,MathUtils.multiply(manyParts,new BigDecimal(0.8)));
        BigDecimal all=MathUtils.add(waitPart,other);
        return cost+all+unit;
    }
}
