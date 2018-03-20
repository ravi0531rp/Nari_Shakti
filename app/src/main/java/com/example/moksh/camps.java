package com.example.moksh;

/**
 * Created by moksh on 20/3/18.
 */

public class camps {
    public  String id;
    public String organizerName;
    public String eventName;
    public String mobNo;
    public String description;
    public camps(){

    }

    public camps(String id,String organizerName, String eventName, String mobNo, String description) {
        this.organizerName = organizerName;
        this.id=id;
        this.eventName = eventName;
        this.mobNo = mobNo;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public String getEventName() {
        return eventName;
    }

    public String getMobNo() {
        return mobNo;
    }

    public String getDescription() {
        return description;
    }
}
