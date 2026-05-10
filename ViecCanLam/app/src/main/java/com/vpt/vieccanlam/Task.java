package com.vpt.vieccanlam;

import java.io.Serializable;
import java.util.HashMap;

public class Task implements Serializable {
    private String date;
    private String message;
    private String name;
    private String priority;

    public Task(String date, String message, String name, String priority) {
        this.date = date;
        this.message = message;
        this.name = name;
        this.priority = priority;
    }

    public Task() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public HashMap<String, String> toFireBaseTask(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("date", this.date);
        hashMap.put("message", this.message);
        hashMap.put("name", this.name);
        hashMap.put("priority", this.priority);
        return hashMap;
    }
}
