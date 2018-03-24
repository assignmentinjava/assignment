package com.coding.assignment.airbaggagerouting;

import junit.framework.Test;
import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import com.coding.assignment.airbaggagerouting.AirBaggageRoutingMain;

public class BaggageRoutingTest extends TestCase {

    public void testAirBaggageRouting(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        AirBaggageRoutingMain.main(new String [] {"src/test/data/InputTestData.txt"});
        String output=baos.toString();
        assertEquals("0001 Concourse_A_Ticketing A5 A1 : 11\r\n" +
                "0002 A5 A1 A2 A3 A4 : 9\r\n" +
                "0003 A2 A1 : 1\r\n" +
                "0004 A8 A9 A10 A5 : 6\r\n" +
                "0005 A7 A8 A9 A10 A5 BaggageClaim : 12\r\n",output);
    }
}
