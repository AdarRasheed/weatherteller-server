package com.assignmento.weathertellerserver.models;

import javax.persistence.*;

/**
 * A City.
 */
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** Represents openweather.org platform assigned id for a city
     */
    @Column(name = "openweather_id")
    private Long openweatherId;

    /** Represents name of the city
     */
    @Column(name = "name")
    private String name;

    /** Represents country code of the country the city belongs to
     */
    @Column(name = "country")
    private String country;

    public City() {
    }

    public City(Long openweatherId, String name, String country) {
        this.openweatherId = openweatherId;
        this.name = name;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public Long getOpenweatherId() {
        return openweatherId;
    }

    public void setOpenweatherId(Long openweatherId) {
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
