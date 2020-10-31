package com.polytech.alertcovidservicelocation.models;

import javax.persistence.*;
import java.sql.Date;

@Entity(name="contact_location_history")
@Access(AccessType.FIELD)
@IdClass(CompositeKey.class)
public class Location {

    @Id
    private long id_user;

    @Id
    private Date date;

    @Id
    private double longitude;

    @Id
    private double latitude;

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
