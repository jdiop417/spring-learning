package org.learning.springbootcache.controller;

import lombok.extern.slf4j.Slf4j;
import org.learning.springbootcache.excption.BizException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ExcetpionController {

    @GetMapping("/excp/div")
    public int divExp() {
        return 1 / 0;
    }


    @GetMapping("/excp/biz")
    public int bizExp() {
        if (true) {
            throw new BizException("hh", "gg");
        }
        return 1;
    }


}
