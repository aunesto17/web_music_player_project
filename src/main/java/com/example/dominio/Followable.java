package com.example.dominio;

public interface Followable {
    Feed getFeed();
    void setFeed(Feed feed);
    String getType();
    String getName();
    String getLink();
}
