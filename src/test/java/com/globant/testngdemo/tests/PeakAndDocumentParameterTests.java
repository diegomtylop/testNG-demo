package com.globant.testngdemo.tests;

import org.testng.annotations.*;
import java.time.DayOfWeek;
import static org.testng.Assert.assertTrue;

public class PeakAndDocumentParameterTests  extends BaseTest{

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
