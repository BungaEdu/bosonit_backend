package com.example.block5logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Logger log = LoggerFactory.getLogger(Controller.class);
    @RequestMapping("/")
    public String logs(){
        log.trace("Mensaje TRACE");
        log.debug("Mensaje DEBUG");
        log.info("Mensaje INFO");
        log.warn("Mensaje WARNING");
        log.error("Mensaje ERROR");

        return "Ejercicio bloque 5 logging. Mira los logs";
    }
}