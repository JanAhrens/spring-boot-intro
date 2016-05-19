package io.github.janahrens.hellospring;

import io.github.janahrens.hellospring.support.MockLogService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ratpack.test.handling.RequestFixture;

public class HelloWorldHandlerTest {

  private HelloWorldHandler helloWorldHandler;

  private MockLogService mockLogService;

  @Before
  public void setup() {
    mockLogService = new MockLogService();
    helloWorldHandler = new HelloWorldHandler(mockLogService);
  }

  @Test
  public void handleAddsAnEntry() throws Exception {
    Assert.assertEquals(0, mockLogService.addEntryCounter);

    RequestFixture.handle(helloWorldHandler, action -> action.uri("/"));

    Assert.assertEquals(1, mockLogService.addEntryCounter);
  }

}
