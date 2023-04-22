package sample.tddbasic.domain.exam.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exam")
public class examApi {

  @GetMapping
  public String examCall(final String value) {
    return value;
  }
}
