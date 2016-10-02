package io.github.segbk.calculatorapp.listeners;

import android.view.View;
import android.widget.EditText;

/**
 * Created by Brennan on 10/2/2016.
 */

public class ClearButtonOnClickListener implements View.OnClickListener {
    private EditText Screen;

    public ClearButtonOnClickListener(EditText screen) {
        Screen = screen;
    }

    @Override
    public void onClick(View view) {
        Screen.setText("");
    }
}
