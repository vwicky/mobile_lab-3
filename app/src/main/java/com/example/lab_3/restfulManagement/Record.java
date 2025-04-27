package com.example.lab_3.restfulManagement;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Record {
    @SerializedName("devices")
    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}