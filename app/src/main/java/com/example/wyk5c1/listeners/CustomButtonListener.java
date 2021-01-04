package com.example.wyk5c1.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.util.Log;

import com.example.wyk5c1.callback.ToolbarCallback;

public class CustomButtonListener implements View.OnClickListener {

    private ToolbarCallback _toolbarCallback;
    private EditText _editText;
    private SeekBar _seekBar;

    public CustomButtonListener(ToolbarCallback toolbarCallback, EditText editText, SeekBar seekBar) {
        _toolbarCallback = toolbarCallback;
        _editText = editText;
        _seekBar = seekBar;
    }

    @Override
    public void onClick(View v) {
        int fontSize = 20 + _seekBar.getProgress() / 5;
        _toolbarCallback.onButtonClick(fontSize, _editText.getText().toString());
    }
}
