package com.thomascook.qa

import cucumber.api.PendingException

class Util {
    static int HALF_SECOND = 500

    static int parse(String marker) {
        if (marker == 'first') {
            return 1
        } else if (marker == 'second') {
            return 2
        } else {
            throw new PendingException("This marker is not added yet: " + marker)
        }
    }

    static void waitFor(Closure<Boolean> body) {
        int counter = 0
        boolean check = false
        while (!check) {
            try {
                check = body.call()
            } catch (Exception ignore) {
                println ignore
                check = false
            }
            assert counter < 10
            Thread.sleep(HALF_SECOND)
            counter++
        }
    }
}
