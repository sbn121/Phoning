package com.example.lastcloneappproject.messages;

public class MessageChatMeDTO {
    private String chat, time;

    public MessageChatMeDTO(String chat, String time) {
        this.chat = chat;
        this.time = time;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
