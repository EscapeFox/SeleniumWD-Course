package ru.stqa.training.selenium;

import io.cucumber.java8.En;
import ru.stqa.training.selenium.app.Application;

public class CucumberTestBase implements En {
    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    public CucumberTestBase(){
        Before(() -> {
            if(tlApp.get() != null){
                app = tlApp.get();
                return;
        }
            app = new Application();
            tlApp.set(app);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {app.quit();app = null;}));
        });
    }

}
