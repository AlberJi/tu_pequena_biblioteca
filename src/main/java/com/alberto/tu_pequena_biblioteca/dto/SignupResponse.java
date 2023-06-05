package com.alberto.tu_pequena_biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupResponse {
  private String username;
  private String email;
  private LocalDateTime fechaAlta;
}
