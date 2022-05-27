package pl.retsuz.conversions;

public class Converter {

    public String convert(GenericNumeralSystem from, GenericNumeralSystem to, String value) {

        int arabic = from.toArabic(value);
        String result = to.fromArabic(arabic);
        return result;
    }
}
