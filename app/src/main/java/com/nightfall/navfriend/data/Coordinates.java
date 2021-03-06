package com.nightfall.navfriend.data;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Dev on 28/04/2015.
 */
public class Coordinates implements Serializable {

    private float longitude;
    private float latitude;

    public Coordinates(float longitude,float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }

}
