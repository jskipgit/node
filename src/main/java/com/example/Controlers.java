package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jasonskipper on 2/27/17.
 */
@RestController
public class Controlers {

    @RequestMapping(path = "/")
    public Data doEcho(HttpServletRequest req) throws Exception {
        Data tmp = new Data(req);
        return tmp;
    }
}
