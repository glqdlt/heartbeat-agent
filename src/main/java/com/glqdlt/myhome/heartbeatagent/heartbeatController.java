package com.glqdlt.myhome.heartbeatagent;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Date 2019-11-03
 *
 * @author glqdlt
 */
@RestController
public class heartbeatController {

    @GetMapping("/api/v1/system/power/shutdown")
    public void getShutdown(@RequestParam(required = false) Integer afterSeconds) {
        Integer seconds = Optional.ofNullable(afterSeconds).orElse(0);


    }
}
