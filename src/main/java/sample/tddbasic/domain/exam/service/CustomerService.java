package sample.tddbasic.domain.exam.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.tddbasic.domain.exam.domain.Customer;
import sample.tddbasic.domain.exam.dto.CustomerRequestDto;
import sample.tddbasic.domain.exam.dto.CustomerResponseDto;
import sample.tddbasic.domain.exam.repository.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
  private final CustomerRepository customerRepository;

  //default false 명시적 기입.
  @Transactional(readOnly = false)
  public CustomerResponseDto save(final CustomerRequestDto dto) {
    return CustomerResponseDto.of(customerRepository.save(buildForCustomer(dto)));
  }

  private static Customer buildForCustomer(final CustomerRequestDto dto) {
    return Customer.builder()
        .name(dto.getName())
        .email(dto.getEmail())
        .mobileNumber(dto.getMobileNumber())
        .build();
  }
}
