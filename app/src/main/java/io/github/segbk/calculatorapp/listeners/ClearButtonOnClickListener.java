package io.github.segbk.calculatorapp.listeners;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Brennan on 10/2/2016.
 */

public class ClearButtonOnClickListener implements View.OnClickListener {
    private TextView Screen;

    public ClearButtonOnClickListener(TextView screen) {
        Screen = screen;
    }

    @Override
    public void onClick(View view) {
        ButtonOnClickListener.NumberCounter = 0;
        Screen.setText("");
    }
}
