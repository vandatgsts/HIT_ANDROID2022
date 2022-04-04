package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.Serializable;

public class monan implements Serializable {
    private Integer monanId;
    private String monanname;
    private String avt;
    private String nguyenlieu;
    private String congthuc;
    private String tien;

    public monan(Integer monanId, String monanname, String avt, String nguyenlieu, String congthuc, String tien) {
        this.monanId = monanId;
        this.monanname = monanname;
        this.avt = avt;
        this.nguyenlieu = nguyenlieu;
        this.congthuc = congthuc;
        this.tien = tien;
    }

    public monan() {

    }

    public Integer getMonanId() {
        return monanId;
    }

    public void setMonanId(Integer monanId) {
        this.monanId = monanId;
    }

    public String getMonanname() {
        return monanname;
    }

    public void setMonanname(String monanname) {
        this.monanname = monanname;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getNguyenlieu() {
        return nguyenlieu;
    }

    public void setNguyenlieu(String nguyenlieu) {
        this.nguyenlieu = nguyenlieu;
    }

    public String getCongthuc() {
        return congthuc;
    }

    public void setCongthuc(String congthuc) {
        this.congthuc = congthuc;
    }

    public String getTien() {
        return tien;
    }

    public void setTien(String tien) {
        this.tien = tien;
    }
}