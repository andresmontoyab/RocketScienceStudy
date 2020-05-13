package com.study;

public class SubscriberImpl implements Subscriber{


    public boolean receive(String message){
        if(message.equals("")){
            return false;
        }
        return true;
    }
}
