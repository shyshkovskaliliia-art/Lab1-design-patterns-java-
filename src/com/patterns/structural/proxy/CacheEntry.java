package com.patterns.structural.proxy;

public class CacheEntry {
    private final ApiResponse response;
    private final long        createdAt;
    private final long        ttlMs;

    public CacheEntry(ApiResponse response, long ttlMs) {
        this.response  = response;
        this.createdAt = System.currentTimeMillis();
        this.ttlMs     = ttlMs;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() - createdAt > ttlMs;
    }

    public long remainingTtlSec() {
        long remaining = ttlMs - (System.currentTimeMillis() - createdAt);
        return Math.max(0, remaining / 1000);
    }

    public ApiResponse getResponse() { return response; }
}
