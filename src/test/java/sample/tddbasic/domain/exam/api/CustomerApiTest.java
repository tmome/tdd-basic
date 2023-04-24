package sample.tddbasic.domain.exam.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import sample.tddbasic.domain.exam.domain.Customer;
import sample.tddbasic.domain.exam.dto.CustomerRequestDto;
import sample.tddbasic.domain.exam.dto.CustomerResponseDto;
import sample.tddbasic.domain.exam.service.CustomerService;
import sample.tddbasic.domain.exam.support.ApiResponseGenerator;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerApi.class)
class CustomerApiTest {


  @MockBean
  private CustomerService customerService;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;


  @Test
  @DisplayName("기본 저장 확인 테스트")
  void basic_save() throws Exception {
    //given
    final var customerRequestDto = CustomerRequestDto.builder()
        .name("cheon")
        .email("effortsof@gmail.com")
        .mobileNumber("000-0000-0000")
        .build();

    final var responseDto = CustomerResponseDto.of(
        Customer.builder().name("cheon")
        .email("effortsof@gamil.com")
        .mobileNumber("000-0000-0000").build());

    when(customerService.save(customerRequestDto)).thenReturn(responseDto);

    final var expected = objectMapper
        .writeValueAsString(ApiResponseGenerator.success(responseDto));

    // when
    final var actual = mockMvc.perform(
            post("/customer")
                .accept(APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(customerRequestDto))
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn()
        .getResponse()
        .getContentAsString();

    // then
    assertThat(actual).isEqualTo(expected);
  }
}