package sample.tddbasic.domain.exam.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.tddbasic.domain.exam.dto.CustomerRequestDto;
import sample.tddbasic.domain.exam.dto.CustomerResponseDto;
import sample.tddbasic.domain.exam.service.CustomerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerApi {

  private final CustomerService customerService;

  @GetMapping
  public CustomerResponseDto examCall(final CustomerRequestDto dto) {
    return null;
  }
}
