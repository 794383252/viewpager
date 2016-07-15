package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/14.
 */
public class vpSimpleFragment extends Fragment {
    private String mTitle;
    public static final String BUNDEL_TITLE = "title";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle=getArguments();
        if (bundle!=null)
        {
            mTitle=bundle.getString(BUNDEL_TITLE);
        }

        TextView tv=new TextView(getActivity());
        tv.setText(mTitle);
        tv.setGravity(Gravity.CENTER);


        return tv;
    }

    public static vpSimpleFragment newInstance(String title) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDEL_TITLE, title);

        vpSimpleFragment fragment = new vpSimpleFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
}
