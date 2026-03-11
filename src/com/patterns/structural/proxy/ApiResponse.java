package com.patterns.structural.proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ApiResponse {
    public final int    statusCode;
    public final String body;
    public final String source;       // "LIVE" або "CACHE"
    public final long   latencyMs;
    public final LocalDateTime timestamp;

    public ApiResponse(int statusCode, String body, String source, long latencyMs) {
        this.statusCode = statusCode;
        this.body       = body;
        this.source     = source;
        this.latencyMs  = latencyMs;
        this.timestamp  = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
        return String.format("HTTP %d | %-5s | %4d мс | %s | %s",
                statusCode, source, latencyMs,
                timestamp.format(fmt), body);
    }
}
