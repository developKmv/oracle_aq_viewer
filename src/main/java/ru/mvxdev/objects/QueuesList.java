package ru.mvxdev.objects;

import java.util.LinkedList;

public class QueuesList {

    private String names;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getOwners() {
        return owners;
    }

    public void setOwners(String owners) {
        this.owners = owners;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getQueuesTables() {
        return queuesTables;
    }

    public void setQueuesTables(String queuesTables) {
        this.queuesTables = queuesTables;
    }

    private String owners;
    private String types;
    private String queuesTables;

    public QueuesList(){};

    public QueuesList(String names, String owners, String types, String queuesTables) {
        this.names = names;
        this.owners = owners;
        this.types = types;
        this.queuesTables = queuesTables;
    }

    @Override
    public String toString() {
        return "QueuesList{" +
                "names=" + names +
                ", owners=" + owners +
                ", types=" + types +
                ", queuesTables=" + queuesTables +
                '}';
    }
}
