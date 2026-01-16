package org.learning.designPatterns.asbtractComponents;

import java.util.HashMap;

public interface SearchFlightAvailability {
    void checkAvailability(HashMap<String,String> sourceDestination) ;
}
