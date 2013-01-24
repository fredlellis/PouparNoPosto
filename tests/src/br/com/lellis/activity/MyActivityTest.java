package com.example;

import android.test.ActivityInstrumentationTestCase2;
import br.com.lellis.activity.MyActivity;
import dalvik.annotation.TestTarget;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class br.com.lellis.activity.MyActivityTest \
 * com.example.tests/android.test.InstrumentationTestRunner
 */
public class MyActivityTest extends ActivityInstrumentationTestCase2<MyActivity> {


    public MyActivityTest() throws Throwable {
        super("br.com.lellis.activity", MyActivity.class);
        runTest();
    }
    public void calculoTest(){
        assertEquals(2, 1);
    }
}


