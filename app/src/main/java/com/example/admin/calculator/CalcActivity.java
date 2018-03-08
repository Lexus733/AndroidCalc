package com.example.admin.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView resField;
    private TextView inputField;
    private Button minusButton;
    private Button plusButton;
    private Button divisionButton;
    private Button multyButton;
    private Button equalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc_ll);
        initializeComponents();
    }

    private void initializeComponents() {
    resField = (TextView) findViewById(R.id.resultField);
    inputField = (TextView) findViewById(R.id.inputField);
    minusButton = (Button) findViewById(R.id.buttonMinus);
    plusButton = (Button) findViewById(R.id.buttonPlus);
    divisionButton = (Button) findViewById(R.id.buttonDivision);
    multyButton = (Button) findViewById(R.id.buttonMulty);
    equalButton = (Button) findViewById(R.id.buttonEqual);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.buttonEqual:{
                Calculate();
                break;
            }

            case R.id.buttonDivision: {
                Division();
                break;
            }

            case R.id.buttonMinus: {
                Minus();
                break;
            }

            case R.id.buttonMulty: {
                Multy();
                break;
            }

            case R.id.buttonPlus: {
                Plus();
                break;
            }

            case R.id.buttonDot: {
                Dot();
                break;
            }

            case R.id.buttonDelete: {
                deleteSymbol();
                break;
            }

            default: {
                AppendToInput(view);
                break;
            }

        }
    }
    private void AppendToInput(View v){
        Button any = (Button) v;
        inputField.append(any.getText().toString());
        String calcStr = Calculator.getCurrentStatement();
        Calculator.setCurrentStatement(calcStr.concat(any.getText().toString()));
    }

    private void deleteSymbol(){
        String curInput = inputField.getText().toString();

        String calcStr = Calculator.getCurrentStatement();

        if (curInput.length() > 0)
        {
            inputField.setText(curInput.substring(0,curInput.length()-1));
            Calculator.setCurrentStatement(calcStr.substring(0,calcStr.length()-1));
        } else{}

    }
    private void Calculate(){
    String calcText = inputField.getText().toString();
    String curValue = Calculator.Calculate();
    resField.setText(calcText);
    inputField.setText(curValue);
    }
    private void Division(){
    inputField.append("÷");
    Calculator.setCurrentStatement(Calculator.getCurrentStatement().concat("/"));
    }
    private void Dot(){
    inputField.append(".");
    Calculator.setCurrentStatement(Calculator.getCurrentStatement().concat("."));
    }
    private void Plus(){
        inputField.append("+");
    Calculator.setCurrentStatement(Calculator.getCurrentStatement().concat("+"));
    }
    private void Multy(){
        inputField.append("*");
        Calculator.setCurrentStatement(Calculator.getCurrentStatement().concat("*"));
    }
    private void Minus(){
        inputField.append("-");
        Calculator.setCurrentStatement(Calculator.getCurrentStatement().concat("-"));
    }
}
