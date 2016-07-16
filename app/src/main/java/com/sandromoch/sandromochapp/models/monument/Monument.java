package com.sandromoch.sandromochapp.models.monument;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Monument {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created_date")
    @Expose
    private String createdDate;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lon")
    @Expose
    private Double lon;
    @SerializedName("monument_type")
    @Expose
    private Integer monumentType;
    @SerializedName("images")
    @Expose
    private List<com.sandromoch.sandromochapp.models.monument.Image> images = new ArrayList<>();

    /**
     *
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     *     The createdDate
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     *
     * @param createdDate
     *     The created_date
     */
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     *
     * @return
     *     The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     *     The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     *     The lon
     */
    public Double getLon() {
        return lon;
    }

    /**
     *
     * @param lon
     *     The lon
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     *
     * @return
     *     The monumentType
     */
    public Integer getMonumentType() {
        return monumentType;
    }

    /**
     *
     * @param monumentType
     *     The monument_type
     */
    public void setMonumentType(Integer monumentType) {
        this.monumentType = monumentType;
    }

    /**
     *
     * @return
     *     The images
     */
    public List<com.sandromoch.sandromochapp.models.monument.Image> getImages() {
        return images;
    }

    /**
     *
     * @param images
     *     The images
     */
    public void setImages(List<com.sandromoch.sandromochapp.models.monument.Image> images) {
        this.images = images;
    }

}

