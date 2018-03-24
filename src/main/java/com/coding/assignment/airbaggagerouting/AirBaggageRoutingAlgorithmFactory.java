package com.coding.assignment.airbaggagerouting;

public class AirBaggageRoutingAlgorithmFactory {

    public static AirBaggageRoutingAlgorithm createAirBaggageRoutingAlgorithm(){
        return new AirBaggageRoutingAlgorithmImpl();
    }
}
