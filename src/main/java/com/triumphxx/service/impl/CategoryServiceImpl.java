package com.triumphxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.triumphxx.entity.Category;
import com.triumphxx.mapper.CategoryMapper;
import com.triumphxx.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-10
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
