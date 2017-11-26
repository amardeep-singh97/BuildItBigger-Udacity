package com.example.android.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.android.displayjoke.display;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by Amardeep on 11/3/2017.
 */

public class MainActivityFragment extends Fragment {
    private ProgressBar progress;
    private String Joke;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        initBannerAds(root);
        progress = (ProgressBar) root.findViewById(R.id.progressbar);
        root.findViewById(R.id.btnGetJoke).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progress.setVisibility(View.VISIBLE);
                new JokeExtract().execute(new TaskCompleted() {
                    @Override
                    public void fetchingjokecompeleted(String s) {
                        progress.setVisibility(View.INVISIBLE);
                         Joke=s;
                        Intent intent = new Intent(getActivity(),display.class);
                        intent.putExtra("joke",s);
                        intent.putExtra("free",true);
                        startActivity(intent);
                    }
                });
            }
        });

        return root;
    }

    private void initBannerAds(View root) {
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }
}
