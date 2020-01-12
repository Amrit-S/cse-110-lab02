package edu.ucsd.cse110.calculator;

import android.widget.EditText;

public class Utils {
    public static int toIntNullsafe(String intString) {
        if (intString == null || "".equals(intString)) {
            return 0;
        }
        return Integer.parseInt(intString);
    }
}
