package com.glqdlt.myhome.heartbeatagent.processexecuter;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class PlatformCreateError extends ProcessExecuteCodeError {
    public PlatformCreateError(String message) {
        super(message);
    }

    @Override
    public String getCode() {
        return "PEP001";
    }
}
