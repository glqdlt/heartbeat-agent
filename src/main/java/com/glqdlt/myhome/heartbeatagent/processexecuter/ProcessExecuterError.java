package com.glqdlt.myhome.heartbeatagent.processexecuter;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class ProcessExecuterError extends RuntimeException {
    public ProcessExecuterError(String message) {
        super(message);
    }

    public ProcessExecuterError(String message, Throwable cause) {
        super(message, cause);
    }
}
