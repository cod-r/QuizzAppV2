package com.example.panea.quizzapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // First question variables for storing the state of the radio buttons
    boolean isMale;
    boolean isFemale;
    boolean isCat;
    //Second question variables for storing the state of the radio buttons
    boolean q2a1State;
    boolean q2a2State;
    boolean q2a3State;
    //Third question variables for storing the state of the radio buttons
    boolean q3a1State;
    boolean q3a2State;
    boolean q3a3State;
    //Fourth question variables for storing the state of the radio buttons
    boolean q4a1State;
    boolean q4a2State;
    boolean q4a3State;
    //Fifth question variables for storing the state of the checkboxes
    boolean q5a1State;
    boolean q5a2State;
    boolean q5a3State;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * Used for saving the state of all RadioButtons and all CheckBoxes
     */
    public void saveButtonsState() {

        /**
         * Radio buttons for the first question
         */
        RadioButton maleRadio = (RadioButton) findViewById(R.id.q1_male_radio);
        isMale = maleRadio.isChecked();

        RadioButton femaleRadio = (RadioButton) findViewById(R.id.q1_female_radio);
        isFemale = femaleRadio.isChecked();

        RadioButton catRadio = (RadioButton) findViewById(R.id.q1_cat_radio);
        isCat = catRadio.isChecked();

        /**
         * Radios for the second question
         */
        RadioButton q2a1 = (RadioButton) findViewById(R.id.q2a1);
        q2a1State = q2a1.isChecked();

        RadioButton q2a2 = (RadioButton) findViewById(R.id.q2a2);
        q2a2State = q2a2.isChecked();

        RadioButton q2a3 = (RadioButton) findViewById(R.id.q2a3);
        q2a3State = q2a3.isChecked();

        /**
         * Radios for the third question
         */

        RadioButton q3a1 = (RadioButton) findViewById(R.id.q3a1);
        q3a1State = q3a1.isChecked();

        RadioButton q3a2 = (RadioButton) findViewById(R.id.q3a2);
        q3a2State = q3a2.isChecked();

        RadioButton q3a3 = (RadioButton) findViewById(R.id.q3a3);
        q3a3State = q3a3.isChecked();

        /**
         * Radios for the fourth question
         */

        RadioButton q4a1 = (RadioButton) findViewById(R.id.q4a1);
        q4a1State = q4a1.isChecked();

        RadioButton q4a2 = (RadioButton) findViewById(R.id.q4a2);
        q4a2State = q4a2.isChecked();

        RadioButton q4a3 = (RadioButton) findViewById(R.id.q4a3);
        q4a3State = q4a3.isChecked();

        /**
         * Checkboxes for the fifth question
         */

        CheckBox q5a1 = (CheckBox) findViewById(R.id.q5a1);
        q5a1State = q5a1.isChecked();

        CheckBox q5a2 = (CheckBox) findViewById(R.id.q5a2);
        q5a2State = q5a2.isChecked();

        CheckBox q5a3 = (CheckBox) findViewById(R.id.q5a3);
        q5a3State = q5a3.isChecked();


    }
    /**
     * Used for checking the answer of the first question
     */
    private String participatedCheck() {
        EditText participatedField = (EditText) findViewById(R.id.participated_field);
        String answear = participatedField.getText().toString();
        return answear;
    }

    /**
     * Used for storing the name introduced by the user
     */
    private String yourName() {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        return name;
    }

    /**
     * Checks if the user has written the name in the name field
     */
    private boolean checkNameIfEmpty() {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        return (nameField.getText().toString().trim().length() == 0);
    }



    /**
     * Used for calculating the overall score.
     *
     * @param view
     */
    public void doneIt(View view) {
        //Used for storing the score
        int score = 0;
        saveButtonsState();

        if (participatedCheck().equals("Yes") || participatedCheck().equals("yes")) {
            score = score + 20;
        }

        // Calculate the score for the second question
        if (q2a1State) {
            score = score + 20;
        }

        // Calculate the score for the third question
        if (q3a2State) {
            score = score + 20;
        }


        // Calculate the score for the fourth question
        if (q4a3State) {
            score = score + 20;
        }

        // Calculate the score for the fifth question
        if (!q5a1State && q5a2State && q5a3State) {
            score = score + 20;
        }


        if (isCat) {
            Toast.makeText(this, "Hey Cat, your score is: Over 9000!!!", Toast.LENGTH_LONG).show();
        } else if (checkNameIfEmpty()) {
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_LONG).show();
        } else {
            //Displays a congratulations text after the button is pressed
            TextView congrats = (TextView) findViewById(R.id.congratulations);
            congrats.setVisibility(View.VISIBLE);
            Toast.makeText(this, yourName() + ", your score is: " + score + "/100", Toast.LENGTH_LONG).show();
        }
    }
}


