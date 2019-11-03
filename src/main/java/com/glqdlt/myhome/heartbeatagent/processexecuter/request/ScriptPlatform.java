package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public interface ScriptPlatform {
    String getScriptExtension();

    String getName();

    Integer getType();

    default String getSysProp() {
        return System.getProperty("os.name").toLowerCase();
    }

    default boolean checkPlatform() {
        final String a = getSysProp();
        for (String val : getJvmPropertyValue()) {
            if (a.contains(val)) {
                return true;
            }
        }
        return false;
    }

    String[] getJvmPropertyValue();
}
