<#include "/macro.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.controller;

import com.annotation.CheckParam;
import com.common.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.model.${className};
import com.service.${className}Service;
import com.util.SnowflakeIdWorker;
import com.util.StringUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * ${className}Controller
 * @author ${author}
 * @date ${now?string('yyyy-MM-dd HH:mm:ss')}
 */
@RequestMapping("/${classNameLower}")
@RestController
public class ${className}Controller {

    @Resource
    private ${className}Service ${classNameLower}Service;

    @PostMapping("/add")
    @CheckParam
    public Result add(@RequestBody @Valid ${className} ${classNameLower}, BindingResult bindingResult){
        ${classNameLower}Service.insert(${classNameLower}.setId(SnowflakeIdWorker.id()).setCreateTime(new Date()));
        return Result.ok("操作成功");
    }

    @DeleteMapping("/del")
    public Result del(Long id){
        int i = ${classNameLower}Service.delete(id);
        if (i>0){
            return Result.ok("操作成功");
        }else {
            return Result.error("操作失败");
        }
    }

    @PutMapping("/update")
    public Result update(@RequestBody ${className} ${classNameLower}){
        int i = ${classNameLower}Service.updateById(${classNameLower});
        if (i>0){
            return Result.ok("操作成功");
        }else {
            return Result.error("操作失败");
        }
    }

    @GetMapping("/searchAll")
    public Result searchAll(@RequestParam Map<String,Object> paramMap){
        paramMap.putIfAbsent("currentPage",1);
        paramMap.putIfAbsent("pageSize",10);
        PageHelper.startPage(Integer.parseInt((String) paramMap.get("currentPage")), Integer.parseInt((String) paramMap.get("pageSize")));
        List<${className}> ${classNameLower}s = ${classNameLower}Service.getAll();
        PageInfo<${className}> result = new PageInfo<>(${classNameLower}s);
        return Result.ok(result);
    }

    @GetMapping("/searchInfo")
    public Result searchInfo(Long id){
        if (StringUtil.objIsEmpty(id)){
            return Result.error("id不能为空");
        }
        ${className} ${classNameLower} = ${classNameLower}Service.getById(id);
        return Result.ok(${classNameLower});
    }

}