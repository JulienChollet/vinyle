package com.app.vinyle.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("vinyle")
public class VinyleEntity {
    @Id
    private String id;

    private String band;

    private String name;

    private List<String>titles;

    private String type;

    private String description;


    public VinyleEntity() {
    }

    public VinyleEntity(String id, String band, String name, List<String> titles, String type, String description) {
        this.id = id;
        this.band = band;
        this.name = name;
        this.titles = titles;
        this.type = type;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
