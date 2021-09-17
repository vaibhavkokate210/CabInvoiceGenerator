package com.bridgelabz.carservice;

public class CabData
{
    double distance;
    double time;
    RideType rideType;

    public CabData(double distance, double time, RideType rideType) 
    {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }
}