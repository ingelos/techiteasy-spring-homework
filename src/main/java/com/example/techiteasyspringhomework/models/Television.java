package com.example.techiteasyspringhomework.models;

import com.example.techiteasyspringhomework.enums.AvailableSize;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "televisions")
public class Television extends Product {

    private String type;
    private AvailableSize availableSize;
    private int refreshRate;
    private String screenType;
    private String screenQuality;
    private boolean smartTv;
    private boolean wifi;
    private boolean voiceControl;
    private boolean hdr;
    private boolean blueTooth;
    private boolean ambiLight;

    public Television(Long id, String name, String brand, Double price, int originalStock, int sold, String type, AvailableSize availableSize, int refreshRate, String screenType, String screenQuality, boolean smartTv, boolean wifi, boolean voiceControl, boolean hdr, boolean blueTooth, boolean ambiLight) {
        super(id, name, brand, price, originalStock, sold);
        this.type = type;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.blueTooth = blueTooth;
        this.ambiLight = ambiLight;
    }

    public Television() {
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AvailableSize getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(AvailableSize availableSize) {
        this.availableSize = availableSize;
    }

    public int getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(int refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }
    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBlueTooth() {
        return blueTooth;
    }

    public void setBlueTooth(boolean blueTooth) {
        this.blueTooth = blueTooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }
}
