package com.assqr.gido.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SentenceList {

    @JsonProperty("datas")
    private List<Sentence> sentenceList;

    public List<Sentence> getSentenceList() {
        return sentenceList;
    }

    public void setSentenceList(List<Sentence> sentenceList) {
        this.sentenceList = sentenceList;
    }

}
