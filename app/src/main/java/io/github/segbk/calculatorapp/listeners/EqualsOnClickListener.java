package io.github.segbk.calculatorapp.listeners;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lib.*;

/**
 * Created by Brennan on 10/2/2016.
 */

public class EqualsOnClickListener implements OnClickListener {

    private Context context;
    private TextView screen;
    private TextView previousequation;
    private Calculator calc;
    public static boolean lastWasCalcualted;

    public EqualsOnClickListener(Context context, TextView screen, TextView previousequation) {
        this.context = context;
        this.screen = screen;
        this.previousequation = previousequation;
        this.calc = new Calculator();
    }

    @Override
    public void onClick(View view) {
        String s = screen.getText().toString();
        s = s.replace('÷','/');
        s = s.replace('X','*');
        s = s.replace(" ","");
        previousequation.setText(s + "=");
        screen.setText(String.valueOf(calc.eval(s)));
        lastWasCalcualted = true;
    }
}
