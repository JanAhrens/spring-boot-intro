package io.github.janahrens.hellospring.support;

import io.github.janahrens.hellospring.LogService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public class MockLogService implements LogService {
  @Override
  public List<Map<String, Object>> getEntries() {
    return null;
  }

  @Override
  public void addEntry(Timestamp time) {
    addEntryCounter++;
  }

  public int addEntryCounter = 0;
}