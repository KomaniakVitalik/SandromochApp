package com.sandromoch.sandromochapp.models.monument;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("monument")
    @Expose
    private Integer monument;

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
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     *     The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     *
     * @param desc
     *     The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     *
     * @return
     *     The monument
     */
    public Integer getMonument() {
        return monument;
    }

    /**
     *
     * @param monument
     *     The monument
     */
    public void setMonument(Integer monument) {
        this.monument = monument;
    }

}

