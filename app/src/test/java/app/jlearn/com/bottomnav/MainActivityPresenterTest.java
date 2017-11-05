package app.jlearn.com.bottomnav;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTest {

    @Mock
    private
    DataRepository mDataRepository;
    @Mock
    private
    MainActivityView mainActivityView;
    private MainActivityPresenter mainActivityPresenter;
    private final List<Data> dataList = Arrays.asList(new Data(), new Data(), new Data());


    @Before
    public void setUp() {
        mainActivityPresenter = new MainActivityPresenter(mainActivityView, mDataRepository);
    }

    @Test
    public void shouldPassMainActView() {
        //given
        Mockito.when(mDataRepository.getData()).thenReturn(dataList);
        //when
        mainActivityPresenter.getData();
        //then
        Mockito.verify(mainActivityView).displayData(dataList);


    }

    @Test
    public void shouldHandleNoData() {
        //given
        Mockito.when(mDataRepository.getData()).thenReturn(Collections.<Data>emptyList());
        //when
        mainActivityPresenter.getData();
        //then
        Mockito.verify(mainActivityView).displayNoData();


    }

}