package utils;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions extends TestBase {

    private String actual;
    private String expected;
    private String description;

    /*Function to click on a mobile element*/
    public boolean clickElement(WebElement element, int timeOutInSsec) {

        boolean isElementClicked = false;
        WebDriverWait wait = null;
        try {
            wait = new WebDriverWait(driver, timeOutInSsec);

            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
            isElementClicked = true;

            throw new IllegalStateException("Unexpected PArameter");


            //   Utils.logFunctionLevelLogs(isElementClicked, "clickElement");
            //Log.info("Successfully clicked on the element with "+locatorType.toString()+" : "+locator);

        } catch (Exception e) {
            isElementClicked = false;
            // Log.error("Exception occurred in clickElement method: " + e.getMessage());
            /*Log.error("Could not click on the element with "+locatorType.toString()+" : "+locator);
            Log.error("Exception:"+e.getMessage());*/

        }
        return isElementClicked;

    }

//
//    /*Function to send key to an element*/
//    public boolean sendKey(WebElement element, String key, int timeOutInSsec) {
//
//        boolean isKeySent = false;
//        WebDriverWait wait = null;
//
//        try {
//            wait = new WebDriverWait(GlobalVars.driver, timeOutInSsec);
//            switch (GlobalVars.platform) {
//                case "android":
//                    wait.until(ExpectedConditions.visibilityOf(element));
//                    element.clear();
//                    element.sendKeys(key);
//
//                    isKeySent = true;
//                    break;
//                case "ios":
//                    wait.until(ExpectedConditions.visibilityOf(element));
//                    element.clear();
//                    element.sendKeys(key);
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
//            }
//            Utils.logFunctionLevelLogs(isKeySent, "sendKey");
//        } catch (Exception e) {
//            isKeySent = false;
//            Log.error("Exception occurred in sendKey method" + e.getMessage());
//        }
//
//        return isKeySent;
//    }
//
//    public List findElements(By locator, int timeOutInSec) {
//
//        boolean isElement = false;
//        WebDriverWait wait = null;
//        List details = null;
//
//        try {
//            wait = new WebDriverWait(GlobalVars.driver, timeOutInSec);
//            switch (GlobalVars.platform) {
//                case "android":
//                case "ios":
//                    List<WebElement> element = driver.findElements(locator);
//                    System.out.println(element);
//                    details = element;
//                    isElement = true;
//                    break;
//                default:
//                    throw new IllegalStateException("Unexpected value: " + GlobalVars.platform);
//            }
//
//            Utils.logFunctionLevelLogs(isElement, "findElements");
//        } catch (Exception e) {
//            isElement = false;
//            Log.error("Exception occurred in sendKey method" + e.getMessage());
//        }
//        return details;
//    }
//
//    public void sendKeyByRobot(IOSElement element, String key) {
//        Actions action = null;
//
//        try {
//            action = new Actions(driver);
//            action.moveToElement(element).click().build().perform();
//            StringSelection stringSelection = new StringSelection(key);
//            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
//            clipboard.setContents(stringSelection, stringSelection);
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_V);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//        } catch (HeadlessException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (AWTException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /*Function to send key to an element*/
//    public boolean isElementDisplayed(WebElement element, int timeOutInSsec) {
//
//        boolean isElementDisplayed = false;
//        WebDriverWait wait = null;
//        try {
//
//            wait = new WebDriverWait(GlobalVars.driver, timeOutInSsec);
//            wait.until(ExpectedConditions.visibilityOf(element));
//            isElementDisplayed = element.isDisplayed();
//
//            Utils.logFunctionLevelLogs(isElementDisplayed, "isElementDisplayed");
//
//        } catch (Exception e) {
//            Log.error("Exception occurred in isElementDisplayed method" + e.getMessage());
//            isElementDisplayed = false;
//        }
//        return isElementDisplayed;
//    }
//
//    public boolean isAttributePresent(WebElement element, String attribute) {
//        Boolean result = false;
//        String value = null;
//        try {
//            value = element.getAttribute(attribute);
//            if (value != null) {
//                result = true;
//                System.out.println(value);
//            }
//        } catch (Exception e) {
//        }
//
//        return result;
//    }
//
//    public String getAttributeValue(WebElement element, String attribute) {
//        String value = null;
//        try {
//            value = element.getAttribute(attribute);
//            if (value != null) {
//                System.out.println(value);
//            }
//        } catch (Exception e) {
//        }
//
//        return value;
//    }
//
//    public String getText(WebElement element, String attribute) {
//        String value = null;
//        try {
//            value = element.getText();
//            if (value != null) {
//                System.out.println(value);
//            }
//        } catch (Exception e) {
//        }
//
//        return value;
//    }
//
//    public void navigateBack() {
//        driver.navigate().back();
//    }
//
//    public void swipeleft() {
//        Dimension size = GlobalVars.driver.manage().window().getSize();
//        int startx = (int) ((size.width) - 50);
//        int starty = (int) (size.height / 2);
//
//        int endx = startx - 800;
//        int endy = starty;
//
//        TouchAction ts = new TouchAction(GlobalVars.driver);
//        //for(int i=0;i<=3;i++) {
//        ts.press(PointOption.point(startx, starty))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                .moveTo(PointOption.point(endx, endy)).release().perform();
//    }
//
//    public void swipe() {
//        Dimension size = GlobalVars.driver.manage().window().getSize();
//        System.out.println(size.height + "height");
//        System.out.println(size.width + "width");
//        System.out.println(size);
//        int startPoint = (int) (size.width * 0.99);
//        int endPoint = (int) (size.width * 0.15);
//        int ScreenPlace = (int) (size.height * 0.40);
//        int y = (int) size.height * 20;
//
//        TouchAction ts = new TouchAction(GlobalVars.driver);
//        //for(int i=0;i<=3;i++) {
//        ts.press(PointOption.point(startPoint, ScreenPlace))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                .moveTo(PointOption.point(endPoint, ScreenPlace)).release().perform();
//    }
//
//    public void scrolldown() {
//        Dimension size = GlobalVars.driver.manage().window().getSize();
//        int startx = (int) (size.width / 2);
//        int starty = (int) (size.height / 2);
//
//        int endx = startx;
//        int endy = starty - 600;
//
//        TouchAction ts = new TouchAction(GlobalVars.driver);
//        //for(int i=0;i<=3;i++) {
//        ts.press(PointOption.point(startx, starty))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                .moveTo(PointOption.point(endx, endy)).release().perform();
//
//    }
//
//    public int getRndNumber(int number) {
//        Random random = new Random();
//        int randomNumber = 0;
//        boolean loop = true;
//        while (loop) {
//            randomNumber = random.nextInt();
//            if (Integer.toString(randomNumber).length() == number && !Integer.toString(randomNumber).startsWith("-")) {
//                loop = false;
//            }
//        }
//        return randomNumber;
//    }
//
//    /*Function to compare actual and expected result*/
//    public boolean compareActualExpected(String actual, String expected, String description) {
//        this.actual = actual;
//        this.expected = expected;
//        this.description = description;
//
//        boolean isResult = false;
//
//        if (actual.equals(expected)) {
//            System.out.println("Actual and expected " + description + " Matched");
//            isResult = true;
//        } else {
//            System.out.println("Actual and expected " + description + " Not Matched");
//            isResult = false;
//        }
//        return isResult;
//    }
//
//    public String getAlphaNumericString() {
//
//        int n = 10;
//
//        // lower limit for LowerCase Letters
//        int lowerLimit = 97;
//
//        // lower limit for LowerCase Letters
//        int upperLimit = 122;
//
//        Random random = new Random();
//
//        // Create a StringBuffer to store the result
//        StringBuffer r = new StringBuffer(n);
//
//        for (int i = 0; i < n; i++) {
//
//            // take a random value between 97 and 122
//            int nextRandomChar = lowerLimit
//                    + (int) (random.nextFloat()
//                    * (upperLimit - lowerLimit + 1));
//
//            // append a character at the end of bs
//            r.append((char) nextRandomChar);
//        }
//        System.out.println(r);
//
//        // return the resultant string
//        return r.toString();
//
//    }
//
//    public int[] splitNumber(int number) {
//        int n = 0;
//        int i = 0;
//        int ar[] = new int[10];
//        while (number > 0) {
//            n = number % 10;
//            number = number / 10;
//            ar[i] = n;
//            i++;
//        }
//        return ar;
//    }
//
//    public int getCountryCode(String country) {
//        int code = 0;
//        if (country.equals("UAE"))
//            code = 971;
//        if (country.equals("KSA"))
//            code = 966;
//
//        return code;
//
//    }
//
//    public boolean waitForVisibilityOfElement(WebElement element)
//            throws Throwable {
//        boolean iswaitForVisibilityOfElement = false;
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            iswaitForVisibilityOfElement = true;
//            Utils.logFunctionLevelLogs(iswaitForVisibilityOfElement, "waitForVisibilityOfElement");
//            return true;
//        } catch (Exception e) {
//            Assert.assertTrue(iswaitForVisibilityOfElement, " Element "
//                    + element + " is not visible");
//            return false;
//        }
//    }
//
//    public void clear(String text, WebElement element) {
//        int maxChars1 = text.length();
//        for (int i = 0; i < maxChars1; i++) {
//            element.sendKeys(Keys.BACK_SPACE);
//        }
//    }
//
//    public static void keyBoardEvent(int eventNumber) {
//
//        try {
//
//            Runtime.getRuntime().exec("cmd /C adb shell input keyevent " + eventNumber);
//
//            Thread.sleep(3000);
//
//        } catch (Throwable t) {
//
//            t.printStackTrace();
//        }
//    }
//
//    public boolean slider(WebElement element) throws Throwable {
//        boolean flag = false;
//        try {
//            int x1 = element.getLocation().getX();
//            int y1 = element.getLocation().getY();
//
//            int x2 = x1 / 8;
//            int y2 = y1;
//
//            TouchAction ts = new TouchAction(GlobalVars.driver);
//            ts.press(PointOption.point(x1, y1))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                    .moveTo(PointOption.point(x2, y2)).perform();
//
//            return true;
//        } catch (Exception e) {
//            System.out.println(e);
//            return false;
//        }
//
//    }
//
//    public void verticalSwipe(double startPercentage, double endPercentage, double anchorPercentage) {
//        try {
//            Dimension size;
//            int anchor;
//            int startPoint;
//            int endPoint;
//            if (GlobalVars.driver != null) {
//                size = GlobalVars.driver.manage().window().getSize();
//                anchor = (int) ((double) size.width * anchorPercentage);
//                startPoint = (int) ((double) size.height * startPercentage);
//                endPoint = (int) ((double) size.height * endPercentage);
//                (new TouchAction<>(GlobalVars.driver)).press(PointOption.point(anchor, startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000L))).moveTo(PointOption.point(anchor, endPoint)).release().perform();
//            }
//        } catch (InvalidArgumentException ie) {
//            Reporter.log("Provide Co-Ordinates with in range. The given co-ordinates crossed beyond screen range : " + startPercentage + " : " + endPercentage + " : " + " : " + anchorPercentage);
//        }
//    }
//
//    public void logStepInfo(ExtentTest test, boolean isResult, String stepInfo, int stepNumber) throws IOException, InterruptedException {
//        if (isResult)
//            test.log(Status.PASS, "Step-" + stepNumber + ": " + stepInfo + " | Status: Pass");
//        else
//            test.log(Status.FAIL, "Step-" + stepNumber + ": " + stepInfo + " | Status: Fail");
//    }
//
//    public boolean waitForVisibilityOfElement(WebElement element, String locator)
//            throws Throwable {
//        boolean iswaitForVisibilityOfElement = false;
//        WebDriverWait wait = new WebDriverWait(driver, 20);
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            iswaitForVisibilityOfElement = true;
//            Utils.logFunctionLevelLogs(iswaitForVisibilityOfElement, "waitForVisibilityOfElement");
//            return true;
//        } catch (Exception e) {
//            Assert.assertTrue(iswaitForVisibilityOfElement, " Element "
//                    + locator + " is not visible");
//            return false;
//        }
//    }
//
//    public boolean isEnabled(WebElement element, int timeOutInSsec)
//            throws Throwable {
//        boolean isEnabled = false;
//        try {
//            if (element.isEnabled()) {
//                isEnabled = true;
//            }
//        } catch (Exception e) {
//            isEnabled = false;
//        }
//        return isEnabled;
//    }
//
//    public void clickTextOnScreen(String sName) {
//        String targetCell = "//XCUIElementTypeStaticText[contains(@name,'" + sName + "')]";
//        MobileElement cellWithText = (MobileElement) driver.findElement(By.xpath(targetCell));
//        driver.findElementByAccessibilityId(sName).click();
//        HashMap<String, String> scrollObject = new HashMap<String, String>();
//        scrollObject.put("element", ((RemoteWebElement) cellWithText).getId());
//        scrollObject.put("direction", "down");
//        scrollObject.put("predicateString", "value == '" + sName + "'");
//        scrollObject.put("toVisible", "true");
//        driver.executeScript("mobile:scroll", scrollObject);
//        try {
//            WebElement  element = driver.findElement(By.xpath(targetCell));
//            element.click();
//        } catch (Exception NoSuchElementException) {
//            System.out.println("No Element");
//        }
//
//    }
//
//    public boolean slideByText(String status) throws Throwable {
//        boolean flag = false;
//        String targetCell = "(//XCUIElementTypeStaticText[@name=\"" + status + "\"])[1]";
//        MobileElement element = (MobileElement) driver.findElement(By.xpath(targetCell));
//        try {
//            int x1 = element.getLocation().getX();
//            int y1 = element.getLocation().getY();
//
//            int x2 = x1 / 8;
//            int y2 = y1;
//
//            TouchAction ts = new TouchAction(GlobalVars.driver);
//            ts.press(PointOption.point(x1, y1))
//                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
//                    .moveTo(PointOption.point(x2, y2)).perform();
//
//            return true;
//        } catch (Exception e) {
//            System.out.println(e);
//            return false;
//        }
//
//    }
//
//    public List elementsSearch(String searchID) throws Throwable {
//        List<String> invoiceIDs = new ArrayList<String>();
//        String targetCell = "//*[contains(@name,'" + searchID + "')]";
//        List<MobileElement> elementsOne = (List<MobileElement>) driver.findElements(By.xpath(targetCell));
//        ;
//        for (MobileElement mobileElement : elementsOne) {
//            invoiceIDs.add(mobileElement.getText());
//            System.out.println(mobileElement.getText());
//        }
//        return invoiceIDs;
//    }
//
//    public String findByText(String search) throws Throwable {
//        String count = "";
//        String targetCell = "(//XCUIElementTypeStaticText[@name=\"" + search + "\"])";
//        List<MobileElement> elementsOne = (List<MobileElement>) driver.findElements(By.xpath(targetCell));
//        for (MobileElement mobileElement : elementsOne) {
//            System.out.println(elementsOne.size());
//            count = String.valueOf(elementsOne.size());
//            System.out.println(mobileElement.getText());
//            System.out.println("Element found");
//        }
//        return count;
//    }
//
//    public void clickElements(int num) throws Throwable {
//        boolean flag = false;
//        String targetCell = "//XCUIElementTypeCell//XCUIElementTypeButton";
//        List<MobileElement> elementsOne = (List<MobileElement>) driver.findElements(By.xpath(targetCell));
//
//        System.out.println(elementsOne.size());
//        for (int i = 1; i <= num; i++) {
//            elementsOne.get(i).click();
//            elementsOne = (List<MobileElement>) driver.findElements(By.xpath(targetCell));
//            System.out.println("Clicked");
//            flag = true;
//
//        }
//        //  return flag;
//    }
}




