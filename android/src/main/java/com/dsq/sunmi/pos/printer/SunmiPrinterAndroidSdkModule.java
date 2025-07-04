// SunmiPrinterAndroidSdkModule.java

package com.dsq.sunmi.pos.printer;

import com.dsq.sunmi.pos.printer.utils.SunmiPrintHelper;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class SunmiPrinterAndroidSdkModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public SunmiPrinterAndroidSdkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        SunmiPrintHelper.getInstance().initSunmiPrinterService(reactContext);
    }
    @ReactMethod
    public static void printSunmiPrinter(String name, String branch, String merchant, String transactionType, String dateTime, String thankYou, String thisIsAcopy, String transactionId, String walletCode, String value, String points, String imageUrl) {
        
        SunmiPrintHelper.getInstance().printDsq(name, branch, merchant, transactionType, dateTime, thankYou, thisIsAcopy, transactionId, walletCode, value, points, imageUrl);
    }

    @Override
    public String getName() {
        return "SunmiPrinterAndroidSdk";
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }


}
