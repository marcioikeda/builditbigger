package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

/**
 * Created by marcio.ikeda on 04/01/2018.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testAsyncTask() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        new EndPointAsyncTask(new EndPointListener() {
            @Override
            public void onAsyncTaskComplete(String result) {
                assertNotNull(result);
                assertNotEquals("", result);
                signal.countDown();
            }
        }).execute();
        signal.await();
    }
}
