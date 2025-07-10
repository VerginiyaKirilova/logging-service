package com.logging.service;

import com.logging.entity.LogEntry;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LogService {

    LogEntry saveLog(LogEntry logEntry);
    List<LogEntry> getAllLogs();
}
