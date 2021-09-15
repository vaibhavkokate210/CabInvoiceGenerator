package com.bridgelabz.cabservicetest;

import org.junit.Assert;
import org.junit.Test;

import com.bridgelabz.carservice.CabInvoice;

public class CabServiceTest 
{
	@Test
    public void givenDistance_Time_ReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceKm = 10.0;
        double timeMin = 10.0;
        double totalFare = cabInvoice.totalFare(distanceKm, timeMin);
        Assert.assertEquals(50.0,totalFare,0.1);

    }

    @Test
    public void givenLessDistanceOrTime_ReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceKm = 0.1;
        double timeMin = 0.1;
        double totalFare = cabInvoice.totalFare(distanceKm, timeMin);
        double minimumFare = 5.0;
        double minFare = Math.max(totalFare,minimumFare);
        Assert.assertEquals(5, minFare, 0.1);
    }
}
