package org.saqsy.components;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface ICostTransform {

    default double setAmountToTwoDecimal(double amount) {
        return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
