import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CompilateurTest {
    @Test
    public void testBooleanTrue() {
        String input = "True;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
    @Test
    public void testBooleanFalse() {
        String input = "False;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testComparisonEqual() {
        String input = "3 == 3;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testComparisonLessThanOrEqual() {
        String input = "2 <= 3;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testInvalidToken() {
        String input = "True == true;";
        assertThrows(TokenMgrError.class, () -> new Compilateur(input).mainNT());
    }

    @Test
    public void testInvalidComparison() {
        String input = "(3 + 5 == 8;";
        assertThrows(ParseException.class, () -> new Compilateur(input).mainNT());
    }

    @Test
    public void testComplexExpression() {
        String input = "(3 + 5) == 8;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
	@Test
    public void testNotEqulas() {
        String input = "True != False;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
	
    @Test
    public void testGrEqNb() {
        String input = "2>=5;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
	
	@Test
	public void testExpNot() {
        String input = "!True;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
 
    @Test
    public void testExpNot2() {
        String input = "True ! true;";
        assertThrows(ParseException.class, () -> new Compilateur(input).mainNT());
    }
	
}
