package edu.ucsd.cse110.calculator;

import android.widget.EditText;

import org.junit.Rule;
import org.junit.Test;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.rule.ActivityTestRule;

import static org.junit.Assert.*;

public class MainActivityAndroidTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test1(){
        EditText editText = (EditText) mainActivity.getActivity().findViewById(R.id.number_1);
        assertEquals(editText.getHint().toString(), "Number 1");
    }
}