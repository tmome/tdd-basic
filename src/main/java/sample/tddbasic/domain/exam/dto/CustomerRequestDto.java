package sample.tddbasic.domain.exam.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequestDto {
  private String name;
  private String email;
  private String mobileNumber;

  @Builder
  public CustomerRequestDto(String name, String email, String mobileNumber) {
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }
}
