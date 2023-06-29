package com.example.mbti.dto;

import com.example.mbti.domain.MbtiType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MbtiDto {
    String type;
    String info;
}
