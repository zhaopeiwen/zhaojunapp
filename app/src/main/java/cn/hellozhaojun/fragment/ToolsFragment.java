package cn.hellozhaojun.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by asus on 2017/5/17.
 */

public class ToolsFragment extends Fragment {
    private LinearLayout mLayout_neixin;
    private LinearLayout mLayout1;
    private LinearLayout mLayout_temperature;
    private LinearLayout mLayout_note;
    private LinearLayout mLayout_fit;
    private LinearLayout mlayout_relative;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab02, container, false);
        return view;

    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //内心日记的点击事件
        mLayout_neixin = (LinearLayout) getActivity().findViewById(R.id.layout_neixin);
        mLayout_neixin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),WebView_neixin.class);
                startActivity(intent);
            }
        });

        //记事本点击事件
        mLayout_note = (LinearLayout) getActivity().findViewById(R.id.layout_note);
        mLayout_note.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),NoteMain.class);
                startActivity(intent);
            }
        });

        //计算器的点击事件
        mLayout1 = (LinearLayout) getActivity().findViewById(R.id.layout1);
        mLayout1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),Calculator.class);
                startActivity(intent);
            }
        });

        //温度转换的点击事件
        mLayout_temperature = (LinearLayout) getActivity().findViewById(R.id.layout_temperature);
        mLayout_temperature.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Temperature.class);
                startActivity(intent);
            }
        });

        //体脂率计算的点击事件
        mLayout_fit = (LinearLayout) getActivity().findViewById(R.id.layout_fit);
        mLayout_fit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Fit.class);
                startActivity(intent);
            }
        });

        //亲戚称呼计算的点击事件
        mlayout_relative = (LinearLayout) getActivity().findViewById(R.id.layout_relative);
        mlayout_relative.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Relative.class);
                startActivity(intent);
            }
        });
    }
}
