package ru.rlt;

import com.samczsun.skype4j.Skype;
import com.samczsun.skype4j.SkypeBuilder;
import com.samczsun.skype4j.chat.GroupChat;
import com.samczsun.skype4j.events.EventHandler;
import com.samczsun.skype4j.events.Listener;
import com.samczsun.skype4j.events.chat.message.MessageReceivedEvent;

public class App {
    public static void main(String[] args) {
        String user = "git.rlt.ru";
        String password = "";

        SkypeBuilder skypeBuilder = new SkypeBuilder(user, password).withAllResources();
        Skype skype = skypeBuilder.build();
        try {
            skype.login();
            skype.getEventDispatcher().registerListener(new Listener() {
                @EventHandler
                public void onMessage(MessageReceivedEvent e) {
                    System.out.println("Got message: " + e.getMessage().getContent());
                }
            });
            skype.subscribe();

            GroupChat chat = skype.joinChat("19:d1edd3748dca4942b2d399b11a142928@thread.skype");
            chat.sendMessage("сорри, это тест.");

            //грабь корованы

            skype.logout();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
