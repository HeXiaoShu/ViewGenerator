<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * ${className}
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class ${className} implements Serializable {

    private static final long serialVersionUID = 1L;

    <@generateFieldsNew/>
    <@generateProperties/>

    <#macro generateFieldsNew>
    <#--自定义函数，根据数据库中表字段生成java中的属性 -->
    <#list table.columns as column>
    /** ${column.columnAlias!} */
    <#if column.isDateTimeColumn>
    <#if (column.columnNameLower != 'createdDate')&&(column.columnNameLower != 'updatedDate')>
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    <#else>
    </#if>
    private ${column.javaType} ${column.columnNameLower};

    <#else>
    <#if column.pk>
    @Id
    </#if>
    private ${column.javaType} ${column.columnNameLower};

    </#if>
    </#list>
    </#macro>

    <#macro generateProperties>

    </#macro>
}