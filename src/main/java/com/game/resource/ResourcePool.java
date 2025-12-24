package com.game.resource;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;

public class ResourcePool implements Serializable {

    private final Map<ResourceType, Integer> resources =
            new EnumMap<>(ResourceType.class);

    public ResourcePool() {
        // ✅ STARTING RESOURCES
        resources.put(ResourceType.GOLD, 200);
        resources.put(ResourceType.WOOD, 150);
        resources.put(ResourceType.STONE, 100);
        resources.put(ResourceType.FOOD, 100);
    }

    public int get(ResourceType type) {
        return resources.getOrDefault(type, 0);
    }

    public boolean spendCost(Map<ResourceType, Integer> cost) {
        for (var entry : cost.entrySet()) {
            if (get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        for (var entry : cost.entrySet()) {
            resources.put(entry.getKey(),
                    get(entry.getKey()) - entry.getValue());
        }
        return true;
    }

    public void add(ResourceType type, int amount) {
        resources.put(type, get(type) + amount);
    }
}
