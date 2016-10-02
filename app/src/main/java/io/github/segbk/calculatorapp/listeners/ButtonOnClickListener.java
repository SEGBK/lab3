package io.github.segbk.calculatorapp.listeners;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;


/**
 * Created by Brennan on 10/2/2016.
 */

public class ButtonOnClickListener implements View.OnClickListener {

    private Context context;
    private Button btn;
    private TextView screen;
    static int NumberCounter = 0;

    public ButtonOnClickListener(Context context, Button btn, TextView screen) {
        this.context = context;
        this.btn = btn;
        this.screen = screen;
    }

    @Override
    public void onClick(View view) {
        String s = screen.getText().toString();
        if (btn.getText().equals("X") || btn.getText().equals("+") || btn.getText().equals("-") || btn.getText().equals("÷")) {
            s += (" ");
            s += (btn.getText());
            s += (" ");
        } else if (NumberCounter >= 3) {
            s += (",");
            s += (btn.getText());
            NumberCounter = 0;
            NumberCounter++;
        }
        else
        {
            s += (btn.getText());
            NumberCounter++;
        }
        s = s.replace(",","");
        screen.setText(s);

    }
}
