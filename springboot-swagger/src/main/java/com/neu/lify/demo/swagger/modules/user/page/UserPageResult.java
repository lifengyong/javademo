package com.neu.lify.demo.swagger.modules.user.page;

import com.neu.lify.demo.swagger.modules.user.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "user分页信息", parent = ResultUtil.class)
public class UserPageResult extends ResultUtil {

    @ApiModelProperty(value = "数据列表", dataType = "List")
    private PageUtil<User> result;
}
