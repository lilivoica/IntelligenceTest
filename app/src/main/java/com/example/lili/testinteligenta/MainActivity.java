package com.example.lili.testinteligenta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int totalScore, score1, score2, score3, score4, score5;
    private boolean checked1, checked2, checked3, checked4;
    private final int MAX_SCORE = 2, MED_SCORE = 1, MIN_SCORE = 0;
    private RadioGroup RadioGroup1, RadioGroup2, RadioGroup3;
    private CheckBox CheckBox1, CheckBox2, CheckBox3, CheckBox4;
    private EditText EditTextQ5;
    private final String CHECKED_ANSWER1_KEY = "checked1", CHECKED_ANSWER2_KEY = "checked2", CHECKED_ANSWER3_KEY = "checked3", CHECKED_ANSWER4_KEY = "checked4";
    private final String SCORE_TOTAL_KEY = "score", SCORE1_KEY = "score1", SCORE2_KEY = "score2", SCORE3_KEY = "score3", SCORE4_KEY = "score4", SCORE5_KEY = "score5";

    //region Activity lifecycle and overridings
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup1 = findViewById(R.id.radiogroup1);
        RadioGroup2 = findViewById(R.id.radiogroup2);
        RadioGroup3 = findViewById(R.id.radiogroup3);
        CheckBox1 = findViewById(R.id.button13);
        CheckBox2 = findViewById(R.id.button14);
        CheckBox3 = findViewById(R.id.button15);
        CheckBox4 = findViewById(R.id.button16);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        saveInstanceState.putInt(SCORE_TOTAL_KEY, totalScore);
        saveInstanceState.putInt(SCORE1_KEY, score1);
        saveInstanceState.putInt(SCORE2_KEY, score2);
        saveInstanceState.putInt(SCORE3_KEY, score3);
        saveInstanceState.putInt(SCORE4_KEY, score4);
        saveInstanceState.putInt(SCORE5_KEY, score5);
        saveInstanceState.putBoolean(CHECKED_ANSWER1_KEY, true);
        saveInstanceState.putBoolean(CHECKED_ANSWER2_KEY, true);
        saveInstanceState.putBoolean(CHECKED_ANSWER3_KEY, true);
        saveInstanceState.putBoolean(CHECKED_ANSWER4_KEY, true);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        totalScore = savedInstanceState.getInt(SCORE_TOTAL_KEY);
        score1 = savedInstanceState.getInt(SCORE1_KEY);
        score2 = savedInstanceState.getInt(SCORE2_KEY);
        score3 = savedInstanceState.getInt(SCORE3_KEY);
        score4 = savedInstanceState.getInt(SCORE4_KEY);
        score5 = savedInstanceState.getInt(SCORE5_KEY);
        checked1 = savedInstanceState.getBoolean(CHECKED_ANSWER1_KEY);
        checked2 = savedInstanceState.getBoolean(CHECKED_ANSWER2_KEY);
        checked3 = savedInstanceState.getBoolean(CHECKED_ANSWER3_KEY);
        checked4 = savedInstanceState.getBoolean(CHECKED_ANSWER4_KEY);
    }
    //endregion

    //region Buttons selection and score assignment
    public void onRadioButtonClicked1(View view) {
        checked1 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button1:
                if (checked1) {
                    score1 += MIN_SCORE;
                    break;
                }
            case R.id.button2:
                if (checked1) {
                    score1 += MAX_SCORE;
                    break;
                }
            case R.id.button3:
                if (checked1) {
                    score1 += MIN_SCORE;
                    break;
                }
            case R.id.button4:
                if (checked1) {
                    score1 += MIN_SCORE;
                    break;
                }
        }
    }

    public void onRadioButtonClicked2(View view) {
        checked2 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button5:
                if (checked2) {
                    score2 += MIN_SCORE;
                    break;
                }
            case R.id.button6:
                if (checked2) {
                    score2 += MIN_SCORE;
                    break;
                }
            case R.id.button7:
                if (checked2) {
                    score2 += MAX_SCORE;
                    break;
                }
            case R.id.button8:
                if (checked2) {
                    score2 += MIN_SCORE;
                    break;
                }
        }
    }

    public void onRadioButtonClicked3(View view) {
        checked3 = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.button9:
                if (checked3) {
                    score3 += MIN_SCORE;
                    break;
                }
            case R.id.button10:
                if (checked3) {
                    score3 += MAX_SCORE;
                    break;
                }
            case R.id.button11:
                if (checked3) {
                    score3 += MIN_SCORE;
                    break;
                }
            case R.id.button12:
                if (checked3) {
                    score3 += MIN_SCORE;
                    break;
                }
        }
    }

    public void onCheckboxClicked(View view) {
        checked4 = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.button13:
                if (checked4) {
                    score4 += MED_SCORE;
                    break;
                }
            case R.id.button14:
                if (checked4) {
                    score4 += -MED_SCORE;
                    break;
                }
            case R.id.button15:
                if (checked4) {
                    score4 += MED_SCORE;
                    break;
                }
            case R.id.button16:
                if (checked4) {
                    score4 += -MED_SCORE;
                    break;
                }
        }
        if (score4 < 0) {
            score4 = 0;
        }
    }
    //endregion

    //region Result display according the score
    public void submitOrder(View view) {
        EditTextQ5 = findViewById(R.id.answer5);
        String answer5 = EditTextQ5.getText().toString();

        if (answer5.toLowerCase().equals("20"))
            score5 += MAX_SCORE;
        else
            score5 += MIN_SCORE;
        totalScore = score1 + score2 + score3 + score4 + score5;
        if (checked1 && checked2 && checked3 && checked4 && !answer5.equals("")) {

            if (totalScore < 2) {
                Toast.makeText(this, getString(R.string.result_for_0_points) + "\n" + getString(R.string.correctAnswers), Toast.LENGTH_LONG).show();
                return;
            }
            if (totalScore < 4) {
                Toast.makeText(this, getString(R.string.result_for_2_points) + "\n" + getString(R.string.correctAnswers), Toast.LENGTH_LONG).show();
                return;
            }
            if (totalScore < 6) {
                Toast.makeText(this, getString(R.string.result_for_4_points) + "\n" + getString(R.string.correctAnswers), Toast.LENGTH_LONG).show();
                return;
            }
            if (totalScore < 8) {
                Toast.makeText(this, getString(R.string.result_for_6_points) + "\n" + getString(R.string.correctAnswers), Toast.LENGTH_LONG).show();
                return;
            }
            if (totalScore < 10) {
                Toast.makeText(this, getString(R.string.result_for_8_points) + "\n" + getString(R.string.correctAnswers), Toast.LENGTH_LONG).show();
                return;
            }
            if (totalScore < 11) {
                Toast.makeText(this, getString(R.string.result_for_10_points), Toast.LENGTH_LONG).show();
            }
        }
    }
    //endregion

    //region Score reset,Radio Groups uncheck and editText setting
    public void clickReset(View view) {
        uncheckRadioGroup(RadioGroup1);
        uncheckRadioGroup(RadioGroup2);
        uncheckRadioGroup(RadioGroup3);
        EditTextQ5.setText("");
        uncheckCheckBoxes();
        totalScore = 0;
        score1 = 0;
        score2 = 0;
        score3 = 0;
        score4 = 0;
        score5 = 0;
    }

    private void uncheckRadioGroup(RadioGroup radioGroup) {
        radioGroup.clearCheck();
    }

    private void uncheckCheckBoxes() {
        CheckBox1.setChecked(false);
        CheckBox2.setChecked(false);
        CheckBox3.setChecked(false);
        CheckBox4.setChecked(false);
        checked4 = false;
    }
    //endregion
}



