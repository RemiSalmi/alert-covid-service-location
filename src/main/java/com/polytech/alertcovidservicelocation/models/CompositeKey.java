package com.polytech.alertcovidservicelocation.models;

import java.io.Serializable;
import java.sql.Date;

public class CompositeKey implements Serializable {
    private long idUser;
    private Date date;
    private double longitude;
    private double latitude;
}