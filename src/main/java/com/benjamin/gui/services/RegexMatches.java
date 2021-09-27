package com.benjamin.gui.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

    /**
     * Check if String is valid (having no spacial chars)
     *
     * @param string
     * @return True / False
     */
    public boolean isValidString(String string) {
        String pattern = "^[0-9A-Za-z]+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(string);

        return m.matches();
    }

    /**
     * Check if PostalCode is correct for France
     *
     * @param code
     * @return True / False
     */
    public boolean isValidPostalCode(String code) {
        String pattern = "^[0-9]{5}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(code);

        return m.matches();
    }
}
