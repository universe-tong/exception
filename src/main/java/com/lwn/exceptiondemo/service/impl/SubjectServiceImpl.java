package com.lwn.exceptiondemo.service.impl;

import com.lwn.exceptiondemo.entity.Delete;
import com.lwn.exceptiondemo.entity.Query;
import com.lwn.exceptiondemo.entity.Subject;
import com.lwn.exceptiondemo.exception.code.impl.CommonEnum;
import com.lwn.exceptiondemo.exception.type.MyException;
import com.lwn.exceptiondemo.mapper.SubjectMapper;
import com.lwn.exceptiondemo.service.SubjectService;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SubjectServiceImpl implements SubjectService {

    @Resource
    SubjectMapper subjectMapper;
    @Override
    public int save(Subject subject) {
        try{
            return subjectMapper.insertSelective(subject);
        }  catch (Exception e){
            throw new MyException(CommonEnum.INSERT_EXCEPTION.getCode(),CommonEnum.INSERT_EXCEPTION.getMessage(),e);
        }
    }

    @Override
    public List<Subject> query(Query query) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name", "%" + query.getName() + "%");
        List<Subject> subjects = null;
        try{
            subjects = subjectMapper.selectByExample(example);
            if(subjects != null){
                return subjects;
            }
        } catch (Exception e){
            throw new MyException(CommonEnum.SELECT_EXCEPTION.getCode(),CommonEnum.SELECT_EXCEPTION.getMessage(),e);
        }
        return null;
    }

    @Override
    public int update(Subject subject) {
        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", subject.getId());
        try {
            return subjectMapper.updateByExampleSelective(subject,example);
        }catch (Exception e){
            throw new MyException(CommonEnum.UPDATE_EXCEPTION.getCode(),CommonEnum.UPDATE_EXCEPTION.getMessage(),e);
        }
    }

    @Override
    public int delete(Delete delete) {

        Example example = new Example(Subject.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id", delete.getId());
        example.or(criteria);
        try{
            return subjectMapper.deleteByExample(example);
        } catch (Exception e){
            throw new MyException(CommonEnum.DELETE_EXCEPTION.getCode(),CommonEnum.DELETE_EXCEPTION.getMessage(),e);
        }
    }
}
