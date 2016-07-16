package com.sandromoch.sandromochapp.models.monument;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class File {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("memorial")
    @Expose
    private Integer memorial;

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The memorial
     */
    public Integer getMemorial() {
        return memorial;
    }

    /**
     *
     * @param memorial
     * The memorial
     */
    public void setMemorial(Integer memorial) {
        this.memorial = memorial;
    }

}
