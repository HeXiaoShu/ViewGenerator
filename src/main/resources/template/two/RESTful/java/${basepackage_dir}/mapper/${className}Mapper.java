<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;

import ${basepackage}.model.${className};
import org.springframework.stereotype.Repository;
import ${basepackage}.common.TkMapper;

/**
 * ${className}Dao
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Repository
public interface ${className}Mapper extends TkMapper<${className}> {

}