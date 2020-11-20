package com.lwn.exceptiondemo.service;

import com.lwn.exceptiondemo.entity.Delete;
import com.lwn.exceptiondemo.entity.Query;
import com.lwn.exceptiondemo.entity.Subject;

import java.util.List;

/**
 * @author lwnlwn987
 */
public interface SubjectService {
        /**
         * 新增
         * @param subject
         * @return
         */
        int save(Subject subject);

        /**
         * 查询
         *
         * @param query
         * @return
         */
        List<Subject> query(Query query);

        /**
         * 更新题型
         *
         * @param subject
         * @return
         */
        int update(Subject subject);

        /**
         * 批量删除题型
         *
         * @param delete
         * @return
         */
        int delete(Delete delete);

}
