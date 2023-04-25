package sample.tddbasic.domain.exam.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.tddbasic.domain.exam.dto.CustomerRequestDto;
import sample.tddbasic.domain.exam.dto.CustomerResponseDto;
import sample.tddbasic.domain.exam.service.CustomerService;
import sample.tddbasic.domain.exam.support.ApiResponse;
import sample.tddbasic.domain.exam.support.ApiResponseGenerator;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerApi {

  private final CustomerService customerService;

  @PostMapping
  public ApiResponse<CustomerResponseDto> save(final @RequestBody CustomerRequestDto dto) {
    return ApiResponseGenerator.success(customerService.save(dto));
  }
}
