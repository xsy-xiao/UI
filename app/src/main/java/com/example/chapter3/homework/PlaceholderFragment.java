package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PlaceholderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View loadingView = getView().findViewById(R.id.loading_view);
        final ObjectAnimator animator1 = ObjectAnimator.ofFloat(loadingView,
                "Alpha", 1f, 0f).setDuration(1000);


        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                AnimatorSet set = new AnimatorSet();
                set.playTogether(animator1);
                set.start();


                TextView textView = getView().findViewById(R.id.text_view);
                textView.setText(R.string.hello_blank_fragment);
                final ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView,
                        "Alpha", 0f, 1f).setDuration(1000);
                set.playTogether(animator2);
                set.start();
            }
        }, 5000);
    }
}
