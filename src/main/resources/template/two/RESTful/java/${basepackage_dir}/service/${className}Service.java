<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.model.${className};
import java.util.List;
import java.util.Map;

/**
 * I${className}Service
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
public interface ${className}Service {

        /**
         * 根据id查询单条
         * @param id id
         * @return
         */
        ${className} getById(Long id);

        /**
         * 根据参数查询单条数据
         * @param ${classNameLower} ${classNameLower}
         * @return ${className}
         */
        ${className} getOneByParam(${className} ${classNameLower});

        /**
         * 根据参数查询列表
         * @param ${classNameLower}
         * @return list
         */
        List<${className}> getByParam(${className} ${classNameLower});

        /**
         * 查询所有
         * @return list
         */
        List<${className}> getAll();

        /**
         * 查询所有带查询参数
         * @param paraMap 模糊查询参数
         * @return list
         */
        List<${className}> getAll(Map<String,Object> paraMap);

        /**
         * 新增
         * @param ${classNameLower}
         */
        void insert(${className} ${classNameLower});

        /**
         * 删除
         * @param id id
         * @return int
         */
        int  delete(Long id);

        /**
         * 根据id编辑
         * @param ${classNameLower} ${classNameLower}
         * @return int
         */
        int  updateById(${className} ${classNameLower});


}