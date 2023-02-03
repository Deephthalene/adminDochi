package com.vue.dochiAdmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vue.dochiAdmin.mapper.CommentMapper;
import com.vue.dochiAdmin.service.CommentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentMapper commentMapper;
}
