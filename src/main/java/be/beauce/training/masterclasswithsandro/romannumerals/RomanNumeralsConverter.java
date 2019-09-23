package be.beauce.training.masterclasswithsandro.romannumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralsConverter {

    Map<Integer, String> numberMapping = new LinkedHashMap<Integer, String>(){{
        put(1000, "M");
        put(900, "CM");
        put(500, "D");
        put(400, "CD");
        put(100, "C");
        put(90, "XC");
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4, "IV");
        put(1, "I");
    }};

    public String convert(int number) {
        StringBuilder resultBuilder = new StringBuilder();

        int remainder = number;
        for (Integer key : numberMapping.keySet()) {
            int count = remainder / key;
            remainder %= key;

            for (int i = 0; i < count; i++) {
                resultBuilder.append(numberMapping.get(key));
            }
        }
        return resultBuilder.toString();
    }
}
