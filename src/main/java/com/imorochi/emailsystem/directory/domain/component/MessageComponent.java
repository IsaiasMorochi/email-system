package com.imorochi.emailsystem.directory.domain.component;

import java.util.Objects;

public abstract class MessageComponent {

    protected String name;

    protected MessageComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected String getIndentation(int indent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            sb.append("    ");
        }
        return sb.toString();
    }

    public abstract void display(int indent);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageComponent that = (MessageComponent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
