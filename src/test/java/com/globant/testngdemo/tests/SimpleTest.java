package com.globant.testngdemo.tests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;

public class SimpleTest{

    @Test
    public void thisIsATestNGTestThatWillPass(){
        /**
         * The step by step that is defined in the test cases should
         * be here along with the assertions
         */
        System.out.println("\n\nFirst method");
        System.out.println("Imaginary step 1");
        System.out.println("Imaginary step 2");
        System.out.println("Imaginary step 3");
        System.out.println("Imaginary step 4");

        System.out.println("Test passed");
    }


    @Test
    public void thisIsATestNGTestThatWillFail(){
        System.out.println("\n\nSecond method");
        System.out.println("Imaginary step 2.1");
        System.out.println("Imaginary step 2.2");
        System.out.println("Imaginary step 2.3");
        System.out.println("Imaginary step 2.4");

        boolean youShallNotPass = true;

        assertFalse( youShallNotPass, "This test will never pass");
    }


    @Test
    public void thisIsATestNGTestThatThrowsAnException(){
        System.out.println("\n\nThird method");
        System.out.println("Imaginary step 3.1");
        System.out.println("Imaginary step 3.2");
        System.out.println("Imaginary step 3.3");
        System.out.println("Imaginary step 3.4");

        boolean launchException = true;

        if( launchException ){
            throw  new RuntimeException("Exception launched on purpose");
        }
    }
}
