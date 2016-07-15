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
public class fragment_2 extends Fragment{
    Button button;
    static fragment_2 fragment_2=new fragment_2();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_2,container,false);

        button= (Button) view.findViewById(R.id.fragment_2_button);
        Bundle bundle2=getArguments();
        Log.i("ln",bundle2.getString("message"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ln","点击2");
                Bundle bundle=new Bundle();
                bundle.putString("message","来自消息2");
                fragment_2.setArguments(bundle);
            }
        });
        return view;
    }

    public static fragment_2 newInstance()
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", "来自activity2");

        fragment_2.setArguments(bundle);

        return fragment_2;
    }

}
