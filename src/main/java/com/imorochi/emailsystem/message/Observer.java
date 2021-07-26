package com.imorochi.emailsystem.message;

import com.imorochi.emailsystem.directory.domain.leaf.Message;

public interface Observer {
    void update(Message message);
    void subscribe();
    void unSubscribe();
}
