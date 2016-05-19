package io.github.janahrens.hellospring;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

public interface LogService {

  List<Map<String, Object>> getEntries();

  void addEntry(Timestamp time);

}
