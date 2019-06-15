package com.app.thestream.blacklist.util;

import java.util.ArrayList;
import java.util.List;

public class BlackListUtils {
    private static BlackListUtils appContents;

    public static BlackListUtils getInstance() {
        if (appContents == null)
            appContents = new BlackListUtils();
        return appContents;
    }

    private BlackListUtils() {
    }

    private List<String> blackList = new ArrayList<>();

    public void populateBlackList() {


        //add more here
    }

    public List<String> getBlackList() {
        if (blackList.isEmpty()) {
            populateBlackList();
        }
        return blackList;
    }

    //to add more dynamically
    public void appendMoreIntoBlackListDynamically(List<String> packagesList) {
        blackList.addAll(packagesList);
    }

    public void clearList() {
        blackList.clear();
    }

}
