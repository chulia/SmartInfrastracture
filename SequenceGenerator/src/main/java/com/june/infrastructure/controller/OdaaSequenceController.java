package com.june.infrastructure.controller;

import com.alibaba.fastjson.JSON;
import com.june.domain.mapper.OdaaSequenceMapper;
import com.june.domain.model.OdaaSequence;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/OdaaSequence")
public class OdaaSequenceController {

    @Autowired
    private OdaaSequenceMapper sequenceMapper;

    @GetMapping("/get")
    @ResponseBody
    public OdaaSequence get(@RequestParam String bizKey){
        OdaaSequence sequence = sequenceMapper.selectByPrimaryKey(bizKey);
        System.out.println(JSON.toJSONString(sequence));
        return sequence;
    }
}
