package com.fefe.samplemoveapp;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by fefe on 2017/05/30.
 */

public class DragViewListener implements View.OnTouchListener{

    private Button button;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
