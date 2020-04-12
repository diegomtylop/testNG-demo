package com.globant.qasummit.tests;

import academy.PeakAndDocumentManagerStatic;
import academy.PeakAndDocumentMgr;
import com.globant.qasummit.dataprovider.DocumentsProvider;
import org.testng.annotations.*;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static  org.testng.Assert.*;
public class PeakAndDocumentFunctionalTests {

    private PeakAndDocumentMgr mgr;


    @BeforeSuite
    public void setupManager(){
        System.out.println("BeforeSuite...\n");

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("BeforeClass...");
        mgr = new PeakAndDocumentManagerStatic();
        System.out.println();
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest...\n");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod...");
        mgr = new PeakAndDocumentManagerStatic();
    }

    @Test
    public void checkAtLeastTwoDigitsPerDay(){
        List results = Arrays.stream(DayOfWeek.values())
                .filter( day -> mgr.getDigitsByDay( day ).size() >= 2 )
                .collect( Collectors.toList());

        assertEquals( results.size(), 7, "All the days should have more than two digits");
    }

    @Test
    public void checkOnlyOneDayHasTwoDigits(){
        List onlyTwoDigitsDays = Arrays.stream(DayOfWeek.values())
                .filter( day -> mgr.getDigitsByDay( day ).size() == 2 )
                .collect( Collectors.toList());

        assertEquals( onlyTwoDigitsDays.size(), 1, "Only one day should have two digits");
    }

    @Test
    public void checkNoMoreThan3DigitsPerDay(){
        List withMoreThan3 = Arrays.stream(DayOfWeek.values())
                .filter( day -> mgr.getDigitsByDay( day ).size() > 3 )
                .collect( Collectors.toList());

        assertEquals( withMoreThan3.size(), 0, "There can be no more than 3 digits per day");
    }

    @Test
    public void checkOnlyTwoDaysPerDigit() {
        for( int digit = 0; digit <= 9; digit ++ ) {
            List<DayOfWeek> days = mgr.getDaysPerDigit(digit);
            System.out.println(digit + ": " + days);

            //Assert that for every digit there are 2 days
            assertEquals( days.size(), 2, "Digit "+digit+", no only two days");
        }
    }

    @Test(dataProvider = "document-provider",dataProviderClass = DocumentsProvider.class,groups = "tdd")
    public void checkWithMultipleDocuments(String document) {
        List<DayOfWeek> availableDays = mgr.getDaysPerDocument( document );

        System.out.println("Document: "+document+", available days: "+availableDays);
        assertEquals( availableDays.size(), 2, "The document "+document+" should have 2 available days");
    }
}
