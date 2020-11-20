package com.lwn.exceptiondemo.mapper;

import com.lwn.exceptiondemo.entity.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author lwnlwn987
 */
@Mapper
public interface SubjectMapper extends tk.mybatis.mapper.common.Mapper<Subject> {
}
