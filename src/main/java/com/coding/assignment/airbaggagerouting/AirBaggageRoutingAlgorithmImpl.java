package com.coding.assignment.airbaggagerouting;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.coding.assignment.airbaggagerouting.model.AirBaggageRoutingGraphMap;
import com.coding.assignment.airbaggagerouting.model.DirectedEdge;
import com.coding.assignment.airbaggagerouting.model.Vertex;

public class AirBaggageRoutingAlgorithmImpl implements AirBaggageRoutingAlgorithm {

    private final static String SINGLE_WHITE_SPACE=" ";

    Map<String, AirBaggageRoutingGraphMap> visitedMap=new ConcurrentHashMap<>(); // Visited map with the sourceName as the key

    @Override
    public String findShortestPath(String entryGate, String destGate, List<DirectedEdge> edges) {
    	AirBaggageRoutingGraphMap airBaggageRoutingGraphMap;
        if(visitedMap.containsKey(entryGate)){
        	airBaggageRoutingGraphMap = visitedMap.get(entryGate);
        }else {
        	airBaggageRoutingGraphMap = new AirBaggageRoutingGraphMap(edges);
        	airBaggageRoutingGraphMap.airBaggageRouting(entryGate);
            visitedMap.put(entryGate,airBaggageRoutingGraphMap);
        }

        List<Vertex> shortestPath= airBaggageRoutingGraphMap.getShortestPath(destGate);
        return generatePathLine(shortestPath);
    }

    private String generatePathLine(List<Vertex> path){
        StringBuffer line = new StringBuffer();

        for(Vertex vertex:path){
            line.append(vertex.getName()).append(SINGLE_WHITE_SPACE);
        }
        line.append(": ").append(path.get(path.size()-1).getTime());
        return line.toString();
    }

}
