package app.jlearn.com.bottomnav.presenters;

import app.jlearn.com.bottomnav.repositories.DataRepository;
import app.jlearn.com.bottomnav.views.MainActivityView;

/**
 * Created by gh on 11/5/2017.
 */

public class MainActivityPresenter {

    private MainActivityView mainActivityView;
    private DataRepository dataRepository;

    public MainActivityPresenter(MainActivityView mainActivityView, DataRepository dataRepository) {
        this.mainActivityView = mainActivityView;
        this.dataRepository = dataRepository;
    }

    public void getData() {
        if (dataRepository.getData().isEmpty()) {
            mainActivityView.displayNoData();
        } else {
            mainActivityView.displayData(dataRepository.getData());
        }


    }
}
