package com.example.lab_3.restfulManagement;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Devices {
    @SerializedName("record")
    @Expose
    private Record record;

    public Record getRecord() {
        return record;
    }
    public void setRecord(Record record) {
        this.record = record;
    }
}
