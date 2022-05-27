package pl.retsuz.conversions.roman;

import pl.retsuz.conversions.GenericNumeralSystem;

public class Roman implements GenericNumeralSystem {

    @Override
    public String fromArabic(int value) {
        if (value > 3000 || value < 1) {
            throw new RuntimeException();
        }
        String result = "";
        int arabArr[] = {1000, 500, 100, 50, 10, 5, 1};
        String romanStr = "MDCLXVI";
        for (int i = 0; i < 7; i++) {
            while (value >= arabArr[i]) {
                result = result.concat(romanStr.substring(i, i + 1));
                value -= arabArr[i];
            }
        }
        return result;
        //throw new UnsupportedOperationException();
    }

    @Override
    public int toArabic(String value) {

        int result = 0;
        int tab1[] = {1000, 500, 100, 50, 10, 5, 1};
        char tab2[] = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        for (int i = 0; i < value.length(); i++) {
            for (int j = 0; j < 7; j++) {
                if (value.charAt(i) == tab2[j]) {
                    result += tab1[j];
                    break;
                }
            }
        }
        return result;
        //throw new UnsupportedOperationException();
    }
}