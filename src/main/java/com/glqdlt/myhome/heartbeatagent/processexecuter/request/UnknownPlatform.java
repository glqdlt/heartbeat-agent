package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

import com.glqdlt.myhome.heartbeatagent.processexecuter.PlatformCreateError;

import java.util.stream.Stream;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
public class UnknownPlatform implements ScriptPlatform {
    private String name;
    private String extension;
    private Integer type;
    private String values;

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setType(Integer type) {
        boolean y = Stream.of(KnownPlatform.values()).map(KnownPlatform::getType)
                .noneMatch(x -> x.equals(type));
        if (y) {
            this.type = type;
        } else {
            throw new PlatformCreateError(String.format("이미 존재하는 플랫폼 입니다. 당신의 입력 : %s", type));
        }
    }

    @Override
    public String getScriptExtension() {
        return extension;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getType() {
        return type;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String[] getJvmPropertyValue() {
        return values.split(",");
    }
}
