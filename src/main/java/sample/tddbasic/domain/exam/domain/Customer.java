package sample.tddbasic.domain.exam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "customer")
@NoArgsConstructor
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "mobile_number", nullable = false)
  private String mobileNumber;

  @Builder
  public Customer(String name, String email, String mobileNumber) {
    this.name = name;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }

}
