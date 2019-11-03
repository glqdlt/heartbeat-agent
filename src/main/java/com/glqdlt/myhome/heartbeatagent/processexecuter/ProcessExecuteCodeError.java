package com.glqdlt.myhome.heartbeatagent.processexecuter;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public abstract class ProcessExecuteCodeError extends ProcessExecuterError {

    public abstract String getCode();

    public ProcessExecuteCodeError(String message) {
        super(message);
    }

    public ProcessExecuteCodeError(String message, Throwable cause) {
        super(message, cause);
    }
}
