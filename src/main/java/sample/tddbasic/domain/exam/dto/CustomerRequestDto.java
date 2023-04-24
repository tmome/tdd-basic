package sample.tddbasic.domain.exam.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerRequestDto {
  private String name;
  private String email;
  private String mobileNumber;

}
