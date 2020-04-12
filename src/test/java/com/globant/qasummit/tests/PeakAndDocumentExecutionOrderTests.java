package com.globant.qasummit.tests;
import org.testng.annotations.*;

public class PeakAndDocumentExecutionOrderTests {

    //BEFORE
    @BeforeSuite
    public void setupManager(){
        System.out.println("BeforeSuite...\n");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass...\n");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest...\n");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod...");
    }

    //AFTER
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass...\n");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest...\n");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method...\n");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite...");
    }


    //ACTUAL TESTS
    @Test
    public void checkSomethingInteresting(){
        //Here would be the step by step
        System.out.println("1. Test");
    }

    @Test
    public void checkSomethingWeird(){
        //Here would be the step by step
        System.out.println("2. Test");
    }

    @Test
    public void checkSomethingGood(){
        //Here would be the step by step
        System.out.println("3. Test");
    }
}
