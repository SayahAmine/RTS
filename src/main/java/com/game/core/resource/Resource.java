package com.game.core.resource;

import java.util.EnumMap;
import java.util.Map;

public class Resource {

    private final Map<ResourceType, Integer> resources = new EnumMap<>( ResourceType.class );

    public Resource() {
        for (ResourceType type : ResourceType.values()) {
            resources.put(type, 0);
        }
    }

    public void addResource( ResourceType type, int amount ){
        resources.put( type, resources.get( type ) + amount );
    }

    public boolean Isenought( ResourceType type, int amount ){
        return resources.get( type ) >= amount;
    }

    public void consume( ResourceType type, int amount ){
        if( Isenought( type, amount ) ){
            throw new IllegalStateException("Not enough resources");
        }else {
            resources.put( type, resources.get( type ) - amount );
        }
    }

    public Map<ResourceType, Integer> snapshot() {
        return Map.copyOf(resources);
    }





}
