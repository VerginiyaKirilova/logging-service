package com.logging.service;

import com.logging.entity.LogEntry;
import com.logging.repository.LogEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    private final LogEntryRepository logEntryRepository;

    @Autowired
    public LogServiceImpl(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    @Override
    public LogEntry saveLog(LogEntry logEntry) {
        return logEntryRepository.save(logEntry);
    }

    @Override
    public List<LogEntry> getAllLogs() {
        return logEntryRepository.findAll();
    }
}
