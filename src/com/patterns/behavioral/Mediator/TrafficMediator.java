package com.patterns.behavioral.Mediator;

public interface TrafficMediator {
    void requestPass(Participant participant);
    void registerParticipant(Participant participant);
}
