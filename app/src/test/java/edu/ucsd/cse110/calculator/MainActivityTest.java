package edu.ucsd.cse110.calculator;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;


/**
 * Note that these tests are far from exhaustive:
 * We're not testing for negative numbers
 * We're not testing for overflows etc.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> scenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    private ActivityScenario<MainActivity> scenario;
    private EditText num1View;
    private EditText num2View;
    private Button equalsBtn;
    private TextView answerView;

    @Before
    public void setup() {
        scenario = scenarioRule.getScenario();
    }

    private void init(MainActivity mainActivity) {
        num1View = mainActivity.findViewById(R.id.number_1);
        num2View = mainActivity.findViewById(R.id.number_2);
        equalsBtn = mainActivity.findViewById(R.id.btn_equals);
        answerView = mainActivity.findViewById(R.id.answer);
    }

    @Test
    public void testNoInput() {
        scenario.onActivity(mainActivity -> {
            init(mainActivity);
            equalsBtn.performClick();
            assertEquals("0", answerView.getText().toString());
        });
    }

    @Test
    public void testInput1() {
        scenario.onActivity(mainActivity -> {
            init(mainActivity);
            num1View.setText("123");
            equalsBtn.performClick();
            assertEquals("123", answerView.getText().toString());
        });
    }

    @Test
    public void testInput2() {
        scenario.onActivity(mainActivity -> {
            init(mainActivity);
            num2View.setText("456");
            equalsBtn.performClick();
            assertEquals("456", answerView.getText().toString());
        });
    }

    @Test
    public void testInputBoth() {
        scenario.onActivity(mainActivity -> {
            init(mainActivity);
            num1View.setText("789");
            num2View.setText("123");
            equalsBtn.performClick();
            assertEquals("912", answerView.getText().toString());
        });
    }

}