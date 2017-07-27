package cn.hellozhaojun.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by asus on 2017/5/17.
 */

public class SettingFragment extends Fragment {
    private LinearLayout mtab03_layout_help;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab03, container, false);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //帮助点击事件
        mtab03_layout_help = (LinearLayout) getActivity().findViewById(R.id.tab03_layout_help);
        mtab03_layout_help.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Setting_help.class);
                startActivity(intent);
            }
        });

    }


}
