package ru.oz;

import org.apache.cxf.tools.wsdlto.WSDLToJava;

/**
 * Created by ozol on 07.08.2015.
 */
public class WsdlToJavaGenerator {
    public static void main(String[] args) {
        generateService();
    }

    private static void generateService() {
        try {
            // you can also specify WSDL directly like http://localhost:8080/CXFTutorial/ChangeStudent?wsdl
            WSDLToJava.main(new String[]{"-d", "src/main/java", "src/main/resources/UpdateBonusOrder_SI_Sync_In.wsdl"});
            System.out.println("finished %%%%%%%%%%");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateClient() {
        WSDLToJava.main(new String[] {
                "-client",
                "-d", "src/test/java",
                "-p", "http://ttdev.com/cs=com.ttdev.cs.client",
                "src/main/resources/ComputeService.wsdl" });
        System.out.println("Done!");
    }
}

