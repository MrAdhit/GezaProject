package com.mradhit.questskills.utils;

public class Identifier {
    public String identifier;
    public Identifier(String id, String path) {
        this.identifier = id + ":" + path;
    }
}
