package com.coding.assignment.airbaggagerouting;

import java.util.List;

import com.coding.assignment.airbaggagerouting.model.DirectedEdge;

public interface AirBaggageRoutingAlgorithm {
    public String findShortestPath(String entry,String dest, List<DirectedEdge> graphEdges);
}
