package com.example.champhaha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {
    private  TextView tvhello;
    private EditText editTextHello;
    private Button btnCopy;
    private EditText editText1,editText2;
    private TextView tvResult;
    private Button btnCalculate;
    private RadioButton rbPlus,rbMinus,rbMutiply,rbDiv ;
    private  RadioGroup rgOperator ;
    //RadioGroup rbPlus,rbMinus,rbMutiply,rbDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initInstances();
    }

    private void initInstances() {


        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        tvResult = (TextView) findViewById(R.id.tvResult);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(this);

        rgOperator = (RadioGroup) findViewById(R.id.rgOperator);

        rbPlus = (RadioButton) findViewById(R.id.rbPlus);
        rbMinus = (RadioButton) findViewById(R.id.rbMinus);
        rbMutiply = (RadioButton) findViewById(R.id.rbMutiply);
        rbDiv = (RadioButton) findViewById(R.id.rbDiv);



    }

    @Override
    public void onClick(View v) {
        int var1=0,var2=0;
        double sum = 0.0 ;

        /*
        if(rbPlus.isChecked())
        {
            sum  = var1 + var2 ;
        }
        else if(rbMinus.isChecked())
        {
            sum  = var1 - var2 ;
        }
        else if(rbDiv.isChecked() )
        {
            sum = var1 / var2 ;
        }
        else if(rbDiv.isChecked())
        {
            sum = var1 * var2 ;
        }
        */
        if(v == btnCopy)
        {
            tvhello.setText( editTextHello.getText() );
        }
        else if(v==btnCalculate)
        {
            try {
                var1 = Integer.parseInt(editText1.getText().toString());
            }
            catch (NumberFormatException e)
            {

            }
            try {
                var2 = Integer.parseInt(editText2.getText().toString());
            }
            catch (NumberFormatException e)
            {

            }
            switch (rgOperator.getCheckedRadioButtonId())
            {
                case R.id.rbPlus:
                    sum  = var1 + var2 ;
                    break;
                case R.id.rbMinus:
                    sum  = var1 - var2 ;
                    break;
                case R.id.rbDiv:
                    if(var2!=0) {
                        sum = var1 / var2;
                    }
                    break;
                case R.id.rbMutiply:

                    sum = var1 * var2 ;
                    break;
            }
            tvResult.setText(sum + "");
        }
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_DONE )
        {
            tvhello.setText( editTextHello.getText() );
        }
        return false;
    }
}