package com.example.mbti.controller;

import com.example.mbti.Service.MbtiService;
import com.example.mbti.domain.Mbti;
import com.example.mbti.domain.MbtiType;
import com.example.mbti.dto.DeleteMbtiDto;
import com.example.mbti.dto.MbtiDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MbtiController {
    private final MbtiService mbtiService;

    @GetMapping("/mbti")
    public List<Mbti> findAll() {
        List<Mbti> mbtiList = mbtiService.findAll();
        return mbtiList;
    }

    @GetMapping("/mbti/{type}")
    public MbtiDto findByMbti(@PathVariable String type) {
        Mbti mbti = mbtiService.findByMbti(MbtiType.from(type));
        MbtiDto dto = new MbtiDto(type, mbti.getInfo());
        return dto;
    }

    @PostMapping("/mbti")
    public void save (@RequestBody MbtiDto dto) {
        mbtiService.save(dto);
    }

    @DeleteMapping("/mbti")
    public void delete(@RequestBody DeleteMbtiDto dto){
        mbtiService.delete(dto.getId());
    }
}
