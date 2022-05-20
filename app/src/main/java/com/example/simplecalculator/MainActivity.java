package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnone, btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    Button btnAdd, btnSub, btnMul, btnDiv;
    Button btnClear, btnEqual, btnDot;
    EditText txtResult;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnone=(Button) findViewById(R.id.btn_1);
        btnone.setOnClickListener(this);

        btntwo=(Button) findViewById(R.id.btn_2);
        btntwo.setOnClickListener(this);

        btnthree=(Button) findViewById(R.id.btn_3);
        btnthree.setOnClickListener(this);

        btnfour=(Button) findViewById(R.id.btn_4);
        btnfour.setOnClickListener(this);

        btnfive=(Button) findViewById(R.id.btn_5);
        btnfive.setOnClickListener(this);

        btnsix=(Button) findViewById(R.id.btn_6);
        btnsix.setOnClickListener(this);

        btnseven=(Button) findViewById(R.id.btn_7);
        btnseven.setOnClickListener(this);

        btneight=(Button) findViewById(R.id.btn_8);
        btneight.setOnClickListener(this);

        btnnine=(Button) findViewById(R.id.btn_9);
        btnnine.setOnClickListener(this);

        btnzero=(Button) findViewById(R.id.btn_0);
        btnzero.setOnClickListener(this);

        btnAdd=(Button) findViewById(R.id.btn_plus);
        btnAdd.setOnClickListener(this);

        btnSub=(Button) findViewById(R.id.btn_minus);
        btnSub.setOnClickListener(this);

        btnMul=(Button) findViewById(R.id.btn_mul);
        btnMul.setOnClickListener(this);

        btnDiv=(Button) findViewById(R.id.btn_div);
        btnDiv.setOnClickListener(this);

        btnDot=(Button) findViewById(R.id.btn_dot);
        btnDot.setOnClickListener(this);

        btnClear=(Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(this);

        btnEqual=(Button) findViewById(R.id.btn_equals);
        btnEqual.setOnClickListener(this);

        txtResult=(EditText) findViewById(R.id.Edit_Txt);
        txtResult.setText("");

    }

    @Override
    public void onClick(View v) {
           if(v.equals(btnone))
               txtResult.append("1");
           if(v.equals(btntwo))
               txtResult.append("2");
           if(v.equals(btnthree))
                txtResult.append("3");
        if(v.equals(btnfour))
            txtResult.append("4");
        if(v.equals(btnfive))
            txtResult.append("5");
        if(v.equals(btnsix))
            txtResult.append("6");
        if(v.equals(btnseven))
            txtResult.append("7");
        if(v.equals(btneight))
            txtResult.append("8");
        if(v.equals(btnnine))
            txtResult.append("9");
        if(v.equals(btnzero))
            txtResult.append("0");
        if(v.equals(btnDot))
            txtResult.append(".");
        if(v.equals(btnAdd))
            txtResult.append("+");
        if(v.equals(btnSub))
            txtResult.append("-");
        if(v.equals(btnMul))
            txtResult.append("*");
        if(v.equals(btnDiv))
            txtResult.append("/");
        if(v.equals(btnClear))
            txtResult.setText("");
        if(v.equals(btnEqual))
        {
            try {
                 String data = txtResult.getText().toString();
                 if(data.contains("/")){
                     divide(data);
                 } else if(data.contains("*")){
                     multiplication(data);
                 } else if(data.contains("+")){
                     addition(data);
                 } else if(data.contains("-")){
                     subtraction(data);
                 }
            } catch(Exception e){
                displayInvalidMessage("Invalid Input");
            }
        }

    }

    private void displayInvalidMessage(String mes) {
        Toast.makeText(getBaseContext(),mes,Toast.LENGTH_LONG).show();

    }

    private void subtraction(String data) {
           String[] operands=data.split("-");
           if(operands.length==2){
               double operand1=Double.parseDouble(operands[0]);
               double operand2=Double.parseDouble(operands[1]);
               double result=operand1-operand2;
               txtResult.setText(String.valueOf(result));
           } else{
               displayInvalidMessage("Invalid Input");
           }
    }

    private void addition(String data) {
        String[] operands=data.split(Pattern.quote("+"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1+operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void multiplication(String data) {
        String[] operands=data.split(Pattern.quote("*"));
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1*operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }

    private void divide(String data) {
        String[] operands=data.split("/");
        if(operands.length==2){
            double operand1=Double.parseDouble(operands[0]);
            double operand2=Double.parseDouble(operands[1]);
            double result=operand1/operand2;
            txtResult.setText(String.valueOf(result));
        } else{
            displayInvalidMessage("Invalid Input");
        }
    }
}