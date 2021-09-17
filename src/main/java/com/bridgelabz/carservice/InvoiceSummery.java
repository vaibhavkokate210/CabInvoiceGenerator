package com.bridgelabz.carservice;

public class InvoiceSummery
{
   public int totalNumberOfRides;
	    public double totalFare;
	    public double avgFarePerRide;

	    public InvoiceSummery(int totalNumberOfRides, double totalFare) 
	    {
	        this.totalNumberOfRides = totalNumberOfRides;
	        this.totalFare = totalFare;
	        this.avgFarePerRide = totalFare/totalNumberOfRides;
	    }
}
