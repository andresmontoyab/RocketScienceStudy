package com.study;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers;

    public Publisher(){
        this.subscribers = new ArrayList<Subscriber>();
    }

    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void sendMessage(String message){
        for (Subscriber subscriber: subscribers) {
            subscriber.receive(message);
        }
    }


}
