package com.patterns.behavioral.Mediator;

import java.util.ArrayList;
import java.util.List;

public class TrafficController implements TrafficMediator {
    private List<Participant> participants = new ArrayList<>();
    private boolean isRoadFree = true;

    @Override
    public void registerParticipant(Participant participant) {
        participants.add(participant);
    }

    @Override
    public void requestPass(Participant participant) {
        if (isRoadFree) {
            isRoadFree = false; // Дорога зайнята цим учасником
            System.out.println("Регулювальник: Дозволяю рух для " + participant.getName());
            participant.move();
            isRoadFree = true;  // Після завершення руху дорога знову вільна
        } else {
            System.out.println("Регулювальник: " + participant.getName() + ", зачекайте! Дорога зайнята.");
        }
    }
}
