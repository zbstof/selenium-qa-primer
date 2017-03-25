package com.thomascook.qa.bdd

class Util {
    static int HALF_SECOND = 500;

    static int parse(String marker) {
        if (marker == 'first') {
            return 1
        } else if (marker == 'second') {
            return 2
        }
    }
}
