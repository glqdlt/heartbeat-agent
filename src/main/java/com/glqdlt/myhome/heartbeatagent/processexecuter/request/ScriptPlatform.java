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

    String[] getJvmPropertyValue();
}
