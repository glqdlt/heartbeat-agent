package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

import java.io.File;
import java.io.IOException;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public enum KnownPlatform implements ScriptPlatform {

    WINDOW(".bat", "win") {
        @Override
        public ExecuteRequest creatRequest(File file) {
            return new WindowRequest(file);
        }
    },
    MAC(".sh", "mac") {
        @Override
        public ExecuteRequest creatRequest(File file) {
            return new MacRequest(file);
        }
    },
    LINUX(".sh", "unix", "linux") {
        @Override
        public ExecuteRequest creatRequest(File file) {
            return new LinuxRequest(file);
        }
    };

    private String[] prop;

    KnownPlatform(String scriptExtension, String... prop) {
        this.prop = prop;
        this.scriptExtension = scriptExtension;
    }

    public String getScriptExtension() {
        return scriptExtension;
    }

    @Override
    public String getName() {
        return this.name();
    }

    @Override
    public Integer getType() {
        return this.ordinal();
    }

    @Override
    public String[] getJvmPropertyValue() {
        return this.prop;
    }

    private String scriptExtension;

    public abstract ExecuteRequest creatRequest(File file);

    private static class MacRequest extends ExecuteRequest {

        private MacRequest(File path) {
            super(path, KnownPlatform.MAC);
        }

        @Override
        public String getCommand() throws IOException {
            return "sh " + getPath().getCanonicalPath();
        }
    }

    private static class WindowRequest extends ExecuteRequest {

        private WindowRequest(File path) {
            super(path, KnownPlatform.WINDOW);
        }

        @Override
        public String getCommand() throws IOException {
            return getPath().getCanonicalPath();
        }
    }

    private static class LinuxRequest extends ExecuteRequest {

        private LinuxRequest(File path) {
            super(path, KnownPlatform.LINUX);
        }

        @Override
        public String getCommand() throws IOException {
            return "sh " + getPath().getCanonicalPath();
        }
    }
}
