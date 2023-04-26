package sample.tddbasic.domain.exam.service;

import javax.persistence.EntityNotFoundException;
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


  @Transactional(readOnly = true)
  public CustomerResponseDto findById(final Long id) {
    return CustomerResponseDto.of(customerRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("해당 하는 아이디를 찾을 수 없습니다.")));
  }

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
