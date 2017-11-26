package com.example.android.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.example.amardeep.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Amardeep on 11/3/2017.
 */

public class JokeExtract extends AsyncTask<TaskCompleted,Void,String> {
    private static MyApi myApi = null;
    private TaskCompleted mCompleted;
    public JokeExtract(){}
    @Override
    protected String doInBackground(TaskCompleted... param) {
        Log.v("JOKEEXTRACTFree","Here i am");

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            Log.v("JOKEEXTRACTTTTT","APP IS HERE");
            myApi = builder.build();
        }
        mCompleted = param[0];
        try {
            return myApi.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        mCompleted.fetchingjokecompeleted(s);
    }
}
