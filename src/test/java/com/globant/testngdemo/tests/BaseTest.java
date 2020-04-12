package com.globant.testngdemo.tests;

import academy.PeakAndDocumentManagerStatic;
import academy.PeakAndDocumentMgr;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Example of "template method" pattern
 */
public class BaseTest {

    protected PeakAndDocumentMgr mgr;


    @BeforeTest(alwaysRun = true)
    public void superClassBeforeSet(){
        System.out.println("BASETEST.BEFORETEST...");
        mgr = new PeakAndDocumentManagerStatic();
        System.out.println();
    }

    @BeforeClass
    public void superClassBeforeClass(){
        System.out.println("BeforeTest...\n");
    }
}
