package com.example.android.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Amardeep on 10/21/2017.
 */

public class AsyncTest extends AndroidTestCase {
    String joke;

    public void test(){

        try {
            final CountDownLatch cdl = new CountDownLatch(1);
            new JokeExtract().execute(new TaskCompleted() {
                @Override
                public void fetchingjokecompeleted(String s) {
                   AsyncTest.this.joke = s;
                    cdl.countDown();
                }
            });
            cdl.await(10, TimeUnit.SECONDS);
            assertNotNull("joke is null", joke);
            assertFalse("joke is empty", joke.isEmpty());
        } catch (Exception ignored) {
            fail(ignored.getMessage());
        }
    }
}