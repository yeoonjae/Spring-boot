package com.infren.study.demowebmvc;

import static org.junit.jupiter.api.condition.OS.LINUX;
import static org.junit.jupiter.api.condition.OS.MAC;
import static org.junit.jupiter.api.condition.OS.WINDOWS;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;

public class JunitOsTest {

    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        System.out.println("MAC");
    }

    @TestOnMac
    void testOnMac() {
        System.out.println("testOnMac");
    }

    @Test
    @EnabledOnOs({ LINUX, MAC, WINDOWS})
    void onLinuxOrMacOrWindow() {
        System.out.println("LINUX, MAC, WINDOWS");
    }

    @Test
    @DisabledOnOs(WINDOWS)
    void notOnWindows() {
        System.out.println("WINDOWS");
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @Test
    @EnabledOnOs(MAC)
    @interface TestOnMac {
    }
}
