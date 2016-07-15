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
 * <p/>
 * fragment有一些小瑕疵，在第二次调用setArguments会报错，此时可以采用setter和getter的方法来传递参数
 */
public class fragment_1 extends Fragment {


    Button button;
    static fragment_1 fragment_1 = new fragment_1();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        button = (Button) view.findViewById(R.id.fragment_1_button);
        Bundle bundle2 = getArguments();
        Log.i("ln", bundle2.getString("message"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("ln", "点击1");
                Bundle bundle = new Bundle();
                bundle.putString("message", "来自消息1");
                fragment_1.setArguments(bundle);
            }
        });
        return view;
    }

    public static fragment_1 newInstance() {
        Bundle bundle = new Bundle();
        bundle.putString("message", "来自activity1");

        fragment_1.setArguments(bundle);

        return fragment_1;
    }

}
