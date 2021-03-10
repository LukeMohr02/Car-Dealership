package enterprise.util;

import enterprise.EnterpriseNoAppropriateConstructorFoundException;
import enterprise.model.MetaTestData;

import java.lang.reflect.Method;

public class Driver {
    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        //HashMap <Class,Method[]> methodmap = new HashMap<Class, Method[]>();
        HashMap <Method, MetaTestData> resultMap = null;
        try {
             resultMap = new TestDiscovery().runAndStoreTestInformation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(resultMap);
    }
}
