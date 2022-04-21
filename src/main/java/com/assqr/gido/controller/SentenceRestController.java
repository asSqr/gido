package com.assqr.gido.controller;

import com.assqr.gido.domain.SentenceList;
import com.assqr.gido.service.SentenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sentences")
public class SentenceRestController {

    private static final Logger logger = LoggerFactory.getLogger(SentenceRestController.class);

    private final SentenceService service;

    public SentenceRestController(SentenceService service) {
        this.service = service;
    }

    @GetMapping(path = "", produces = "application/json")
    public SentenceList find(@RequestParam(name = "text", required = false) String text,
                             @RequestParam(name = "author", required = false) String author) {
        return this.service.find(text, author);
    }

}
