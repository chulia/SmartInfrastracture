package com.june.cache;

import org.springframework.stereotype.Component;

@Component
public class CachedAutoIncrementId {

//    private SequenceMapper sequenceMapper;

    long getNextId(String bizKey) {
        return 1L;
    }

}
