package io.github.segbk.calculatorapp.listeners;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Brennan on 10/2/2016.
 */

public class ButtonOnClickListener implements View.OnClickListener {

    private Context context;
    private Button btn;
    private EditText screen;

    public ButtonOnClickListener(Context context, Button btn, EditText screen) {
        this.context = context;
        this.btn = btn;
        this.screen = screen;
    }

    @Override
    public void onClick(View view) {
        Editable s = screen.getText();
        s.append(btn.getText());
        screen.setText(s);
    }
}
