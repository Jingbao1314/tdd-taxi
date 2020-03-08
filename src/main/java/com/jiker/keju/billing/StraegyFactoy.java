package com.raven.keju.billing;

import java.math.BigDecimal;
//策略生成器 根据里程生成相应的计费策略
public class StraegyFactoy {
    public static TaxiCost getStraegy(int cistance,int waitingTime){

        //里程在2到8之间 采用策略2计费 (2,8]
        if (cistance>2&&cistance<=8){
            return new StrategyTwo(new BigDecimal(cistance),new BigDecimal(waitingTime));
        }

        //里程大于8之间 采用策略2计费 (8,)
        if (cistance>8){
            return new StrategyThree(new BigDecimal(cistance),new BigDecimal(waitingTime));
        }
        //小于等于2的里程采用策略1
        return new StrategyOne(new BigDecimal(waitingTime));
    }
}
