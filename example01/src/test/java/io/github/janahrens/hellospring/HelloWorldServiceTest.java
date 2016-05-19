package io.github.janahrens.hellospring;

import io.github.janahrens.hellospring.support.MockLogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ratpack.test.handling.RequestFixture;

public class HelloWorldServiceTest {

  private HelloWorldService helloWorldService;

  private MockLogService mockLogService;

  @Before
  public void setup() {
    mockLogService = new MockLogService();
    helloWorldService = new HelloWorldService(mockLogService);
  }

  @Test
  public void handleAddsAnEntry() throws Exception {
    Assert.assertEquals(0, mockLogService.addEntryCounter);

    RequestFixture.handle(helloWorldService, action -> action.uri("/"));

    Assert.assertEquals(1, mockLogService.addEntryCounter);
  }

}
