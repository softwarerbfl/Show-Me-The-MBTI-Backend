package com.example.mbti.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum MbtiType {
    ENFP("ENFP"),
    ENFJ("ENFJ"),
    ENTP("ENTP"),
    ENTJ("ENTJ"),
    ESFP("ESFP"),
    ESFJ("ESFJ"),
    ESTP("ESTP"),
    ESTJ("ESTJ"),
    INFP("INFP"),
    INFJ("INFJ"),
    INTP("INTP"),
    INTJ("INTJ"),
    ISFP("ISFP"),
    ISFJ("ISFJ"),
    ISTP("ISTP"),
    ISTJ("ISTJ");

    @Getter
    private final String value;

    MbtiType(String value){
        this.value = value;
    }

    @JsonCreator
    public static MbtiType from(String value){
        for(MbtiType type : MbtiType.values()){
            if(type.getValue().equals(value)){
                return type;
            }
        }
        return  null;
    }

    @JsonValue
    public String getValue(){
        return value;
    }
}
