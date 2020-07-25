package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import steps.BaseSteps;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class AllureUtils {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) BaseSteps.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "text attachment", type = "text/plain")
    public static byte[] addTextPlain(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }
}
