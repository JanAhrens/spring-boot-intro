package io.github.janahrens.hellospring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Example01Application.class)
@ActiveProfiles("test")
public class DatabaseServiceTest {

  @Autowired
  private JdbcTemplate jdbcTemplate;


  @Autowired
  private DatabaseService databaseService;

  @Before
  public void setup() {
    jdbcTemplate.execute("DELETE FROM counter");
  }

  @Test
  public void listEmpty() {
    List entries = databaseService.getEntries();

    assertEquals(0, entries.size());
  }

  @Test
  public void addEntry() {
    databaseService.addEntry(Timestamp.valueOf("2016-05-19 03:00:00"));

    List entries = databaseService.getEntries();
    assertEquals(1, entries.size());
  }

}
