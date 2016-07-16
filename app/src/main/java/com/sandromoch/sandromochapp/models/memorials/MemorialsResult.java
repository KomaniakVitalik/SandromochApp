package com.sandromoch.sandromochapp.models.memorials;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sandromoch.sandromochapp.models.monument.File;
import com.sandromoch.sandromochapp.models.monument.Image;

public class MemorialsResult {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("text_body")
    @Expose
    private String textBody;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("files")
    @Expose
    private List<File> files = new ArrayList<File>();

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
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The textBody
     */
    public String getTextBody() {
        return textBody;
    }

    /**
     *
     * @param textBody
     * The text_body
     */
    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    /**
     *
     * @return
     * The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     *
     * @return
     * The files
     */
    public List<File> getFiles() {
        return files;
    }

    /**
     *
     * @param files
     * The files
     */
    public void setFiles(List<File> files) {
        this.files = files;
    }

}