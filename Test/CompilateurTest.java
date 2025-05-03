
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

public class CompilateurTest {

    @Test
    public void testBooleanTrue() {
        String input = "True;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
 
    @Test
    public void testValidComparison() {
        String input = "(3 + 5 == 8);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testNegationWithComparison() {
        String input = "!(2 == 3);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testNotAndComparison() {
        String input = "!True == False;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testUnaryMinusWithComparison() {
        String input = "-(2 == 0);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }
 
    @Test
    public void testNestedComparison() {
 
        String input = "(2 != 3) == (4 != 5);";
 
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testDoubleComparison() {
        String input = "2 <= 3 >= 1;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testNestedArithmeticAndComparison() {

        String input = "(2 + (3 <= 4)) == False;";

        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

 
   
    @Test
public void testDeeplyNestedExpression() {
    String input = "!((2 + 3) * (4 - 1) != 15);"; // !(5 * 3 == 15) → !(True) → False
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
 

@Test
public void testMultipleComparisonsWithArithmetic() {
    String input = "((2 + 2) * -2) == 8 == True;"; // (4 * 2 == 8) == True → True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNegationOnComparisonResult() {
    String input = "-(-2 == 2) + 1 != 0;"; // -(True) + 1 == 0 → -1 + 1 == 0
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNestedNotAndArithmetic() {
    String input = "!(2 + 2 <= 5) == True;"; // !(False) == True → True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testLongChainedExpression() {
    String input = "1 + 2 * 3 - 4 / 2 + (6 != 6) == 7 + True;"; // mixte logique et arithmétique
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
@Test
public void testArithmeticWithMultipleComparisons() {
    String input = "((2 + 3) * 2 >= 10) <= (5 * 2 != 10);";  // True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testDeepNegationAndArithmetic() {
    String input = "!(-(3 + 2) + 5 == -0);";  // !(-5 + 5 == 0) → !(0 == 0) → !True → False
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testArithmeticLogicChain() {
    String input = "2 + 3 * 4 <= 14 != False >= True;"; // mixte : 2 + (3*4) == 14 → True != False == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testLogicalAndArithmeticCombined() {
    String input = "!(2 + 2 > 5) < (3 * 3 + 1 != 10);";  // !False == True → True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNegationNestedComparison() {
    String input = "!((2 >= 2)< (3 != 3));"; // !(True == False) → !(False) → True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testMultipleLayersOfLogicAndArithmetic() {
    String input = "!((1 + 1 == 2) != (2 * 2 >= 5));";  // !(True != False) → !(True) → False
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNegatedBooleanArithmeticMix() {
    String input = "-(!True == False) + 1 <= (!1);"; // -True + 1 == 1 → -1 + 1 == 0
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNestedArithmeticComparisonLogic() {
    String input = "(3 + 2) * (4 - 1) <= 15 >= (5 * 3 == 15);"; // True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testSceintificNumber() {
    String input = "(.3e2 + 2) * (4e-23 - 1) <= 15 >= (5.234e6 * 3 == 15);"; // True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testNanNumber() {
    String input = "(NaN+2 );"; // True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

 
@Test
public void testMixedArithmeticAndBoolean() {
    String input = "2+3 == 5; 5*4 != 20; !(10/2 > 3);";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}


@Test
public void testExpression3() {
    String input = "2+3;2;2-3;"; // True == True
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
 
@Test
public void testImportThenMultipleExpressions() {
    String input = "import malib; 2+3; 4*5; True == False;";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
@Test
public void testMultipleImportsAndExpressions() {
    String input = "import malib; import utils; 1 + 2; 3 == 3;";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
@Test
public void testImportAndComplexExpressions() {
    String input = "import malib; ((2 + 3) * 4 >= 20) == !(False);";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}
 
}