package com.lagou.edu.service.impl;

import com.lagou.edu.mapper.UserDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iUserService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<Resume> getUserList() {
        List<Resume> resumes = userDao.findAll();
        return resumes;
    }


    @Override
    public Resume getUserById(long userId) {
        Resume resume = userDao.findOne(userId);
        return resume;
    }

    @Override
    public void addUser(Resume resume) {
        userDao.save(resume);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }
}
