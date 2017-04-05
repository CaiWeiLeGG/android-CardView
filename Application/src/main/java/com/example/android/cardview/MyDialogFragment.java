package com.example.android.cardview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Administrator on 2017/4/5.
 * 这是DialogFragment  记住转换屏目
 */

public class MyDialogFragment extends DialogFragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.my_dia_frg, container, false);
        Button btn_close = (Button) rootView.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });


        //对话框没有标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置背景透明度
//        getDialog().getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        //取消外触摸    模态对话框
        getDialog().setCanceledOnTouchOutside(false);

        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();

        //下面是定义它的宽度
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            dialog.getWindow().setLayout((int) (dm.widthPixels * 0.95), ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
