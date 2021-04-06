package my.testframework.utils

import aqa.framework.reporter.BaseReporter
import aqa.framework.reporter.utils.IScreenShotUtils
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot

class Reporter extends BaseReporter {

    @Override
    IScreenShotUtils getScreenShotUtils() {
        new IScreenShotUtils() {

            @Override
            File takeScreenshot() {
                File target = new File("target/${Calendar.instance.timeInMillis}.png")
                File original = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.FILE)

                def input = original.newDataInputStream()
                def output = target.newDataOutputStream()
                output << input
                input.close()
                output.close()
                target
            }
        }
    }

}
