package com.project.starter.utils;

import com.project.starter.exception.BadRequestException;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String DEFAULT_CURRENCY_FORMAT = "#,##0.00";
    public static final String SIMPLE_DOUBLE = "0.00";
    public static final String INTEGER_FORMAT = "#,##0";
    public static final String BLANK = "";
    public static final String COMMA_SINGLE_QUOTE = ",'";
    public static final String COMMA = ",";
    public static final String SEMICOLON = ";";
    public static final String SINGLE_QUOTE = "'";
    public static final String TWO_SINGLE_QUOTE = "''";
    public static final String SHARP = "#";

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String camelToSnake(String str) throws Exception {

        // Empty String
        String result = "";
        try{
            if(isNotEmpty(str) && str!=null){

                String[] splitStr = str.split(" ");
                if(splitStr.length>2){
                    throw new BadRequestException("An error occurred during checking order by. ");
                }else{
                    char c = str.charAt(0);
                    result = result + Character.toLowerCase(c);

                    for (int i = 1; i < str.length(); i++) {

                        char ch = str.charAt(i);

                        if (Character.isUpperCase(ch) || Character.isDigit(ch)) {
                            result = result + '_';
                            result
                                    = result
                                    + Character.toLowerCase(ch);
                        }
                        else {
                            result = result + ch;
                        }
                    }
                }
            }
        }catch (BadRequestException e){
            throw new BadRequestException(e.getMessage());
        }catch (Exception e){
            throw new Exception("An error occurred during checking order by. ");
        }
        return result;
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String formatCurrentcy(String format, BigDecimal currency) {
        NumberFormat df = new DecimalFormat(format);
        String formatStr = df.format(currency);
        return formatStr;
    }

    public static String formatCurrentcy(BigDecimal currency) {
        return formatCurrentcy(DEFAULT_CURRENCY_FORMAT, currency);
    }

    public static int removeNumberCommas(String numberWithComma) {
        if (isEmpty(numberWithComma)) {
            return 0;
        }
        if (numberWithComma != null && numberWithComma.indexOf(',') > 0) {
            return Integer.parseInt(numberWithComma.replace(",", ""));
        }
        return Integer.parseInt(numberWithComma.trim());
    }

    public static String notNull(String testStr) {
        return testStr == null ? BLANK : testStr.trim();
    }

    public static String spaceToNull(String testStr) {
        return testStr == null ? null : (testStr.trim().equals("") ? null : testStr.trim());
    }


    public static String removeStartWithZero(String text) {

        String result = text.replaceFirst("^0*", "");
        System.out.println("result: " + result);
        return result;
    }
    public static final String REGEX = "(/.+?/)";

    public static String replaceSql(String text, String replaceWith) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(text);
        boolean found = m.find();
        if (found) {
            return m.replaceAll(replaceWith);
        } else {
            return text;
        }
    }

    public static boolean isValidCitizenId(String inputCitizenId) {

        String stringCitizenId = new String(inputCitizenId);
        System.out.println("stringCitizenId :: " + stringCitizenId);
        if (stringCitizenId == null || stringCitizenId.length() == 0
                || stringCitizenId == "") {
            return false;
        }

        int[] i_mul = new int[]{
                13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        String gid = stringCitizenId;
        int l_strlen = stringCitizenId.length();
        int i_weight, i_dummy, r_chkmod, s_dummy, i_lastdigit;
        int i_sum = 0;

        System.out.println("pass :step--->1");
        if (l_strlen == 0) {
            return false;
        }
        if (l_strlen != 13) {
            return false;
        }
        System.out.println("pass :step--->2");

        s_dummy = gid.charAt(12) - '0';
        System.out.println("last digit :: " + s_dummy);
        i_lastdigit = s_dummy;
        for (int i = 0; i <= 11; i++) {
            s_dummy = gid.charAt(i) - '0';
            i_dummy = s_dummy;
            i_weight = i_dummy * i_mul[i];
            i_sum = i_sum + i_weight;
        }

        i_sum = i_sum % 11;
        r_chkmod = i_sum;

        int i_chkdigit;
        if (r_chkmod == 0) {
            i_chkdigit = 1;
        } else if (r_chkmod == 1) {
            i_chkdigit = 0;
        } else {
            i_chkdigit = 11 - r_chkmod;
        }
        System.out.println("cal :: " + i_chkdigit);
        System.out.println("pass :step--->3");
        if (i_chkdigit == i_lastdigit) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

        Matcher m = p.matcher(email);

        boolean matchFound = m.matches();

        return matchFound;
    }

    public static String Unicode2ASCII(String unicode) {
        StringBuffer ascii = new StringBuffer(unicode);
        int code;
        for (int i = 0; i < unicode.length(); i++) {
            code = (int) unicode.charAt(i);
            if ((0xE01 <= code) && (code <= 0xE5B)) {
                ascii.setCharAt(i, (char) (code - 0xD60));
            }
        }
        return ascii.toString();
    }

    public static String ASCII2Unicode(String ascii) {
        StringBuffer unicode = new StringBuffer(ascii);
        int code;
        for (int i = 0; i < ascii.length(); i++) {
            code = (int) ascii.charAt(i);
            if ((0xA1 <= code) && (code <= 0xFB)) {
                unicode.setCharAt(i, (char) (code + 0xD60));
            }
        }
        return unicode.toString();
    }

    public static String genSqlInStr(List listOfId) {
        StringBuilder allKey = new StringBuilder();
        for (int i = 0; i < listOfId.size(); i++) {
            if (i == 0) {
                allKey.append(SINGLE_QUOTE).append(listOfId.get(i)).append(SINGLE_QUOTE);
            } else {
                allKey.append(COMMA_SINGLE_QUOTE).append(listOfId.get(i)).append(SINGLE_QUOTE);
            }
        }
        if (isEmpty(allKey.toString())) {
            allKey.append(TWO_SINGLE_QUOTE); //Set empty in sql as ''
        }
        return allKey.toString();
    }

    public static String Left(String text, int length) {
        if (text != null) {
            return text.substring(0, text.length() >= length ? length : text.length());
        } else {
            return null;
        }
    }

    public static String Right(String text, int length) {
        if (text != null) {
            return text.substring(text.length() - (text.length() >= length ? length : text.length()), text.length());
        } else {
            return null;
        }
    }

    public static String Mid(String text, int start, int end) {
        if (text != null) {
            return text.substring(start, end);
        } else {
            return null;
        }
    }

    public static String Mid(String text, int start) {
        if (text != null) {
            return text.substring(start, text.length() - start);
        } else {
            return null;
        }
    }

    public static String[] split(String value, String delim) {
        if (value == null) {
            return new String[0];
        }
        if (value.trim().equals("")) {
            return new String[0];
        }
        String[] ret = null;
        if (value.indexOf(delim) == -1) {
            ret = new String[1];
            ret[0] = value;
        } else {
            StringTokenizer stoken = new StringTokenizer(value, delim);
            ret = new String[stoken.countTokens()];
            int i = 0;
            while (stoken.hasMoreTokens()) {
                ret[i] = stoken.nextToken();
                i++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        double z = 0;
        z = Math.pow(x, y);
        System.out.println("z >> " + z);
    }

    public static String nullToSpace(String str) {
        if(isEmpty(str)) {
            return " ";
        }
        return str;
    }

    public static String formatNumber(String value) {
        try {
            double number = Double.parseDouble(value);
            DecimalFormat decimalFormat = new DecimalFormat("0");
            return decimalFormat.format(number);
        } catch (NumberFormatException e) {
            return value;
        }
    }

    public static String insertZeros(String data, int desiredLength) {
        String format = "%0" + desiredLength + "d";
        return String.format(format, Integer.parseInt(data));
    }

    public static String insertSpaceBtwStrings(String in1, String int2, Integer length) {
        Integer lengthIn1 = in1.length();
        Integer lengthIn2 = int2.length();
        int spaceNo = length - (lengthIn1+lengthIn2);
        String spaces = repeatString(" ", spaceNo);
        return in1 + spaces + int2;

    }

    public static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean areAllValuesSame(String[] array) {
        if (array.length <= 1) {
            return true;
        }
        String firstElement = array[0];

        for (int i = 1; i < array.length; i++) {
            if (!firstElement.trim().equals(array[i].trim())) {
                return false;
            }
        }

        return true;
    }
}
