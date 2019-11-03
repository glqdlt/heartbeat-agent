package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public enum KnownPlatform implements ScriptPlatform {
    WINDOW(".bat", "win"),
    MAC(".sh", "mac"),
    LINUX(".sh", "unix", "linux");

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
}
