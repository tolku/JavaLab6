package pl.retsuz.conversions.urnfield;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Urnfield implements GenericNumeralSystem {

    @Override
    public String fromArabic(int val) {
        if (val > 29 || val < 1) {
            throw new RuntimeException();
        }
        String result = "";
        String fives = "";
        while (val > 0) {
            if (val >= 5) {
                val -= 5;
                fives += '\\';
            } else {
                result += '/';
                val -= 1;
            }
        }
        result += fives;
        return result;
    }

    @Override
    public int toArabic(String val) {
        int result = 0;
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == '/') {
                result += 1;
            } else if (val.charAt(i) == '\\') {
                result += 5;
            }
        }
        return result;
    }
}

