package my.testframework.utils

import java.util.concurrent.TimeoutException

class WaitUtil {

    static void waitForCondition(int sec, int ping, Closure condition) {
        def ms = sec * 1000
        long endTime = Calendar.getInstance().getTimeInMillis() + (ms)
        boolean isSuccess = false
        while (Calendar.getInstance().getTimeInMillis() <= endTime) {
            if (condition.call()) {
                isSuccess = true
                return
            }
            sleep(ping)
        }
        if (!isSuccess) {
            throw new TimeoutException("Condition not appeared in $sec sec")
        }
    }
}
