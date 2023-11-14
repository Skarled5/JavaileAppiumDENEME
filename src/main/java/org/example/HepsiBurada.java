package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;

import static java.lang.Thread.sleep;

public class HepsiBurada {

    public static void main(String[] args) throws MalformedURLException {

        // Appium Sunucusuna Bağlanmak İçin Gerekli Bilgiler
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 4");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\hakan\\IdeaProjects\\Java ile Appium\\apps\\HepsiBurada.apk");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.hepsiburada.ui.startup.SplashActivity"); // apk infodan bulunur detay sayfasından activites kısmında SplashActivity yada MainActivity al
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.pozitron.hepsiburada"); // bu hep böyle
        // son iki satır yeni sürümler otomatik günceller bu daha iyi

        // Appium sunucusuna bağlanma URL'ni oluştur
        try {
            AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),desiredCapabilities); // AndroidDriver<AndroidElement> driver sürücüsü oluşturmaya yarar
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


        MobileElement button = driver.findElement(By.xpath("//android.widget.Button[1]")); // hepsiburada Allow ve Dont Allow kısmında Allow kısmına
        button.click();

        MobileElement search = driver.findElement(By.id("com.pozitron.hepsiburada:id/etSearchBox"));
        search.click();
        search.sendKeys("BioDiamond");