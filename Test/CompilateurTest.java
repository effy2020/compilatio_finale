
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
    public void testComparisonEqual() {
        String input = "3 == 3==3;";
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
    public void testComplexExpression() {
        String input = "(2 + 3) * 5 == 25;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testHighPriorityOperator() {
        String input = "2 * 3 + 5 == 11;";
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
 
 
//test commentaire
@Test
public void testCommentBetweenExpressions() {
    String input = "1+2; // addition simple 3*4;";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

@Test
public void testMultipleLineComments() {
    String input = """
         5 + 5;
        // Première ligne
        // Deuxième ligne
        """;
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}

 
@Test
public void testBlockCommentInsideExpression() {
    String input = "2; /* commentaire */ 4+ 3;";
    assertDoesNotThrow(() -> new Compilateur(input).mainNT());
}


// Nouveaux tests avec &&
    @Test
    public void testAndTrueFalseComparison() {
        String input = "2 + 3 == 5 && 4 < 3;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testComplexLogicalAndArithmetic() {
        String input = "!(1 + 1 == 2) && (3 * 3 >= 9);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testChainedAndConditions() {
        String input = "True && 2 < 3 && 4 * 2 == 8;";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testImportAndAndExpression() {
        String input = "import malib; (1 + 2 == 3) && (5 > 2) && !(False);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    //tester les affectations

    
    @Test
    public void testAssignmentWithLogicalExpression() {
        String input = "x = (True && False) > (5 + 3 > 7);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testAssignmentWithNestedLogicalAndArithmetic() {
        String input = "x = (y = 2 + 3) * (z = 5 * 6) + (7 > 4);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }


    @Test
    public void testComplexAssignmentWithParentheses() {
        String input = "x = ((y = 3 + 2) * 4) - (z = 5 + 5);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testAssignmentWithBooleanAndArithmetic() {
        String input = "x = (True - False) && (5 * 2 == 10);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    @Test
    public void testAssignmentWithNegationAndExpression() {
        String input = "import malib; x = !(5 > 3) && (z=y = 7 + 3);";
        assertDoesNotThrow(() -> new Compilateur(input).mainNT());
    }

    //tester les expressions de type y=(x+2)


        @Test
        public void testNestedAssignmentInExpression() {
            String input = "a = (b + 3 + 4) * 2;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }

        @Test
        public void testAssignmentWithParenthesizedLogicalExpression() {
            String input = "result = ((x + 5) > 2) && (y / 10) < 20;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }

        @Test
        public void testAssignmentWithMultipleOperators() {
            String input = "z = (a >= 2 + 3) * (b && 4) + c;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }
        // retester les commentaires

        @Test
        public void testCommentaireAvantInstruction() {
            String input = "// Commentaire avant\nx = 42;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }

        @Test
        public void testCommentaireApresInstruction() {
            String input = "y = 10; // Commentaire après";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }


        @Test
        public void testCommentairesComplexesCombines() {
            String input = """
            /* debut */
            import malib;
            // Header
            x =  5;
            /* Calcul */
            y = (x + 2) * 3; // Fin
            """;
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }


    // tester les conditions avec if then else



        @Test
        public void testNestedIfElse() {
            String input = "if (a == b) { if (c > d) x = 1; else x = 2; } else { x = 3; }";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }

        @Test
        public void testIfWithComplexCondition() {
            String input = "if (x >= 5 && y <= 10 > z != 0) result = True; else result = False;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }

        @Test
        public void testIfWithArithmeticExpression() {
            String input = "if ((a + b * 2) > (c - d / 3)) max = a; else max = c;";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }



        @Test
        public void testMultipleCommandsInIfBlock() {
            String input = "if (condition) { x = 5; y = 10; z = x + y; } else { z = 0; }";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }



      
        @Test
        public void testIfWithImportInBlock() {
            String input = "if (flag) { import pkg; x = 10; } else { y = 20; }";
            assertDoesNotThrow(() -> new Compilateur(input).mainNT());
        }





}


