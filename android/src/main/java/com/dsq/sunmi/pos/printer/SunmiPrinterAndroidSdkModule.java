// SunmiPrinterAndroidSdkModule.java

package com.dsq.sunmi.pos.printer;

import com.dsq.sunmi.pos.printer.utils.SunmiPrintHelper;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;

public class SunmiPrinterAndroidSdkModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public SunmiPrinterAndroidSdkModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        SunmiPrintHelper.getInstance().initSunmiPrinterService(reactContext);
    }
    @ReactMethod
    public void printSunmiPrinter(String imageUrl, ReadableArray firstRegularHeader, ReadableArray boldHeader, ReadableArray secondRegularHeader, ReadableArray contentRows, ReadableArray footerData, String qrUrl, String qrDisclaimer, ReadableArray boldLineIndicesArray, ReadableArray sectionSizesArray) {
        String[] firstRegularHead = parseReadableArray(firstRegularHeader);
        String[] boldHead = parseReadableArray(boldHeader);
        String[] secondRegularHead = parseReadableArray(secondRegularHeader);
        String[] rows = parseReadableArray(contentRows);
        String[] footer = parseReadableArray(footerData);
        int[] boldLineIndices = parseIntArray(boldLineIndicesArray);
        int[] sectionSizes = parseIntArray(sectionSizesArray);

        SunmiPrintHelper.getInstance().printDsq(imageUrl, firstRegularHead, boldHead, secondRegularHead, rows, footer, qrUrl, qrDisclaimer, boldLineIndices, sectionSizes);
    }

    private String[] parseReadableArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        String[] array = new String[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            array[i] = readableArray.getString(i);
        }
        return array;
    }

    private int[] parseIntArray(ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        int[] array = new int[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            array[i] = readableArray.getInt(i);
        }
        return array;
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
