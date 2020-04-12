package com.globant.qasummit.tests;

import academy.PeakAndDocumentManagerStatic;
import academy.PeakAndDocumentMgr;
import org.testng.annotations.*;

import java.time.DayOfWeek;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PeakAndDocumentParameterTests {


    private PeakAndDocumentMgr mgr;


    @BeforeClass
    public void setupManager(){
        System.out.println("BeforeSuite...");
        mgr = new PeakAndDocumentManagerStatic();
        System.out.println();
    }

    @Parameters({"documentToValidate","expectedDay"})
    @Test
    public void checkDayByDocument( String parameter,
                                         DayOfWeek expectedDay){
        System.out.println("Document passed as parameter: "+parameter);
        System.out.println("Day passed as parameter: "+expectedDay);
        boolean yesICan = mgr.canIGoOut( parameter, expectedDay );

        assertTrue( yesICan, "The document "+parameter+" should be able to go out on "+expectedDay);
    }
}
