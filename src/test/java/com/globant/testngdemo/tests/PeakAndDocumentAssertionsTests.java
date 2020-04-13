package com.globant.testngdemo.tests;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.DayOfWeek;
import java.util.List;

import static org.testng.Assert.*;

public class PeakAndDocumentAssertionsTests extends BaseTest{

    //Basic boolean assertion
    @Test(priority = 1,groups = {"group1"})
    public void checkMondayDigits(){
        boolean canDoc3GoOutMonday = mgr.canIGoOut("111111113",DayOfWeek.MONDAY);

        assertTrue( canDoc3GoOutMonday,
                "document finishing on 3 cannot go out on monday");

        boolean canDoc4GoOutMonday  = mgr.canIGoOut("11111114", DayOfWeek.MONDAY);

        assertFalse( canDoc4GoOutMonday,
                "document finishing on 4 cannot go out on monday");
    }

    //Example of failed assertion
    @Test(priority = 2)
    public void failedAssertion(){
        boolean canIGoOut  = mgr.canIGoOut("11111114", DayOfWeek.MONDAY);

        assertTrue( canIGoOut ,"document finishing on 4 cannot go out on monday");
    }

    //Assertion based on object comparison
    @Test(priority = 3,groups = {"group1","group2"})
    public void chechDaysFor1(){

        List<DayOfWeek> daysFor1 = mgr.getDaysPerDigit( 1 );

        DayOfWeek[] obtained = daysFor1.toArray( new DayOfWeek[daysFor1.size()]);
        DayOfWeek[] expected = {DayOfWeek.MONDAY,DayOfWeek.THURSDAY};

        assertEquals( obtained, expected, "The digit 1 is expected to be on monday and tuesday" );
    }


    //Multiple assertions
    @Test(priority = 4,groups = {"group2"})
    public void checkDocumentsFinishingOn0(){
        assertTrue(
                mgr.canIGoOut(
                        "4354354350",
                        DayOfWeek.THURSDAY
                ));

        assertTrue(
                mgr.canIGoOut(
                        "4354354350",
                        DayOfWeek.SUNDAY
                ));

        assertFalse(
                mgr.canIGoOut(
                        "4354354350",
                        DayOfWeek.MONDAY
                ));
    }

    @Test(priority = 5,groups = {"group2"})
    public void checkDigitsByDay(){
        assertTrue(
                mgr.getDigitsByDay( DayOfWeek.MONDAY ).contains( 1 )
        );

        assertTrue(
                mgr.getDigitsByDay( DayOfWeek.MONDAY ).contains( 2 )
        );

        assertTrue(
                mgr.getDigitsByDay( DayOfWeek.MONDAY ).contains( 3 )
        );
    }


    //Assertion based on exceptions
    @Test(expectedExceptions = {java.lang.NumberFormatException.class}, priority = 6,groups = {"group3"})
    public void checkException(){
        assertTrue(
                mgr.canIGoOut(
                        "4354354350l",
                        DayOfWeek.THURSDAY
                ));
    }

    @Test(priority = 7,groups = {"group3"})
    public void checkException2(){
        assertThrows(
                java.lang.NumberFormatException.class,
                () -> mgr.canIGoOut(
                        "4354354350l",
                        DayOfWeek.THURSDAY
                ));

        assertThrows(java.lang.NumberFormatException.class,
                () -> mgr.canIGoOut(
                        "4354354350.",
                        DayOfWeek.THURSDAY
                ));

        assertThrows(java.lang.NumberFormatException.class,
                () -> mgr.canIGoOut(
                        "4354354350?",
                        DayOfWeek.THURSDAY
                ));
    }


    @Test(priority = 8)
    public void checkSoftAssertions(){
        SoftAssert soft = new SoftAssert();

        soft.assertTrue( false );

        System.out.println("At this point the first assertion already failed");
        soft.assertFalse( true , "We expected a false value");

        System.out.println("At this point there are two assertions failed");
        soft.assertTrue( true );

        System.out.println("This assertion mark the test as failed");
        soft.assertAll();

        System.out.println("This statement is not reached because the assertion failed");
    }
}
