package com.thomascook.qa

import cucumber.api.PendingException

class Util {
    static int parse(String marker) {
        if (marker == 'first') {
            return 1
        } else if (marker == 'second') {
            return 2
        } else {
            throw new PendingException("This marker is not added yet: " + marker)
        }
    }
}
