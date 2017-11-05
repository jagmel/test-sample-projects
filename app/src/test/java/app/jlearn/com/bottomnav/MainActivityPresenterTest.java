package app.jlearn.com.bottomnav;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import app.jlearn.com.bottomnav.models.Data;
import app.jlearn.com.bottomnav.presenters.MainActivityPresenter;
import app.jlearn.com.bottomnav.repositories.DataRepository;
import app.jlearn.com.bottomnav.views.MainActivityView;

/**
 * Created by gh on 11/5/2017.
 */
public class MainActivityPresenterTest {

   

    @Test
    public void shouldPassMainActView() {
        MainActivityView mockMainActivityView = new MockView();
        DataRepository mockDataRepository = new MockDataRepository(true);
        //given
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(mockMainActivityView, mockDataRepository);
        //when
        mainActivityPresenter.getData();

        //then
        Assert.assertEquals(true, ((MockView) mockMainActivityView).passedSomeData);


    }

    @Test
    public void shouldHandleNoData() {
        //given
        MainActivityView mockView = new MockView();
        DataRepository mockDataRepository = new MockDataRepository(false);

        //when
        MainActivityPresenter mainActivityPresenter = new MainActivityPresenter(mockView, mockDataRepository);
        mainActivityPresenter.getData();
        //then
        Assert.assertEquals(true, ((MockView) mockView).passedNoData);

    }

    private class MockView implements MainActivityView {

        boolean passedSomeData;
        boolean passedNoData;

        @Override
        public void displayData(List<Data> dataList) {
            if (dataList.size() == 3)
                passedSomeData = true;
        }

        @Override
        public void displayNoData() {
            passedNoData = true;
        }
    }

    private class MockDataRepository implements DataRepository {
        private boolean shouldReturnSomeData;

        public MockDataRepository(boolean shouldReturnSomeData) {
            this.shouldReturnSomeData = shouldReturnSomeData;
        }

        @Override
        public List<Data> getData() {
            if (shouldReturnSomeData)
                return Arrays.asList(new Data(), new Data(), new Data());
            else {
                return Collections.emptyList();
            }
        }
    }
}