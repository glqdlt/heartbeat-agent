package com.glqdlt.myhome.heartbeatagent.processexecuter.request;

import com.glqdlt.myhome.heartbeatagent.processexecuter.ProcessExecuterError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//FIXME 설계 변경에 따른 테스트 코드 개선 필요
@ExtendWith(MockitoExtension.class)
public class ExecuteRequestTest {

    @Mock
    private ScriptPlatform platform;

    private String path;

    @BeforeEach
    void isTestingThisEnv() throws IOException {
        KnownPlatform[] e = KnownPlatform.values();
        KnownPlatform p = null;
        String resource = null;
        for (KnownPlatform a : e) {
            if (a.checkPlatform()) {
                p = a;
                if (a == KnownPlatform.WINDOW) {
                    resource = "test_batch.bat";
                } else {
                    resource = "test_bash.sh";
                }
            }
        }

        if (p == null) {
            Assertions.fail();
        }
        URL u = ClassLoader.getSystemResource(resource);
        File f = new File(u.getPath());
        ExecuteRequest aa = ExecuteRequest.Builder.build(p, f.getPath());
        Assertions.assertNotNull(aa);
        this.path = f.getPath();
    }

    @Test
    void unknownSysPropTest() {
        Mockito.when(platform.getSysProp()).thenReturn("aa");
        Mockito.when(platform.getName()).thenReturn("test_platform");
        Mockito.when(platform.getScriptExtension()).thenReturn(".bat");
        Assertions.assertEquals("aa", platform.getSysProp());
        boolean eee = platform.checkPlatform();
        Assertions.assertFalse(eee);
        try {
            ExecuteRequest ee = ExecuteRequest.Builder.build(platform, path);
        } catch (ProcessExecuterError ex) {
            Assertions.assertEquals("System is not platform test_platform", ex.getMessage());
        }
    }
}