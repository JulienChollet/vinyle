package com.app.vinyle;

import java.util.List;
import java.util.Objects;

public class Vinyle {

    private String id;
    private String band;
    private String name;
    private List<String> titles;
    private String type;
    private String description;

    public Vinyle(String id, String band, String name, List<String> titles, String type, String description) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vinyle vinyle = (Vinyle) o;
        return Objects.equals(getId(), vinyle.getId()) && Objects.equals(getBand(), vinyle.getBand()) && Objects.equals(getName(), vinyle.getName()) && Objects.equals(getTitles(), vinyle.getTitles()) && Objects.equals(getType(), vinyle.getType()) && Objects.equals(getDescription(), vinyle.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBand(), getName(), getTitles(), getType(), getDescription());
    }
}
