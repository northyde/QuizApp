package com.example.android.quizapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //These booleans are true when the right answer is given
    boolean isRightOne = false;
    boolean isRightTwo = false;
    boolean isRightThree = false;
    boolean isRightFour = false;
    boolean isRightFive = false;
    int numberRightAnswers = 0;
    // Radio Buttons for the right answers of questions one, four and five
    RadioButton OneRadioButton;
    RadioButton FourRadioButton;
    RadioButton FiveRadioButton;
    RadioGroup groupOne;
    RadioGroup groupFour;
    RadioGroup groupFive;
    //Question two EditText
    EditText gas_editText;
    //Question three CheckBoxes
    CheckBox front;
    CheckBox back;
    CheckBox nothing;
    CheckBox not;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        //Initiates questions one, four, five right Radio Buttons
        OneRadioButton = findViewById(R.id.eardrum_radioButton);
        FourRadioButton = findViewById(R.id.twelve_radioButton);
        FiveRadioButton = findViewById(R.id.calm_radioButton);
        // Initiates questions one, four, five RadioGroups
        groupOne = findViewById(R.id.questionOneGroup);
        groupFour = findViewById(R.id.questionFourGroup);
        groupFive = findViewById(R.id.questionFiveGroup);
        //Initiates question two EditText
        gas_editText = findViewById(R.id.gas_editText);
        //Initiates question three CheckBoxes
        front = findViewById(R.id.front_checkBox);
        back = findViewById(R.id.back_checkBox);
        not = findViewById(R.id.not_checkBox);
        nothing = findViewById(R.id.nothing_checkBox);
    }


    //SubmitAnswers method is called when Submit answers- Button is clicked
    public void SubmitAnswers(View view) {
        //Checks if question one is answered right
        isRightOne = OneRadioButton.isChecked();
        //Gets the string from the text entered in question two EditText
        String gasName = gas_editText.getText().toString().trim();
        //Checks if question two is answered right
        isRightTwo = (gasName.equalsIgnoreCase(getString(R.string.answer_two)));
        //Checks if question three is answered right
        isRightThree = (front.isChecked() && back.isChecked() && !not.isChecked() && !nothing.isChecked());
        //Checks if question four is right
        isRightFour = FourRadioButton.isChecked();
        //Checks if question five is right
        isRightFive = FiveRadioButton.isChecked();
        //Collects variables for right answers and gives them away for evaluation
        evaluation(isRightOne, isRightTwo, isRightThree, isRightFour, isRightFive);
    }


    //Counts the number of right answers and gives them to the display method
    public void evaluation(boolean isRightOne, boolean isRightTwo, boolean isRightThree, boolean isRightFour, boolean isRightFive) {
        numberRightAnswers = 0;
        if (isRightOne) numberRightAnswers++;
        if (isRightTwo) numberRightAnswers++;
        if (isRightThree) numberRightAnswers++;
        if (isRightFour) numberRightAnswers++;
        if (isRightFive) numberRightAnswers++;
        displayToast(numberRightAnswers);
    }


    //Method to display the right toast according to the number of right answers
    public void displayToast(int numberRightAnswers) {
        if (numberRightAnswers == 5) {
            Toast professionalToast = Toast.makeText(this, getString(R.string.toast5), Toast.LENGTH_LONG);
            professionalToast.show();
        } else if (numberRightAnswers == 4) {
            Toast nearlyToast = Toast.makeText(this, getString(R.string.toast4), Toast.LENGTH_LONG);
            nearlyToast.show();
        } else if (numberRightAnswers == 3) {
            Toast improvementToast = Toast.makeText(this, getString(R.string.toast3), Toast.LENGTH_LONG);
            improvementToast.show();
        } else if (numberRightAnswers == 2) {
            Toast improvementToast = Toast.makeText(this, getString(R.string.toast2), Toast.LENGTH_LONG);
            improvementToast.show();
        } else if (numberRightAnswers == 1) {
            Toast improvementToast = Toast.makeText(this, getString(R.string.toast1), Toast.LENGTH_LONG);
            improvementToast.show();
        } else {
            Toast zeroToast = Toast.makeText(this, getString(R.string.toast0), Toast.LENGTH_LONG);
            zeroToast.show();
        }
    }


    // Method that is called when pressing the Try again!- Button. Resets all variables and undoes TextEdits, CheckBoxes and RadioButtons
    public void reset(View view) {
        //Reset CheckBoxes for question three
        if (front.isChecked()) front.toggle();
        if (back.isChecked()) back.toggle();
        if (not.isChecked()) not.toggle();
        if (nothing.isChecked()) nothing.toggle();
        //Reset TextEdit for question two to show hint
        gas_editText.setText("");
        //Reset RadioGroups for questions one, four and five
        groupOne.clearCheck();
        groupFour.clearCheck();
        groupFive.clearCheck();

    }
}



