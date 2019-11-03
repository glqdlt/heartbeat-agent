package com.glqdlt.myhome.heartbeatagent.processexecuter;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class WrongScriptError extends ProcessExecuteCodeError {
    public WrongScriptError(String name, String platformName) {
        super(String.format("file '%s' is not '%s' platform script", name, platformName));
    }

    @Override
    public String getCode() {
        return "PES002";
    }
}
