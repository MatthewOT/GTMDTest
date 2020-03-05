package com.gtmdtest.platform.components.filter;

import com.gtmdtest.platform.model.vo.BaseResponseVO;
import org.springframework.web.method.HandlerMethod;

/**
 * @program: platform
 * @description:
 * @author:
 * @create: 2019-12-07 13:19
 **/
public class GlobalNoLoginExceptionHandler {

    public BaseResponseVO NoLoginExceptionHandler(HandlerMethod handlerMethod, Exception e){
        return BaseResponseVO.warn(handlerMethod.getBean().getClass(), e.getMessage(), "未登录:{}", e.getMessage());
    }
}
