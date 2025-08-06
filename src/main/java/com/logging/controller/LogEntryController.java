package com.logging.controller;

import com.logging.dto.LogRequest;
import com.logging.entity.LogEntry;
import com.logging.repository.LogEntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/logs")
public class LogEntryController {

    private final LogEntryRepository logEntryRepository;

    public LogEntryController(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @PostMapping
    public ResponseEntity<Void> createLog(@RequestBody LogRequest request) {
        LogEntry logEntry = new LogEntry();
        logEntry.setUsername(request.getUsername());
        logEntry.setMessage(request.getMessage());
        logEntry.setAction(request.getAction());
        logEntry.setTimestamp(LocalDateTime.now());
        System.out.println(">> Saving log: " + logEntry);
        logEntryRepository.save(logEntry);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<?> getAllLogs() {
        return ResponseEntity.ok(logEntryRepository.findAll());
    }
}