package com.lagou.edu.service;

import com.lagou.edu.pojo.Resume;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IUserService {

    List<Resume> getUserList();

    Resume getUserById(long userId);

    void addUser(Resume resume);

    void deleteUser(Long id);
}
