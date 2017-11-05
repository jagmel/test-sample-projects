package app.jlearn.com.bottomnav;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import app.jlearn.com.bottomnav.models.Data;
import app.jlearn.com.bottomnav.presenters.MainActivityPresenter;
import app.jlearn.com.bottomnav.repositories.DataRepository;
import app.jlearn.com.bottomnav.views.MainActivityView;

public class MainActivity extends AppCompatActivity implements MainActivityView {
    private MainActivityPresenter mainActivityPresenter;
    private DataRepository dataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityPresenter = new MainActivityPresenter(this, this.dataRepository);

    }

    @Override
    public void displayData(List<Data> dataList) {

    }

    @Override
    public void displayNoData() {

    }
}
