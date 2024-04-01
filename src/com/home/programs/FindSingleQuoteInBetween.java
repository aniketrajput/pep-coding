package com.home.programs;

public class FindSingleQuoteInBetween {

    public static void findSingleQuoteInBetweenString() {

        String str = "'test1', 'test2', 'test's', 'test5'";

        String[] strSplitArr = str.split(", ");

        for (int i = 0; i < strSplitArr.length; i++) {
            String tempStr = strSplitArr[i];

            int index = tempStr.indexOf("'");

            while (index >= 0) {
                index = tempStr.indexOf("'", index + 1);
                if (index > 0 && index < tempStr.length() - 1) {
                    strSplitArr[i] = tempStr.substring(0, index) + "\\" + tempStr.substring(index);
                    tempStr = strSplitArr[i];
                    index++;
                }
            }
        }

        String joinedStr = String.join(", ", strSplitArr);
        System.out.println(joinedStr);
    }
}

/*


    public static void findSingleQuoteInBetween() {

        String str = "'test1', 'test's', 'test5'";

        String[] strArr = str.split(", ");

        for (int i = 0; i < strArr.length; i++) {
            String tempStr = strArr[i];

            int index = tempStr.indexOf("'");
            if (index > 0 && index < tempStr.length() - 1) {
                strArr[i] = tempStr.substring(0, index) + "\\" + tempStr.substring(index);;
                tempStr = strArr[i];
                index++;
            }

            while (index >= 0) {
                index = tempStr.indexOf("'", index + 1);
                System.out.println("tempStr.length() - " + tempStr.length());
                if (index > 0 && index < tempStr.length() - 1) {
                    strArr[i] = tempStr.substring(0, index) + "\\" + tempStr.substring(index);
                    tempStr = strArr[i];
                    index++;
                }
            }

        }
    }*/
