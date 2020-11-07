<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.springframework.stereotype.Service;
import ${basepackage}.mapper.${className}Mapper;
import ${basepackage}.model.${className};
import ${basepackage}.service.${className}Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import ${basepackage}.util.StringUtil;

/**
 * ${className}ServiceImpl
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Service("${className}Service")
public class ${className}ServiceImpl  implements ${className}Service {

    @Resource
    private ${className}Mapper ${classNameLower}Mapper;

    @Override
    public ${className} getById(Long id) {
        return ${classNameLower}Mapper.selectByPrimaryKey(id);
    }

    @Override
    public ${className} getOneByParam(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.selectOne(${classNameLower});
    }

    @Override
    public List<${className}> getByParam(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.select(${classNameLower});
    }

    @Override
    public List<${className}> getAll() {
        Example example=new Example(${className}.class);
        example.orderBy("createTime").desc();
        return ${classNameLower}Mapper.selectByExample(example);
    }

    @Override
    public List<${className}> getAll(Map<String, Object> paraMap) {
        Example example=new Example(${className}.class);
        Example.Criteria criteria = example.createCriteria();
        paraMap.remove("currentPage");
        paraMap.remove("pageSize");
        if (!paraMap.isEmpty()){
            paraMap.forEach((k,v)->{
            String value = StringUtil.appendLike((String) v);
            criteria.andLike(k,value);
            });
        }
        example.orderBy("createTime").desc();
        return ${classNameLower}Mapper.selectByExample(example);
    }

    @Override
    public void insert(${className} ${classNameLower}) {
        ${classNameLower}Mapper.insertSelective(${classNameLower});
    }

    @Override
    public int delete(Long id) {
        return ${classNameLower}Mapper.delete(new ${className}().setId(id));
    }

    @Override
    public int updateById(${className} ${classNameLower}) {
        return ${classNameLower}Mapper.updateByPrimaryKeySelective(${classNameLower});
    }
}