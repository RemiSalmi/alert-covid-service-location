package com.polytech.alertcovidservicelocation.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CompositeKey implements Serializable {
    private long idUser;
    private LocalDateTime date;
    private double longitude;
    private double latitude;
}