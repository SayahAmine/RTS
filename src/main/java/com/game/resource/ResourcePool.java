package com.game.resource;

import java.util.EnumMap;
import java.util.Map;

public class ResourcePool {

    private Map<ResourceType, Integer> resources;

    public ResourcePool() {
        resources = new EnumMap<>(ResourceType.class);
        for (ResourceType type : ResourceType.values()) {
            resources.put(type, 0);
        }
    }

    // Add resources
    public void add(ResourceType type, int amount) {
        resources.put(type, resources.get(type) + amount);
    }

    // Spend resources
    public boolean spend(ResourceType type, int amount) {
        if (resources.get(type) < amount) {
            return false;
        }
        resources.put(type, resources.get(type) - amount);
        return true;
    }

    // Check availability
    public boolean has(ResourceType type, int amount) {
        return resources.get(type) >= amount;
    }

    // Get current amount
    public int get(ResourceType type) {
        return resources.get(type);
    }

    // Spend multiple resources at once
    public boolean spendCost(Map<ResourceType, Integer> cost) {
        for (var entry : cost.entrySet()) {
            if (!has(entry.getKey(), entry.getValue())) {
                return false;
            }
        }
        for (var entry : cost.entrySet()) {
            spend(entry.getKey(), entry.getValue());
        }
        return true;
    }
}