package com.raven.keju.billing;

import java.math.BigDecimal;

public class StraegyFactoy {
    public static TaxiCost getStraegy(int cistance,int waitingTime){

        if (cistance>2&&cistance<=8){
            return new StrategyTwo(new BigDecimal(cistance),new BigDecimal(waitingTime));
        }

        if (cistance>8){
            return new StrategyThree(new BigDecimal(cistance),new BigDecimal(waitingTime));
        }
        return new StrategyOne(new BigDecimal(waitingTime));
    }
}
