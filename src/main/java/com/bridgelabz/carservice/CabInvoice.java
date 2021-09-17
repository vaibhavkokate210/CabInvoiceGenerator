package com.bridgelabz.carservice;

import java.util.ArrayList;

public class CabInvoice 
{
	  public static final double COST_PER_TIME = 1.0;
	   public static final double COST_PER_KM = 4.0;

	    public double totalFare(double distanceKm, double timeMin)
	    {
	        double totalPrice = distanceKm*COST_PER_KM + timeMin*COST_PER_TIME;
	        return totalPrice;
        }

	    public double calculateFares(ArrayList<CabData> cabData)
	    {
	        double fare = 0;
	        for (CabData cd : cabData)
	        {
	            fare += totalFare(cd.distance,cd.time);
	        }
	        return fare;
	    }
	    
	    public InvoiceSummery invoiceSummary(ArrayList<CabData> cabData)
	    {
	        int numberOfRides = cabData.size();
	        double totalFare = calculateFares(cabData);

	        return new InvoiceSummery(numberOfRides, totalFare);
	    }
	    
	    public void PrintDetailsFromInvoice(InvoiceSummery is)
	    {
	        System.out.println("Total Number of rides :- " + is.totalNumberOfRides);
	        System.out.println("Total fare of ride :- " + is.totalFare);
	        System.out.println("Average fare of ride :- " + is.avgFarePerRide);
	    }
}