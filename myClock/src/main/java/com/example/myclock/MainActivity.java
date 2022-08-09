package com.example.myclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity  implements NumberPicker.OnValueChangeListener, NumberPicker.OnScrollListener, NumberPicker.Formatter{

    private static final String TAG ="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {


        NumberPicker hourPicker=(NumberPicker) findViewById(R.id.hourpicker);
        hourPicker.setFormatter(this);
        hourPicker.setOnValueChangedListener(this);
        hourPicker.setOnScrollListener(this);
        hourPicker.setMaxValue(24);
        hourPicker.setMinValue(0);
        hourPicker.setValue(9);

        NumberPicker minutePicker=(NumberPicker) findViewById(R.id.minuteicker);
        minutePicker.setFormatter(this);
        minutePicker.setOnValueChangedListener(this);
        minutePicker.setOnScrollListener(this);
        minutePicker.setMaxValue(60);
        minutePicker.setMinValue(1);
        minutePicker.setValue(49);

        //设置为对当前值不可编辑
        hourPicker.setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS);
        minutePicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);

        //这里设置为不循环显示，默认值为true
        hourPicker.setWrapSelectorWheel(false);
        minutePicker.setWrapSelectorWheel(false);
    }

    @Override
    public String format(int value) {
        Log.i(TAG, "format: value");
        String tmpStr = String.valueOf(value);
        if (value < 10) {
            tmpStr = "0" + tmpStr;
        }
        return tmpStr;
    }

    @Override
    public void onScrollStateChange(NumberPicker view, int scrollState) {
        switch (scrollState) {
                 //SCROLL_STATE_FLING:手离开之后还在滑动
            case NumberPicker.OnScrollListener.SCROLL_STATE_FLING:
                Log.i(TAG, "onScrollStateChange: 后续滑动(飞呀飞，根本停下来)");
                break;
                //SCROLL_STATE_IDLE 不滑动
            case NumberPicker.OnScrollListener.SCROLL_STATE_IDLE:
                Log.i(TAG, "onScrollStateChange: 不滑动");
                break;
                //SCROLL_STATE_TOUCH_SCROLL  滑动中
            case NumberPicker.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                Log.i(TAG, "onScrollStateChange: 滑动中");
                break;
        }

    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        Log.i(TAG, "onValueChange: 原来的值 " + oldVal + "--新值: "
                + newVal);

    }

}