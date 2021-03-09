package enterprise.util;

import dealership.ui.TakeUserInput;
import enterprise.annotations.TestClass;
import enterprise.annotations.TestMethod;

import java.util.Scanner;

@TestClass(name = "TakeUserInput test class")
public class TakeUserInputTest {
    Scanner scan = new Scanner(System.in);

    @TestMethod(name = "Input test 1", expected = "specific action #2")
    public String takeInputTest1() {
        System.out.println("Input test 1. Please select an option from the list below: (Expected: \"specific action #2\")");
        return TakeUserInput.takeInput(scan, new String[]{"specific action #1", "specific action #2"}, new String[]{"default action #1"});
    }

    @TestMethod(name = "Input test 2", expected = "potato")
    public String takeInputTest2() {
        System.out.println("Input test 2. Please select an option from the list below: (Expected: \"potato\")");
        return TakeUserInput.takeInput(scan, new String[]{"onion"}, new String[]{"tomato", "potato"});
    }

    @TestMethod(name = "Input test 3", expected = "")
    public String takeInputTest3() {
        System.out.println("Input test 3. Please select an option from the list below: (Expected: \"\")");
        return TakeUserInput.takeInput(scan, new String[]{""}, new String[]{""});
    }

}
