package org.example;

import com.microsoft.playwright.*;

public class Demo2 {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            BrowserType chromium = playwright.chromium();
            // Make sure to run headed.
            Browser browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false));
            // Setup context however you like.
            BrowserContext context = browser.newContext(/* pass any options */);
            context.route("**/*", route -> route.resume());
            // Pause the page, and start recording manually.
            Page page = context.newPage();
            page.pause();
        }
    }
}