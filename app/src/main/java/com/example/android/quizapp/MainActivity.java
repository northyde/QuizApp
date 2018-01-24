package com.example.android.quizapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.quizapp.R;

public class MainActivity extends AppCompatActivity {

    //These booleans are true when the right answer is given
    boolean isRightOne = false;
    boolean isRightTwo = false;
    boolean isRightThree = false;
    boolean isRightFour = false;
    boolean isRightFive = false;
    int numberRightAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
    }

    //SubmitAnswers method is called when Submit answers- Button is clicked
    public void SubmitAnswers(View view) {

        //Initiates question one right Radio Button
        RadioButton OneRadioButton = (RadioButton) (findViewById(R.id.eardrum_radioButton));
        //Checks if question one is answered right
        isRightOne = OneRadioButton.isChecked();

        //Initiates question two EditText
        EditText gas_editText = (EditText) (findViewById(R.id.gas_editText));
        String gasName = gas_editText.getText().toString().trim();
        //Checks if question two is answered right
        isRightTwo = (gasName.equalsIgnoreCase(getString(R.string.answer_two)));

        //Initiates question three CheckBoxes
        CheckBox front = (CheckBox) (findViewById(R.id.front_checkBox));
        CheckBox back = (CheckBox) (findViewById(R.id.back_checkBox));
        CheckBox not = (CheckBox) (findViewById(R.id.not_checkBox));
        CheckBox nothing = (CheckBox) (findViewById(R.id.nothing_checkBox));
        //Checks if question three is answered right
        isRightThree = (front.isChecked() && back.isChecked() && !not.isChecked() && !nothing.isChecked());

        //Initiates question four right RadioButton
        RadioButton FourRadioButton = (RadioButton) (findViewById(R.id.twelve_radioButton));
        //Checks if question four is right
        isRightFour = FourRadioButton.isChecked();

        //Initiates question five right RadioButton
        RadioButton FiveRadioButton = (RadioButton) (findViewById(R.id.calm_radioButton));
        //Checks if question five is right
        isRightFive = FiveRadioButton.isChecked();
        //Collects variables for right answers and gives them away for evaluation
        evaluation(numberRightAnswers, isRightOne, isRightTwo, isRightThree, isRightFour, isRightFive);
    }


    //Counts the number of right answers and gives them to the display method
    public void evaluation(int numberRightAnswers, boolean isRightOne, boolean isRightTwo, boolean isRightThree, boolean isRightFour, boolean isRightFive) {
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
    public int reset(View view) {
        //Find Checkboxes
        CheckBox front = (CheckBox) (findViewById(R.id.front_checkBox));
        CheckBox back = (CheckBox) (findViewById(R.id.back_checkBox));
        CheckBox not = (CheckBox) (findViewById(R.id.not_checkBox));
        CheckBox nothing = (CheckBox) (findViewById(R.id.nothing_checkBox));
        //Reset CheckBoxes for question three
        if (front.isChecked()) front.toggle();
        if (back.isChecked()) back.toggle();
        if (not.isChecked()) not.toggle();
        if (nothing.isChecked()) nothing.toggle();
        //Reset TextEdit for question two to show hint
        EditText gas_editText = (EditText) (findViewById(R.id.gas_editText));
        gas_editText.setText("");
        //Reset RadioGroups for questions one, four and five
        RadioGroup groupOne = (RadioGroup) (findViewById(R.id.questionOneGroup));
        groupOne.clearCheck();
        RadioGroup groupFour = (RadioGroup) (findViewById(R.id.questionFourGroup));
        groupFour.clearCheck();
        RadioGroup groupFive = (RadioGroup) (findViewById(R.id.questionFiveGroup));
        groupFive.clearCheck();
        //Reset variable that holds the number of right answers
        int numberRightAnswers = 0;
        return numberRightAnswers;
    }
}



