package com.wzxy.aroundtaxi.pojo;

public class PaAddress {

    private String pa_phonenum;
    private double longitude;
    private double latitude;
    private String status;


    /**
     * @return the pa_phonenum
     */
    public String getPa_phonenum() {
        return pa_phonenum;
    }

    /**
     * @param pa_phonenum the pa_phonenum to set
     */
    public void setPa_phonenum(String pa_phonenum) {
        this.pa_phonenum = pa_phonenum;
    }

    /**
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }


}
