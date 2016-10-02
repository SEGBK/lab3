package io.github.segbk.calculatorapp.listeners;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


/**
 * Created by Brennan on 10/2/2016.
 */

public class ButtonOnClickListener implements View.OnClickListener {

    private Context context;
    private Button btn;
    private TextView screen;
    static int NumberCounter = 0;
    static List<Integer> numbers;

    public ButtonOnClickListener(Context context, Button btn, TextView screen) {
        this.context = context;
        this.btn = btn;
        this.screen = screen;
    }

    @Override
    public void onClick(View view) {

        // TODO: Correct this to proper comma placement
        String s = screen.getText().toString();
        if (btn.getText().equals("X") || btn.getText().equals("+") || btn.getText().equals("-") || btn.getText().equals("÷")) {
            s += (" ");
            s += (btn.getText());
            s += (" ");
        } else {
            s += (btn.getText());
        }
        s = s.replace(",","");
        System.out.println(Integer.valueOf(s));
        screen.setText(NumberFormat.getNumberInstance(Locale.US).format(Long.valueOf(s)));


    }
}
