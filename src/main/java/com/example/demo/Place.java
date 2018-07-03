package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=1)
    private String wheretogo;

    @NotNull
    @Size(min=1)
    private String whowith;

    @NotNull
    @Size(min=1)
    private String description;

    @NotNull
    @Min(1)
    private int days;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWheretogo() {
        return wheretogo;
    }

    public void setWheretogo(String wheretogo) {
        this.wheretogo = wheretogo;
    }

    public String getWhowith() {
        return whowith;
    }

    public void setWhowith(String whowith) {
        this.whowith = whowith;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
