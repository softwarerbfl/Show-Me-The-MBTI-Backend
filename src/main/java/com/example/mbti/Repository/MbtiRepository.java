package com.example.mbti.Repository;

import com.example.mbti.domain.Mbti;
import com.example.mbti.domain.MbtiType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MbtiRepository extends JpaRepository<Mbti, Long> {
    public List<Mbti> findByType(MbtiType type);
}
