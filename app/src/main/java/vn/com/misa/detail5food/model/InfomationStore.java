package vn.com.misa.detail5food.model;

import android.graphics.Bitmap;

public class InfomationStore {
    private String nameStore;
    private float totalRate;
    private int totalFeedback;
    private String category;
    private String setOpen;
    private String timeOpen;
    private String address;
    private String distance;


    public InfomationStore() {
    }

    public InfomationStore(String nameStore, float totalRate, int totalFeedback, String category, String setOpen, String timeOpen, String address, String distance) {
        this.nameStore = nameStore;
        this.totalRate = totalRate;
        this.totalFeedback = totalFeedback;
        this.category = category;
        this.setOpen = setOpen;
        this.timeOpen = timeOpen;
        this.address = address;
        this.distance = distance;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public float getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(float totalRate) {
        this.totalRate = totalRate;
    }

    public int getTotalFeedback() {
        return totalFeedback;
    }

    public void setTotalFeedback(int totalFeedback) {
        this.totalFeedback = totalFeedback;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSetOpen() {
        return setOpen;
    }

    public void setSetOpen(String setOpen) {
        this.setOpen = setOpen;
    }

    public String getTimeOpen() {
        return timeOpen;
    }

    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
