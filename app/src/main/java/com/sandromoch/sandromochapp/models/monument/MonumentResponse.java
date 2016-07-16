package com.sandromoch.sandromochapp.models.monument;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MonumentResponse {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("next")
    @Expose
    private Object next;
    @SerializedName("previous")
    @Expose
    private Object previous;
    @SerializedName("results")
    @Expose
    private List<Monument> results = new ArrayList<Monument>();

    /**
     * @return The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return The next
     */
    public Object getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(Object next) {
        this.next = next;
    }

    /**
     * @return The previous
     */
    public Object getPrevious() {
        return previous;
    }

    /**
     * @param previous The previous
     */
    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    /**
     * @return The results
     */
    public List<Monument> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Monument> results) {
        this.results = results;
    }

}
