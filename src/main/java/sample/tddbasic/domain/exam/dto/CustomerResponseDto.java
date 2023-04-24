package sample.tddbasic.domain.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.tddbasic.domain.exam.domain.Customer;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponseDto {
  private Long id;
  private String name;
  private String email;
  private String mobileNumber;

  @Builder
  public CustomerResponseDto(
      String name,
      String email,
      String mobileNumber
  ) {
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }

  @Builder
  public static CustomerResponseDto of(final Customer customer) {
    return CustomerResponseDto.builder()
        .name(customer.getName())
        .email(customer.getEmail())
        .mobileNumber(customer.getMobileNumber())
        .build();
  }
}
