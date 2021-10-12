package com.assignmento.weathertellerserver.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * A WeatherStamp.
 */
@Entity
@Table(name = "weather_stamps")
public class WeatherStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /** Represents openweather.org platform assigned id for a city
     */
    @Column(name = "city_openweather_id")
    private Long cityOpenweatherId;

    /** Represents temperature in celcius
     */
    @Column(name = "temperature")
    private Double temperature;

    /** Represents weather condition
     */
    @Column(name = "weather_info")
    private String weatherInfo;

    /** Represents the date and time at which weather-stamp was recorded by openweather.org platform as "H:mm  dd MMM yy"
     */
    @Column(name = "recorded_on")
    private String recordedOn;

    /** Represents the date and time at which server picked the weather-stamp record from openweather.org
     */
    @CreationTimestamp
    @Column(name = "reported_on")
    private LocalDateTime reportedOn;

    public WeatherStamp() {
    }

    public WeatherStamp(Long cityOpenweatherId, Double temperature, String weatherInfo, String recordedOn) {
        this.cityOpenweatherId = cityOpenweatherId;
        this.temperature = temperature;
        this.weatherInfo = weatherInfo;
        this.recordedOn = recordedOn;
    }

    public long getId() {
        return id;
    }

    public Long getCityOpenweatherId() {
        return cityOpenweatherId;
    }

    public void setCityOpenweatherId(Long cityOpenweatherId) {
        this.cityOpenweatherId = cityOpenweatherId;
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

    public LocalDateTime getReportedOn() {
        return reportedOn;
    }

    public void setReportedOn(LocalDateTime reportedOn) {
        this.reportedOn = reportedOn;
    }

    @Override
    public String toString() {
        return "WeatherStamp{" +
                "cityOpenweatherId='" + cityOpenweatherId + '\'' +
                ", temperature=" + temperature +
                ", weatherInfo='" + weatherInfo + '\'' +
                ", recordedOn='" + recordedOn + '\'' +
                ", reportedOn=" + reportedOn +
                '}';
    }
}
