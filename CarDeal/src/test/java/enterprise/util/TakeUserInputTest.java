package enterprise.util;

import dealership.ui.TakeUserInput;
import enterprise.annotations.TestClass;
import enterprise.annotations.TestMethod;

import java.util.Scanner;

@TestClass
public class TakeUserInputTest {
    Scanner scan = new Scanner(System.in);

    @TestMethod(name = "Input test 1", expected = "specific action #2")
    public String takeInputTest1() {
        return TakeUserInput.takeInput(scan, new String[]{"specific action #1", "specific action #2"}, new String[]{"default action #1"});
    }

    @TestMethod(name = "Input test 2", expected = "potato")
    public String takeInputTest2() {
        return "potato";
//        return TakeUserInput.takeInput(scan, new String[]{"onion"}, new String[]{"tomato", "potato"});
    }

    @TestMethod(name = "Input test 3", expected = "")
    public String takeInputTest3() {
        return TakeUserInput.takeInput(scan, new String[]{}, new String[]{});
    }

}
