import org.junit.jupiter.api.Test;
import pl.retsuz.conversions.Converter;
import pl.retsuz.conversions.arabic.Arabic;
import pl.retsuz.conversions.roman.Roman;
import pl.retsuz.conversions.urnfield.Urnfield;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {
    @Test
    public void testValueDoesNotGetChangedWhenUsingTheSameSystem()
    {
        Converter converter = new Converter();

        String arabicNumber = converter.convert(new Arabic(), new Arabic(), "1");
        String romanNumber = converter.convert(new Roman(), new Roman(), "I");
        String urnfieldNumber = converter.convert(new Urnfield(), new Urnfield(), "/");

        assertEquals("1", arabicNumber);
        assertEquals("I", romanNumber);
        assertEquals("/", urnfieldNumber);
    }

    @Test
    public void testConvertsOneToOne()
    {
        Converter converter = new Converter();

        assertEquals("I",converter.convert(new Arabic(), new Roman(), "1"));
        assertEquals("1",converter.convert(new Roman(), new Arabic(), "I"));
        assertEquals("/",converter.convert(new Roman(), new Urnfield(), "I"));
        assertEquals("/",converter.convert(new Arabic(), new Urnfield(), "1"));
        assertEquals("I",converter.convert(new Urnfield(), new Roman(), "/"));
        assertEquals("1",converter.convert(new Urnfield(), new Arabic(), "/"));
    }
}
