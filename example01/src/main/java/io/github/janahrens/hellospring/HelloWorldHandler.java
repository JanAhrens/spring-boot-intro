package io.github.janahrens.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ratpack.handling.Context;
import ratpack.handling.Handler;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class HelloWorldHandler implements Handler {

  private final LogService logService;

  @Autowired
  public HelloWorldHandler(LogService logService) {
    this.logService = logService;
  }

  @Override
  public void handle(Context ctx) throws Exception {
    logService.addEntry(new Timestamp(new Date().getTime()));
    ctx.render("Hello World.");
  }

}
