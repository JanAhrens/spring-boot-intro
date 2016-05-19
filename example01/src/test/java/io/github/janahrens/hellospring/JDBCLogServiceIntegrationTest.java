package io.github.janahrens.hellospring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Example01Application.class)
@ActiveProfiles("test")
public class JDBCLogServiceIntegrationTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JdbcLogService logService;

  @Before
  public void setup() {
    jdbcTemplate.execute("DELETE FROM counter");
  }

  @Test
  public void listEmpty() {
    List entries = logService.getEntries();

    assertEquals(0, entries.size());
  }

  @Test
  public void addEntryAddsAnEntry() {
    logService.addEntry(Timestamp.valueOf("2016-05-19 03:00:00"));

    List entries = logService.getEntries();
    assertEquals(1, entries.size());
  }

}
