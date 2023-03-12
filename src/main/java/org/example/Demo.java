package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class Demo {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://developer.mastercard.com/mastercard-id-assist/documentation/api-reference/");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept Cookies")).click();
        }
    }
}