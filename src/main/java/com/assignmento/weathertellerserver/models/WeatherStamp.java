package com.assignmento.weathertellerserver.models;

import javax.persistence.*;

@Entity
@Table(name = "weather_stamps")
public class WeatherStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "weather_info")
    private String weatherInfo;

    @Column(name = "recorded_on")
    private String recordedOn;

    public WeatherStamp(String city, Double temperature, String weatherInfo, String recordedOn) {
        this.city = city;
        this.temperature = temperature;
        this.weatherInfo = weatherInfo;
        this.recordedOn = recordedOn;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getWeatherInfo() {
        return weatherInfo;
    }

    public void setWeatherInfo(String weatherInfo) {
        this.weatherInfo = weatherInfo;
    }

    public String getRecordedOn() {
        return recordedOn;
    }

    public void setRecordedOn(String recordedOn) {
        this.recordedOn = recordedOn;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", weather-info='" + weatherInfo + '\'' +
                ", recorded-on=" + recordedOn +
                '}';
    }
}