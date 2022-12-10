package org.utils;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.reporting.Reporter;

public class Listener implements ITestListener {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void onTestSuccess(ITestResult result){
        Reporter.info("Test: " + result.getName() + ANSI_GREEN + " [PASSED]" + ANSI_RESET);
    }

    @Override
    public void onTestFailure(ITestResult result){
        Reporter.info("Test: " + result.getName() + ANSI_RED + " [FAILED]" + ANSI_RESET);
    }
}
