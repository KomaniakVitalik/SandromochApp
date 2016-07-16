package com.sandromoch.sandromochapp.util;

import com.sandromoch.sandromochapp.models.monument.Monument;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaliy.komaniak on 7/15/16.
 */
public class Sort {

    public static List<Monument> sortByType(List<Monument> results, int type, String mask) {
        List<Monument> temp = new ArrayList<>();
        for (Monument monument : results) {
            if (monument.getMonumentType() == type && monument.getName().contains(mask)) {
                temp.add(monument);
            }
        }
        return temp;
    }
}
