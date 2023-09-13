package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from sky_take_out.dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);
   @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);


    //根据主键查询菜品
    @Select("select *from sky_take_out.dish where id=#{id}")
    Dish getById(Long id);
    //根据主键删除菜品数据
    @Delete("delete from sky_take_out.dish where id=#{id}")
    void deleteById(Long id);

    //根据id动态修改菜品数据
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);

    /**
     * 动态条件查询菜品
     * @param dish
     * @return
     */
    List<Dish> list(Dish dish);

}
