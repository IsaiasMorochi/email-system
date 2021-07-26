package com.imorochi.emailsystem;


import com.imorochi.emailsystem.directory.domain.composite.Directory;
import com.imorochi.emailsystem.directory.domain.leaf.Message;
import com.imorochi.emailsystem.message.DraftObject;
import com.imorochi.emailsystem.message.InboxObject;
import com.imorochi.emailsystem.message.SentObject;
import com.imorochi.emailsystem.message.TrashObject;

import java.util.ArrayList;
import java.util.List;

public class EmailSystemApplication {

	public static void main(String[] args) {

		System.out.println("*************************");

		Directory root = new Directory("Principal");
		Directory inbox = new Directory("Inbox");
		Directory sent = new Directory("Sent");
		Directory draft = new Directory("Draft");
		Directory trash = new Directory("Trash");
		List<String> cc = new ArrayList<String>();
		List<String> attachments = new ArrayList<String>(); //TODO implementar clase para soporte UTF8

		root.addMessageComponent(inbox);
		root.addMessageComponent(sent);
		root.addMessageComponent(draft);
		root.addMessageComponent(trash);

		root.display(0);

		System.out.println("*************************");
		System.out.println("INBOX");
		System.out.println("*************************");

		InboxObject inboxObject = new InboxObject(new ArrayList<>(), "Inbox");
		Message message_1 = new Message("mario@gmail.com","imorochi@gmail.com","Respuesta tesis",new ArrayList<String>(),"hola", "holaaa", new ArrayList<String>(), inboxObject);
		message_1.subscribe();
		inboxObject.sendEmail(message_1);
		inbox.addMessageComponent(message_1);

		root.display(0);

		System.out.println("*************************");
		System.out.println("SENT");
		System.out.println("*************************");

		SentObject sentObject = new SentObject(new ArrayList<>(), "Sent");
		Message message_2= new Message("imorochi@gmail.com","mario@gmail.com","Respuesta tesis",new ArrayList<String>(),"hola", "holaaa", new ArrayList<String>(), inboxObject);
		Message message_3= new Message("imorochi@gmail.com","teresa@gmail.com","Respuesta tesis",new ArrayList<String>(),"hola", "holaaa", new ArrayList<String>(), inboxObject);
		message_2.subscribe();
		message_3.subscribe();
		sentObject.sendEmail(message_2);
		sentObject.sendEmail(message_3);
		sent.addMessageComponent(message_2);
		sent.addMessageComponent(message_3);

		root.display(0);

		System.out.println("*************************");
		System.out.println("DRAFT");
		System.out.println("*************************");

		DraftObject draftObject = new DraftObject(new ArrayList<>(), "Draft");
		Message message_100 = new Message("mario@gmail.com","imorochi@gmail.com","Respuesta tesis",new ArrayList<String>(),"hola", "holaaa", new ArrayList<String>(), inboxObject);
		message_100.subscribe();
		// no se envia el email
        // draftObject.sendEmail(message_100);
		draft.addMessageComponent(message_100);

		root.display(0);

		System.out.println("*************************");
		System.out.println("TRASH");
		System.out.println("*************************");

		TrashObject trashObject = new TrashObject(new ArrayList<>(), "Trash");
		message_2.unSubscribe();
		trashObject.sendEmail(message_2);
		trash.addMessageComponent(message_2);
		root.display(0);

	}

}
