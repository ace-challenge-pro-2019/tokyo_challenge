package jp.ace.pro.yamanotestationroulette.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OdptStationTitle {

    @SerializedName("ja")
    @Expose
    private String ja;

    @SerializedName("en")
    @Expose
    private String en;

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

}