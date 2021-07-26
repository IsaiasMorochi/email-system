package com.imorochi.emailsystem.directory.domain.leaf;

import com.imorochi.emailsystem.directory.domain.component.MessageComponent;
import com.imorochi.emailsystem.message.Observer;
import com.imorochi.emailsystem.message.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Message extends MessageComponent implements Observer {

    private String from;
    private String sent;
    private String subject;
    private List<String> cc;

    private String text;
    private String signing;

    private List<String> attachments;

    private final Subject subjectObserver;

    public Message(String from, String sent, String subject, List<String> cc, String text, String signing, List<String> attachments, Subject subjectObserver) {
        super(from);
        if (subject == null) {
            throw new IllegalArgumentException("No publisher found.");
        }
        this.from = from;
        this.sent = sent;
        this.subject = subject;
        this.cc = cc;
        this.text = text;
        this.signing = signing;
        this.attachments = attachments;
        this.subjectObserver = subjectObserver;
    }
    @Override
    public void display(int indent) {
        System.out.println(this.getIndentation(indent) + this.from );
    }

    @Override
    public void update(Message message) {
        display(0);
    }

    @Override
    public void subscribe() {
        System.out.println("Subscribing "+this.from+" to "+subjectObserver.subjectDetails()+ " ...");
        this.subjectObserver.subscribeObserver(this);
        System.out.println("Subscribed successfully.");
    }

    @Override
    public void unSubscribe() {
        System.out.println("Unsubscribing "+this.from+" to "+subjectObserver.subjectDetails() +" ...");
        this.subjectObserver.unSubscribeObserver(this);
        System.out.println("Unsubscribed successfully.");
    }

}
