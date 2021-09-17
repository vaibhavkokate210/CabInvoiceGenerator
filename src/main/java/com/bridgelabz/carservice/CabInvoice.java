package com.bridgelabz.carservice;

import java.util.ArrayList;

public class CabInvoice 
{
	  public static final double COST_PER_TIME = 1.0;
	   public static final double COST_PER_KM = 4.0;
	   Rate rate = new Rate(10,1,5,15,2,20);
	   
	   public double totalFare(double distanceInKm, double timeInMin ,RideType rideType){
	        int i=0;

	        if (rideType.equals(RideType.NORMAL_RIDE)) {
	           double totalPrice = distanceInKm * rate.normalRatePerKM + timeInMin * rate.normalRatePerMIN;
	            return Math.max(totalPrice, rate.normalMinFare);
	        }
	        else {
	            double totalPrice = distanceInKm * rate.premiumRatePerKM + timeInMin * rate.premiumRatePerMIN;
	            return Math.max(totalPrice, rate.premiumMinFare);
	        }


	    }
	   public double calculateFares(ArrayList<CabData> cabData)
	   {
	        double fare = 0;
	        for (CabData cd : cabData)
	            fare += totalFare(cd.distance,cd.time,cd.rideType);

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