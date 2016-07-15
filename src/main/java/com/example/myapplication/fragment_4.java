package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2016/7/15.
 */
public class fragment_4 extends Fragment{
    Button button;
    static fragment_4 fragment_4=new fragment_4();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_4,container,false);
        button= (Button) view.findViewById(R.id.fragment_4_button);
        Bundle bundle2=getArguments();
        Log.i("ln",bundle2.getString("message"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ln","点击4");
                Bundle bundle=new Bundle();
                bundle.putString("message","来自消息4");
                fragment_4.setArguments(bundle);
            }
        });
        return view;
    }

    public static fragment_4 newInstance()
    {
        Bundle bundle = new Bundle();
        bundle.putString("message", "来自activity4");


        fragment_4.setArguments(bundle);

        return fragment_4;
    }

}
