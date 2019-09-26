package jp.ace.pro.yamanotestationroulette.api.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationDTO {

    @SerializedName("@context")
    @Expose
    private String context;

    @SerializedName("@id")
    @Expose
    private String id;

    @SerializedName("@type")
    @Expose
    private String type;

    @SerializedName("dc:date")
    @Expose
    private String dcDate;

    @SerializedName("owl:sameAs")
    @Expose
    private String owlSameAs;

    @SerializedName("dc:title")
    @Expose
    private String dcTitle;

    @SerializedName("odpt:stationTitle")
    @Expose
    private OdptStationTitle odptStationTitle;

    @SerializedName("odpt:operator")
    @Expose
    private String odptOperator;

    @SerializedName("odpt:railway")
    @Expose
    private String odptRailway;

    @SerializedName("geo:long")
    @Expose
    private Double geoLong;

    @SerializedName("geo:lat")
    @Expose
    private Double geoLat;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDcDate() {
        return dcDate;
    }

    public void setDcDate(String dcDate) {
        this.dcDate = dcDate;
    }

    public String getOwlSameAs() {
        return owlSameAs;
    }

    public void setOwlSameAs(String owlSameAs) {
        this.owlSameAs = owlSameAs;
    }

    public String getDcTitle() {
        return dcTitle;
    }

    public void setDcTitle(String dcTitle) {
        this.dcTitle = dcTitle;
    }

    public OdptStationTitle getOdptStationTitle() {
        return odptStationTitle;
    }

    public void setOdptStationTitle(OdptStationTitle odptStationTitle) {
        this.odptStationTitle = odptStationTitle;
    }

    public String getOdptOperator() {
        return odptOperator;
    }

    public void setOdptOperator(String odptOperator) {
        this.odptOperator = odptOperator;
    }

    public String getOdptRailway() {
        return odptRailway;
    }

    public void setOdptRailway(String odptRailway) {
        this.odptRailway = odptRailway;
    }

    public Double getGeoLong() {
        return geoLong;
    }

    public void setGeoLong(Double geoLong) {
        this.geoLong = geoLong;
    }

    public Double getGeoLat() {
        return geoLat;
    }

    public void setGeoLat(Double geoLat) {
        this.geoLat = geoLat;
    }

}
