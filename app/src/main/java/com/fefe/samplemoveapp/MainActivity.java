package com.fefe.samplemoveapp;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;

import com.fefe.samplemoveapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
//    ボタン
    private boolean[] states = {false, false, false, false, false, false};
//    ドラッグイベント発生
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v.startDrag(null, new View.DragShadowBuilder(null), v, 0);
            return false;
        }
    };
//    ドラッグイベント管理
    private View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("onDrag", v.getTag().toString() + "タグちゃん");
//                    タグが1〜なので-1した値がstatesの要素の位置になる
                    states[Integer.parseInt(v.getTag().toString()) - 1] = !states[Integer.parseInt(v.getTag().toString()) - 1];
                    if(states[Integer.parseInt(v.getTag().toString()) - 1]) {
                        v.setBackgroundResource(R.drawable.hovered);
                    }else {
                        v.setBackgroundResource(R.drawable.button);
                    }
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    for(int i = 0; i < states.length; i++) {
                        if(states[i]) Log.d("打たれた場所", i + 1 + "番目");
                    }
                    states = new boolean[]{false, false, false, false, false, false};
                    binding.button1.setBackgroundResource(R.drawable.button);
                    binding.button2.setBackgroundResource(R.drawable.button);
                    binding.button3.setBackgroundResource(R.drawable.button);
                    binding.button4.setBackgroundResource(R.drawable.button);
                    binding.button5.setBackgroundResource(R.drawable.button);
                    binding.button6.setBackgroundResource(R.drawable.button);
                    break;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setListener();
    }

//    リスナーセット
    private void setListener() {
        binding.button1.setOnTouchListener(onTouchListener);
        binding.button2.setOnTouchListener(onTouchListener);
        binding.button3.setOnTouchListener(onTouchListener);
        binding.button4.setOnTouchListener(onTouchListener);
        binding.button5.setOnTouchListener(onTouchListener);
        binding.button6.setOnTouchListener(onTouchListener);

        binding.button1.setOnDragListener(dragListener);
        binding.button2.setOnDragListener(dragListener);
        binding.button3.setOnDragListener(dragListener);
        binding.button4.setOnDragListener(dragListener);
        binding.button5.setOnDragListener(dragListener);
        binding.button6.setOnDragListener(dragListener);
    }
}
