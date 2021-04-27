package com.weather.api.entities.location;

import javax.persistence.*;

@Entity
@Table(name = "Locations")
public class LocationDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String location;
    private String name;
    private String country;
    private float latitude;
    private float longitude;

    public LocationDAO() {
    }

    public LocationDAO(String location, String name, String country, float latitude, float longitude) {
        this.location = location;
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getNameCountry() {
        return name + ", " + country;
    }
}
