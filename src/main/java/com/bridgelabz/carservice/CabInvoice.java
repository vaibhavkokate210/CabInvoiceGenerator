package com.bridgelabz.carservice;

public class CabInvoice 
{
	  public static final double COST_PER_TIME = 1.0;
	   public static final double COST_PER_KM = 4.0;

	    public double totalFare(double distanceKm, double timeMin)
	    {
	        double totalPrice = distanceKm*COST_PER_KM + timeMin*COST_PER_TIME;
	        return totalPrice;
        }
}