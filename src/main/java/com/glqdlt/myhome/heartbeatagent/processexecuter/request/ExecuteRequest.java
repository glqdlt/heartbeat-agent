package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

import com.glqdlt.myhome.heartbeatagent.processexecuter.ProcessExecuterError;
import com.glqdlt.myhome.heartbeatagent.processexecuter.ScriptNotFoundError;
import com.glqdlt.myhome.heartbeatagent.processexecuter.WrongScriptError;

import java.io.File;
import java.io.IOException;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public abstract class ExecuteRequest {
    private File path;
    private ScriptPlatform platform;

    public abstract String getCommand() throws IOException;

    public ScriptPlatform getPlatform() {
        return platform;
    }

    public File getPath() {
        return path;
    }

    protected ExecuteRequest(File path, ScriptPlatform platform) {
        this.path = path;
        this.platform = platform;
    }

    public static final class MockRequest extends ExecuteRequest {
        private String mockCommand;

        protected MockRequest(File path, ScriptPlatform platform, String command) {
            super(path, platform);
            this.mockCommand = command;
        }

        @Override
        public String getCommand() throws IOException {
            return mockCommand;
        }
    }


    public static class Builder {
        public static ExecuteRequest build(ScriptPlatform platform, String path) {
            final File file = new File(path);
            if (!file.exists()) {
                throw new ScriptNotFoundError(path);
            }
            if (!file.getName().endsWith(platform.getScriptExtension())) {
                throw new WrongScriptError(file.getName(), platform.getName());
            }

            if (!platform.checkPlatform()) {
                throw new ProcessExecuterError(String.format("System is not platform %s", platform.getName()));
            }

            if (platform instanceof KnownPlatform) {
                KnownPlatform p = (KnownPlatform) platform;
                return p.creatRequest(file);
            }
            throw new ProcessExecuterError(String.format("Not Supported platform.. %s", platform.getName()));
        }
    }
}
