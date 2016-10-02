package io.github.segbk.calculatorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import io.github.segbk.calculatorapp.listeners.ButtonOnClickListener;

public class MainActivity extends AppCompatActivity {

    List<Button> Buttons = new ArrayList<Button>();
    EditText screen;

    int[] IDs =
            {R.id.btn_one,R.id.btn_two, R.id.btn_three,
            R.id.btn_four, R.id.btn_five, R.id.btn_six,
            R.id.btn_seven, R.id.btn_eight, R.id.btn_nine,
            R.id.btn_zero, R.id.btn_zero, R.id.btn_equals,
            R.id.btn_add, R.id.btn_subtract, R.id.btn_multiply, R.id.btn_divide};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (EditText)findViewById(R.id.text_screen);

        for(int id : IDs){
            Buttons.add((Button)findViewById(id));
        }

        for(Button b : Buttons){
            b.setOnClickListener(new ButtonOnClickListener(this, b, screen));
        }
    }
}
