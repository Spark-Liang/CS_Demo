package org.sparkliang.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("dataconsume/{filePath}")
public class DataConsumeController {

    private static final Logger LOG = LoggerFactory.getLogger(DataConsumeController.class);

    @RequestMapping(method = RequestMethod.PUT)
    public boolean init(@PathVariable String filePath, @RequestParam @NotNull String fileType){
        LOG.info("init file:"+filePath);
        return false;
    }

    @RequestMapping(method = RequestMethod.POST,consumes = "application/json")
    public boolean append(
            @PathVariable String filePath, @RequestParam @NotNull String fileType
            ,@RequestBody @NotNull String jsonString
    ){
        LOG.info("get json string:\n"+jsonString);
        return false;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(@PathVariable String filePath){
        LOG.info("get the file path: {}",filePath);
        return filePath;
    }
}
