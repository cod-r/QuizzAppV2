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


    // First question variables for storing the state of the checkboxes
    boolean isMale;
    boolean isFemale;
    boolean isCat;
    //Second question variables for storing the state of the checkboxes
    boolean q2a1State;
    boolean q2a2State;
    boolean q2a3State;
    //Third question variables for storing the state of the checkboxes
    boolean q3a1State;
    boolean q3a2State;
    boolean q3a3State;
    //Fourth question variables for storing the state of the checkboxes
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
     * Radio buttons for the first question
     */
    public void radios() {
        RadioButton maleRadio = (RadioButton) findViewById(R.id.q1_male_radio);
        // Used for storing the state of the Male radio button
        isMale = maleRadio.isChecked();

        RadioButton femaleRadio = (RadioButton) findViewById(R.id.q1_female_radio);
        // Used for storing the state of the Female radio button
        isFemale = femaleRadio.isChecked();

        RadioButton catRadio = (RadioButton) findViewById(R.id.q1_cat_radio);
        // Used for storing the state of the Cat radio button
        isCat = catRadio.isChecked();
    }

    /**
     * Used for storing the name introduced by the user
     */
    public String yourName() {
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


    public void questions() {

        /**
         * Checkboxes for the second question
         */
        CheckBox q2a1 = (CheckBox) findViewById(R.id.q2a1);
        q2a1State = q2a1.isChecked();

        CheckBox q2a2 = (CheckBox) findViewById(R.id.q2a2);
        q2a2State = q2a2.isChecked();

        CheckBox q2a3 = (CheckBox) findViewById(R.id.q2a3);
        q2a3State = q2a3.isChecked();

        /**
         * Checkboxes for the third question
         */

        CheckBox q3a1 = (CheckBox) findViewById(R.id.q3a1);
        q3a1State = q3a1.isChecked();

        CheckBox q3a2 = (CheckBox) findViewById(R.id.q3a2);
        q3a2State = q3a2.isChecked();

        CheckBox q3a3 = (CheckBox) findViewById(R.id.q3a3);
        q3a3State = q3a3.isChecked();

        /**
         * Checkboxes for the fourth question
         */

        CheckBox q4a1 = (CheckBox) findViewById(R.id.q4a1);
        q4a1State = q4a1.isChecked();

        CheckBox q4a2 = (CheckBox) findViewById(R.id.q4a2);
        q4a2State = q4a2.isChecked();

        CheckBox q4a3 = (CheckBox) findViewById(R.id.q4a3);
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
     * Checks if "Nah" answer for the last question is checked
     * and if it is then unchecks the second and third answear
     */


    public void onlyNah(View v) {
        CheckBox q5a1 = (CheckBox) findViewById(R.id.q5a1);
        q5a1State = q5a1.isChecked();

        CheckBox q5a2 = (CheckBox) findViewById(R.id.q5a2);
        q5a2State = q5a2.isChecked();
        CheckBox q5a3 = (CheckBox) findViewById(R.id.q5a3);

        q5a3State = q5a3.isChecked();
        if (q5a1State) {
            q5a2.setChecked(false);
            q5a3.setChecked(false);
        }

    }

    /**
     * Checks if "Hell Yeah!" answer for the last question is checked
     * and unchecks the state of "Nah" answear
     */

    public void onlyYeah(View v) {
        CheckBox q5a1 = (CheckBox) findViewById(R.id.q5a1);
        q5a1State = q5a1.isChecked();

        CheckBox q5a2 = (CheckBox) findViewById(R.id.q5a2);
        q5a2State = q5a2.isChecked();
        if (q5a2State) {
            q5a1.setChecked(false);
        }

    }

    /**
     * Used for calculating the overall score.
     *
     * @param view
     */
    public void doneIt(View view) {
        int score = 0;

        // Calculate the score for first question
        radios();
        questions();
        if (isMale) {
            score = score + 15;
        } else if (isFemale) {
            score = score + 15;
        }

        // Calculate the score for the second question
        if (q2a1State) {
            score = score + 5;
        }
        if (q2a2State) {
            score = score + 5;
        }
        if (q2a3State) {
            score = score + 5;
        }

        // Calculate the score for the third question
        if (q3a1State) {
            score = score + 5;
        }
        if (q3a2State) {
            score = score + 5;
        }
        if (q3a3State) {
            score = score + 5;
        }

        // Calculate the score for the fourth question
        if (q4a1State) {
            score = score + 5;
        }
        if (q4a2State) {
            score = score + 5;
        }
        if (q4a3State) {
            score = score + 5;
        }

        // Calculate the score for the fifth question
        if (q5a1State) {
            score = score + 5;
        }
        if (q5a2State) {
            score = score + 5;
        }
        if (q5a3State) {
            score = score + 5;
        }
        TextView congrats = (TextView) findViewById(R.id.congratulations);
        congrats.setVisibility(View.VISIBLE);
        if (isCat) {
            Toast.makeText(this, "Hey Cat, your score is: Over 9000!!!", Toast.LENGTH_LONG).show();
        }else if (checkNameIfEmpty()) {
            Toast.makeText(this, "Please enter your name ", Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(this, yourName() + ", your score is: " + score + "/70", Toast.LENGTH_LONG).show();
        }
    }
}


