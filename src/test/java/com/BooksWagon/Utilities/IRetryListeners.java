package com.BooksWagon.Utilities;

import org.testng.IRetryAnalyzer;


import org.testng.ITestResult;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryListeners implements IRetryAnalyzer {

    int Counter = 0; 
    private int retryLimit =1;

    @Override
    public boolean retry(ITestResult result) {
        if (Counter < retryLimit) {
            System.out.println("Retrying test: " + result.getName() + " for the " + (Counter + 1) + " time.");
            Counter++;
            return true;
        }
        return false;
    }

}