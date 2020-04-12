package com.globant.testngdemo.tests;
import org.testng.annotations.*;

public class PeakAndDocumentExecutionOrderTests extends BaseTest {

    //BEFORE
    @BeforeSuite
    public void setupManager(){
        System.out.println("BeforeSuite...\n");
    }

    @BeforeTest
    public void subClassBeforeTest(){
        System.out.println("BeforeTest...\n");
    }

    @BeforeClass
    public void subClassBeforeClass(){
        System.out.println("BeforeTest...\n");
    }



    @BeforeMethod
    public void bbbbbb(){
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
