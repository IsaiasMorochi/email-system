package com.imorochi.emailsystem.message;

import com.imorochi.emailsystem.directory.domain.leaf.Message;

import java.util.List;

public class DraftObject implements Subject {

    private final List<Observer> observers;
    private Message message;
    private final String subjectDetails;

    public DraftObject(List<Observer>observers, String subjectDetails){
        this.observers = observers;
        this.subjectDetails = subjectDetails;
    }

    @Override
    public void subscribeObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unSubscribeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        observers.remove(index);
    }

    @Override
    public void notifyObservers() {
//        System.out.println();
        for(Observer observer : observers){
            observer.update(message);
        }
    }

    @Override
    public String subjectDetails() {
        return subjectDetails;
    }

    public void sendEmail(Message message) {
        this.message = message;
        notifyObservers();
    }
}
