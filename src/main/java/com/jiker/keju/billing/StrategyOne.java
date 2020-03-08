package com.raven.keju.billing;

import com.raven.keju.utils.MathUtils;

import java.math.BigDecimal;
//策略一
public class StrategyOne  implements TaxiCost{
    private int cistance;
    private BigDecimal waitingTime;

    public StrategyOne(BigDecimal waitingTime) {
        this.waitingTime = waitingTime;
    }

    /**
     * 花费
     * @desc 计费规则为默认金额+停车等待金额
     * @return
     *
     */
    @Override
    public String billing() {
        String cost="收费";
        String unit="元\\n";
        BigDecimal waitPart=MathUtils.multiply(waitingTime,waitCost);
        BigDecimal all=MathUtils.add(waitPart,baseCost);
        return cost+all+unit;
    }
}
