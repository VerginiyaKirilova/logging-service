package com.logging.controller;

import com.logging.entity.LogEntry;
import com.logging.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public LogEntry createLog(@RequestBody LogEntry logEntry) {
        return logService.saveLog(logEntry);
    }

    public List<LogEntry> getAllLogs(){
        return logService.getAllLogs();
    }
}

