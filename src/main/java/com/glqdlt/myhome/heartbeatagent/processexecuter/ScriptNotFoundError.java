package com.glqdlt.myhome.heartbeatagent.processexecuter;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class ScriptNotFoundError extends ProcessExecuteCodeError {
    public ScriptNotFoundError(String path) {
        super(String.format("'%s' File is not exists", path));
    }

    @Override
    public String getCode() {
        return "PES001";
    }
}
