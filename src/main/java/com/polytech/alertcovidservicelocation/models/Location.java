package com.polytech.alertcovidservicelocation.models;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name="contact_location_history")
@Access(AccessType.FIELD)
@IdClass(CompositeKey.class)
public class Location {

    @Id
    private long idUser;

    @Id
    private LocalDateTime date;

    @Id
    private double longitude;

    @Id
    private double latitude;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
