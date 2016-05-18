package io.github.janahrens.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class DatabaseService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @PostConstruct
  public void init() {
    jdbcTemplate.execute("DROP TABLE counter");
    // poor mans migration mechanism
    jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS counter(id VARCHAR(36), created_at TIMESTAMP)");
  }

  public List<Map<String, Object>> getEntries() {
    return jdbcTemplate.queryForList("SELECT id, created_at FROM counter");
  }

  public void addEntry(Timestamp time) {
    jdbcTemplate.execute("INSERT INTO counter VALUES(?, ?)", (PreparedStatement ps) -> {
      ps.setString(1, UUID.randomUUID().toString());
      ps.setTimestamp(2, time);
      return ps.executeUpdate();
    });
  }

}
