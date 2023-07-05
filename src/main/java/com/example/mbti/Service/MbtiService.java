package com.example.mbti.Service;

import com.example.mbti.Repository.MbtiRepository;
import com.example.mbti.domain.Mbti;
import com.example.mbti.domain.MbtiType;
import com.example.mbti.dto.MbtiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MbtiService {
    private final MbtiRepository mbtiRepository;

    /**
     * 모든 MBTI 정보 불러옴
     */
    public List<Mbti> findAll(){
        return mbtiRepository.findAll();
    }

    /**
     * 입력받은 mbti에 해당하는 info중에서 랜덤으로 하나를 선택
     */
    public Mbti findByMbti(MbtiType type){
        List<Mbti> mbtiList = mbtiRepository.findByType(type);
        int len = mbtiList.size();
        int rand = (int)((Math.random())*len); //랜덤 값 뽑기
        return mbtiList.get(rand);
    }

    /**
     * 입력받은 MBTI 정보 저장
     */
    public void save(MbtiDto dto){
        // 저장할 MBTI객체 생성
        Mbti mbti = new Mbti();
        mbti.setType(MbtiType.from(dto.getType().toUpperCase()));
        mbti.setInfo(dto.getInfo());

        mbtiRepository.save(mbti);
    }

    /**
     * id에 해당하는 MBTI 정보 삭제
     */
    public void delete(Long id){
        mbtiRepository.deleteById(id);
    }

}
