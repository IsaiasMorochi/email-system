package com.imorochi.emailsystem.directory.domain.composite;

import com.imorochi.emailsystem.directory.domain.component.MessageComponent;

import java.util.ArrayList;
import java.util.List;

public class Directory extends MessageComponent {

    private final List<MessageComponent> subMessageComponents;

    public Directory(String name) {
        super(name);
        this.subMessageComponents = new ArrayList<MessageComponent>();
    }

    public void addMessageComponent(MessageComponent fileComponent) {
        this.subMessageComponents.add(fileComponent);
    }

    @Override
    public void display(int indent) {
        System.out.println("->" + this.getIndentation(indent) + this.name);
        for (MessageComponent fc : this.subMessageComponents) {
            fc.display(indent + 1);
        }
    }

}
