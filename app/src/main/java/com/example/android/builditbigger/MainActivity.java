package com.example.android.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


//import com.google.appengine.repackaged.com.google.common.base.Pair;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("MainActivity","Here i am");
        //noinspection unchecked
       // new JokeExtract().execute();
      //  jokeExecution();
    }
//    public void jokeExecution(){
//        TaskCompleted taskCompleted = new TaskCompleted() {
//            @Override
//            public void fetchingjokecompeleted(String s, boolean b) {
//                Intent intent = new Intent(getApplicationContext(),display.class);
//                intent.putExtra("free",b);
//                intent.putExtra("joke",s);
//               // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        };
//        TextView textView = (TextView)findViewById(R.id.textView);
//        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
//        AdView adView = (AdView)findViewById(R.id.adView);
//        JokeExtract task = new JokeExtract(taskCompleted,textView,progressBar,adView);
//        task.execute();
//    }
}
