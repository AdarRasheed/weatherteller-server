package com.assignmento.weathertellerserver.models;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "openweather_id")
    private String openweatherId;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    public City() {
    }

    public City(String openweatherId, String name, String country) {
        this.openweatherId = openweatherId;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getOpenweatherId() {
        return openweatherId;
    }

    public void setOpenweatherId(String openweatherId) {
        this.openweatherId = openweatherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "openweatherId='" + openweatherId + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
