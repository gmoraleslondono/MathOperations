package com.gmorales.mathoperations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declara variables con los tipos usados en el XML
    //We have to create each element here with their type
    //The buttons have a rule different (onClick)
    EditText number1,number2;
    TextView labelResult;

    //Global variables with the data that user enter
    int value1, value2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Emparentar/asociar elementos definidos en XML
        //Instance components graphic XML, those elements change when they are used.
        //Always we have to do casting
        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        labelResult = (TextView) findViewById(R.id.labelResult);

    }

    public void onClick(View view) {

        //save in variables the data that user enter
        // we have to get the inf and casting to integer
        value1 = Integer.parseInt(number1.getText().toString());
        value2 = Integer.parseInt(number2.getText().toString());

        //using a switch the program identify which button was clicked
        //Then go to the respective function to give an answer

        switch (view.getId()) {

            case R.id.btnSum: sum();
                break;
            case R.id.btnSubtract: subtract();
                break;
            case R.id.btnMultiply: multiply();
                break;
            case R.id.btnDivision: division();
                break;
            case R.id.default_activity_button:
                break;
        }


    }

    private void sum() {
        //Operation
        int result = value1 + value2;
        //Text to show how result
        labelResult.setText("The sum is equal to: " + result);
    }

    private void subtract() {
        int result = value1 - value2;
        labelResult.setText("The subtraction is equal to: " + result);
    }

    private void multiply() {
        int result = value1 * value2;
        labelResult.setText("The multiplication is equal to: " + result);
    }

    private void division() {
        //we have to valid if the value is different to zero because this number cause an error
        if(value2!=0){
            int result = value1 / value2;
           labelResult.setText("The division is equal to: " + result);
        } else {
            //Temporary message in the bottom of the screen
            Toast.makeText(this, "Warning!",Toast.LENGTH_LONG).show();
            labelResult.setText("The second number can not be zero to be divided.");
        }
    }
}
