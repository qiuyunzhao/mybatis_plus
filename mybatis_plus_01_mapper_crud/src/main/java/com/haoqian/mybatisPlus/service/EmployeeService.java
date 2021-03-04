package com.haoqian.mybatisPlus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haoqian.mybatisPlus.entity.Employee;
import com.haoqian.mybatisPlus.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Mapper CRUD 接口的方法测试
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * =================================================== 增 ======================================================
     */

    public int insert(Employee employee) {
        System.out.println("--->employee:" + employee);    // 属性值为空的属性不拼入SQL
        int affectedNum = employeeMapper.insert(employee); // 返回受影响的记录数
        System.out.println("<---employee:" + employee);    // 主键默认回写
        return affectedNum;
    }

    /**
     * =================================================== 删 ======================================================
     */

    /**
     * 根据条件删除，deleteWrapper若为空则删除整个表
     */
    public int delete(Integer id) {
        // 删除条件
        UpdateWrapper<Employee> deleteWrapper = new UpdateWrapper<>();
        deleteWrapper.gt("id", id); // where条件 id>?

        int affectedNum = employeeMapper.delete(deleteWrapper); // 返回受影响的记录数
        return affectedNum;
    }

    public int deleteById(Integer id) {
        System.out.println("--->删除的id:" + id);
        int affectedNum = employeeMapper.deleteById(id); // 一定要加
        return affectedNum;
    }

    /**
     * 根据 Map 中封装的条件进行删除。
     * 条件Map的key是数据库字段名，使用对象属性名会报错；
     * 条件Map的value不能是数组
     *
     * @param columnConditionMap where子句条件
     * @return 受影响的记录数
     */
    public Integer deleteByMap(Map<String, Object> columnConditionMap) {
        System.out.println("删除条件columnConditionMap " + columnConditionMap);
        return employeeMapper.deleteByMap(columnConditionMap);
    }

    /**
     * 根据多个id的集合批量删除
     */
    public Integer deleteBatchIds(List<Integer> ids) {
        System.out.println("删除ids " + ids);
        return employeeMapper.deleteBatchIds(ids);
    }

    /**
     * =================================================== 改 ======================================================
     */

    public int updateById(Employee employee) {
        System.out.println("--->employee:" + employee);        // 属性值为空的属性不拼入SQL
        int affectedNum = employeeMapper.updateById(employee); // 返回受影响的记录数
        return affectedNum;
    }

    // 根据条件更新
    public int update(Employee employee) {
        System.out.println("--->employee:" + employee);
        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper
                // 查询条件
                .likeRight("last_name", "demo")
                .eq("last_name", "demoData") // where条件
                .or()
                .eq("id", employee.getId());     // where条件
        return employeeMapper.update(employee, updateWrapper); // 返回受影响的记录数
    }

    /**
     * =================================================== 查 ======================================================
     */

    public Employee selectById(Integer id) {
        return employeeMapper.selectById(id);
    }

    /**
     * 条件查询
     *
     * @param employee 查询条件
     */
    public Employee selectOne(Employee employee) {
        // 封装查询条件
        QueryWrapper<Employee> wrapper = Wrappers.query();
        wrapper.eq(null != employee.getLastName(), "last_name", employee.getLastName());
        wrapper.ne(null != employee.getGender(), "gender", employee.getGender());

        return employeeMapper.selectOne(wrapper);
    }

    /**
     * 根据多个id查询
     *
     * @param ids 封装所查询id的集合
     */
    public List<Employee> selectBatchIds(List<Integer> ids) {
        return employeeMapper.selectBatchIds(ids);
    }

    /**
     * 查询多条记录
     * 查询到的每条记录封装在 Employee中
     */
    public List<Employee> selectList(Employee employee) {
        // queryWrapper ！= null 查询满足条件的全部记录
        QueryWrapper<Employee> wrapper = Wrappers.query();
        wrapper.eq(null != employee.getLastName(), "last_name", employee.getLastName());
        wrapper.ne(null != employee.getGender(), "gender", employee.getGender());
        return employeeMapper.selectList(wrapper);

        // queryWrapper = null 查询全部记录
        // return employeeMapper.selectList(null);
    }

    /**
     * 条件查询
     *
     * @param columnConditionMap 封装数据库字段的查询条件map
     */
    public List<Employee> selectByMap(Map<String, Object> columnConditionMap) {
        System.out.println("查询条件columnConditionMap " + columnConditionMap);
        return employeeMapper.selectByMap(columnConditionMap);
    }

    /**
     * 查询多条记录
     * 查询到的每条记录封装在 Map<String, Object> 中
     * wrapper可以为空
     */
    public List<Map<String, Object>> selectMaps(Employee employee) {
        // queryWrapper ！= null 查询满足条件的全部记录
        QueryWrapper<Employee> wrapper = Wrappers.query();
        wrapper.eq(null != employee.getLastName(), "last_name", employee.getLastName());
        wrapper.ne(null != employee.getGender(), "gender", employee.getGender());

        return employeeMapper.selectMaps(wrapper);
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * 注意： 只返回第一个字段的值(一般第一个值为主键id)
     * wrapper可以为空
     */
    public List<Object> selectObjs(Employee employee) {
        // queryWrapper ！= null 查询满足条件的全部记录
        QueryWrapper<Employee> wrapper = Wrappers.query();
        wrapper.eq(null != employee.getLastName(), "last_name", employee.getLastName());
        wrapper.ne(null != employee.getGender(), "gender", employee.getGender());

        return employeeMapper.selectObjs(wrapper);
    }

    /**
     * 分页查询
     * 查询到的每条数据库记录分别封装在 Employee
     */
    public Page<Employee> selectPage(Integer currentPage, Integer pageSize) {
        Page<Employee> page = new Page<>(currentPage, pageSize, true);
        employeeMapper.selectPage(page, null); // 分页查询结果封装在page中
        return page;
    }

    /**
     * 分页查询
     * 查询到的每条数据库记录分别封装在 Map<String, Object>
     */
    public Page<Map<String, Object>> selectMapsPage(Integer currentPage, Integer pageSize) {
        Page<Map<String, Object>> page = new Page<>(currentPage, pageSize, true);
        employeeMapper.selectMapsPage(page, null);  // 分页查询结果封装在page中
        return page;
    }


    /**
     * 根据 Wrapper 条件，查询总记录数
     * Wrapper可以为 null
     */
    public Integer selectCount(Employee employee) {
        // queryWrapper ！= null 查询满足条件的全部记录
        QueryWrapper<Employee> wrapper = Wrappers.query();
        wrapper.eq(null != employee.getGender(), "gender", employee.getGender());

        return employeeMapper.selectCount(wrapper);
    }

}
