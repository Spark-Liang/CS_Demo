package org.sparkliang.common.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class ExceptionUtils {

    public static String getStackTrace(Throwable exception){
        ByteArrayOutputStream stringBytes = new ByteArrayOutputStream();
        PrintWriter stackTraceWriter = new PrintWriter(stringBytes);
        exception.printStackTrace(stackTraceWriter);
        return stringBytes.toString();
    }
}
