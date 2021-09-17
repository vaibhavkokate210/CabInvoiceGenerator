package com.bridgelabz.cabservicetest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bridgelabz.carservice.CabData;
import com.bridgelabz.carservice.CabInvoice;
import com.bridgelabz.carservice.InvoiceSummery;
import com.bridgelabz.carservice.MultipleUsers;
import com.bridgelabz.carservice.Rate;
import com.bridgelabz.carservice.RideType;

public class CabServiceTest<K, V> 
{
	ArrayList<CabData> cabData = new ArrayList<>();
    ArrayList<ArrayList<CabData>> users = new ArrayList<>();
    public Rate rate = new Rate(10,1,5,15,2,20);
	@Test
    public void givenDistance_Time_ReturnTotalFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceKm = 10.0;
        double timeMin = 10.0;
        double totalFare = cabInvoice.totalFare(distanceKm, timeMin,RideType.NORMAL_RIDE);
        Assert.assertEquals(50.0,totalFare,0.1);

    }

    @Test
    public void givenLessDistanceOrTime_ReturnMinFare() {
        CabInvoice cabInvoice = new CabInvoice();
        double distanceKm = 0.1;
        double timeMin = 0.1;
        double totalFare = cabInvoice.totalFare(distanceKm, timeMin,RideType.NORMAL_RIDE);
        Assert.assertEquals(5, totalFare, 0.1);
    }
    @Before
    public void setUp(){
        CabInvoice cabInvoice = new CabInvoice();
        MultipleUsers mu = new MultipleUsers();

        users.add(cabData);
        cabData.add(new CabData(10,10, RideType.NORMAL_RIDE ));
        cabData.add(new CabData(0.1,0.1, RideType.NORMAL_RIDE));

        users.add(cabData = new ArrayList<>());
        cabData.add(new CabData(20,20,RideType.PREMIUM_RIDE));
        cabData.add(new CabData(0.2,0.2,RideType.NORMAL_RIDE));
        cabData.add(new CabData(5,10,RideType.PREMIUM_RIDE));

        mu.storingInvoiceObjects(users);
    }
    @Test   
    public void givenMultipleRides_ReturnTotalFare(){
        CabInvoice cabInvoice = new CabInvoice();
        double fare = cabInvoice.calculateFares(cabData);
        Assert.assertEquals(55, fare, 0.1);

    }

    @Test
    public void GivenMultipleRides_ReturnInvoiceSummary()
    {
        CabInvoice cabInvoice = new CabInvoice();
        InvoiceSummery invSum = cabInvoice.invoiceSummary(cabData);
        InvoiceSummery expected = new InvoiceSummery( 2,55);
        int equal =0;
        if ((expected.totalNumberOfRides == invSum.totalNumberOfRides) && (expected.totalFare == invSum.totalFare) && (expected.avgFarePerRide == invSum.avgFarePerRide))
            equal =1;

        Assert.assertEquals(1, equal);
    }
    
    @Test
    public void GivenID_Return_SummaryObject()
    {
        CabInvoice cabInvoice = new CabInvoice();
        MultipleUsers<K,V> mu = new MultipleUsers<K,V>();
        InvoiceSummery is = mu.getInvoiceSummary();

        cabInvoice.PrintDetailsFromInvoice(is);

    }
}
