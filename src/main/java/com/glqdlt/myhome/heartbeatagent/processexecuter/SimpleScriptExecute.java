package com.glqdlt.myhome.heartbeatagent.processexecuter;

import com.glqdlt.myhome.heartbeatagent.processexecuter.request.ExecuteRequest;

import java.io.File;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class SimpleScriptExecute implements ScriptExecute {
    @Override
    public void execute(ExecuteRequest request) {
        final File script = request.getPath();

    }
}
