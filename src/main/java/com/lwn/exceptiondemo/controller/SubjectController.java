package com.lwn.exceptiondemo.controller;

import com.lwn.exceptiondemo.entity.Delete;
import com.lwn.exceptiondemo.entity.Query;
import com.lwn.exceptiondemo.entity.Subject;
import com.lwn.exceptiondemo.exception.code.impl.CommonEnum;
import com.lwn.exceptiondemo.exception.common.CommonRequest;
import com.lwn.exceptiondemo.exception.common.CommonResponse;
import com.lwn.exceptiondemo.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lwnlwn987
 */
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @PostMapping("/add")
    public CommonResponse save(@RequestBody @Valid CommonRequest<Subject> commonRequest){
        subjectService.save(commonRequest.getData());
        return CommonResponse.ok(commonRequest.getData(),"添加成功", CommonEnum.SUCCESS.getCode());
    }

    @PostMapping("/query")
    public CommonResponse query(@RequestBody @Valid CommonRequest<Query> commonRequest){
        List<Subject> subjects = subjectService.query(commonRequest.getData());
        return CommonResponse.ok(subjects,"查询成功",CommonEnum.SUCCESS.getCode());
    }

    @PostMapping("/update")
    public CommonResponse update(@RequestBody @Valid CommonRequest<Subject> commonRequest){
        subjectService.update(commonRequest.getData());
        return CommonResponse.ok(CommonEnum.SUCCESS.getCode(),"修改成功");
    }

    @PostMapping("/delete")
    public CommonResponse delete(@RequestBody @Valid CommonRequest<Delete> commonRequest){
        subjectService.delete(commonRequest.getData());
        return CommonResponse.ok(CommonEnum.SUCCESS.getCode(),"删除成功");
    }




}
