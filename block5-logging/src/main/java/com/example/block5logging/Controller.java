package com.example.block5logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger logger = LoggerFactory.getLogger(Controller.class);


    @Autowired
    public String index() {
        logger.trace("Mensaje a nivel de TRACE");
        logger.debug("Mensaje a nivel de DEBUG");
        logger.info("Mensaje a nivel de INFO");
        logger.warn("Mensaje a nivel de WARNING");
        logger.error("Mensaje a nivel de ERROR");

        return "Hola! Mira los logs para ver los resultados";
    }
}
