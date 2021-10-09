package com.assignmento.weathertellerserver.models;

import java.util.Date;

public class Weather {

    private String city;
    private Double temperature;
    private String weatherInfo;
    private String timestamp;

    public Weather(String city, Double temperature, String weatherInfo, String timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.weatherInfo = weatherInfo;
        this.timestamp = timestamp;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                ", weather-info='" + weatherInfo + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
