package com.raven.keju.billing;

import com.raven.keju.utils.MathUtils;

import java.math.BigDecimal;

public class StrategyThree implements TaxiCost{
    private BigDecimal cistance;
    private BigDecimal waitingTime;

    public StrategyThree(BigDecimal cistance, BigDecimal waitingTime) {
        this.cistance = cistance;
        this.waitingTime = waitingTime;
    }

    /**
     * 花费
     * @desc 计费规则为默认金额+停车等待金额+长途计费+没公里增收
     * @return
     *
     */
    @Override
    public String billing() {
        String cost="收费";
        String unit="元\\n";
        BigDecimal manyParts= MathUtils.subtract(cistance,baseCistance);
        BigDecimal longHaulPart= MathUtils.subtract(cistance,longHaulCistance);
        BigDecimal unLong=MathUtils.add(baseCost,MathUtils.multiply(manyParts,new BigDecimal(0.8)));
        BigDecimal isLong=MathUtils.multiply(longHaulPart,longHaul);
        BigDecimal all=MathUtils.add(MathUtils.multiply(waitingTime,waitCost),MathUtils.add(unLong,isLong));
        return cost+all+unit;
    }
}
