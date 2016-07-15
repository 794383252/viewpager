package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2016/7/15.
 */
public class fragment_3 extends Fragment{
    Button button;
    static fragment_3 fragment_3=new fragment_3();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_3,container,false);
        button= (Button) view.findViewById(R.id.fragment_3_button);
        Bundle bundle2=getArguments();
        Log.i("ln",bundle2.getString("message"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ln","点击3");
                Bundle bundle=new Bundle();
                bundle.putString("message","来自消息3");
                fragment_3.setArguments(bundle);
            }
        });
        return view;
    }

    public static fragment_3 newInstance()
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", "来自activity3");

        fragment_3.setArguments(bundle);

        return fragment_3;
    }

}
