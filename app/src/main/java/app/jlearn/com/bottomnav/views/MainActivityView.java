package app.jlearn.com.bottomnav.views;

import java.util.List;

import app.jlearn.com.bottomnav.models.Data;

/**
 * Created by gh on 11/5/2017.
 */

public interface MainActivityView {

    void displayData(List<Data> dataList);
    void displayNoData();
}
