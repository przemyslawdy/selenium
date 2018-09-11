package components;

import java.math.BigDecimal;

public class Helpers {

    public static BigDecimal convertPriceToBigDecimal(String price) {

        price = price.replaceAll("[$,]", "");
        return new BigDecimal(price).setScale(2, BigDecimal.ROUND_HALF_EVEN);

    }


}
