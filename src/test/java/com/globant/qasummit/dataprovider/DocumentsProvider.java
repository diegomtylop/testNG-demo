package com.globant.qasummit.dataprovider;

import org.testng.annotations.DataProvider;

public class DocumentsProvider {

    @DataProvider(name = "document-provider")
    public static Object[][] getListOfDocuments()
    {
        return new Object[][] {
                { "1111111112" },
                { "22222228" },
                { "333333339" },
                { "9999999990" },
                { "8888881" },
                { "77777773" },
                { "44444443333" }
        };
    }
}
