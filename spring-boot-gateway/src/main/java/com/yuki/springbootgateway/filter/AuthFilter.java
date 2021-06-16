package com.yuki.springbootgateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthFilter extends ZuulFilter {

    /**
     *
     * pre 表示在转发之前拦截
     *
     * @return 拦截阶段
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     *
     * 数字越小越优先
     *
     * @return 优先级
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     *
     *
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        // 获取令牌内容
        RequestContext ctx = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 无 token 访问网关内资源的情况，目前只有 uaa 服务直接暴露
        if (!(authentication instanceof OAuth2Authentication)) {
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Authentication authentication1 = oAuth2Authentication.getUserAuthentication();
        Object principal = authentication1.getName();

        // 组装明文 token
        List<String> authorities = new ArrayList<>();
        authentication1.getAuthorities()
                .forEach(s -> authorities.add(s.getAuthority()));

        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();
        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();
        Map<String, Object> jsonToken = new HashMap<>(requestParameters);
        jsonToken.put("principal", authentication1.getName());
        jsonToken.put("authorities", authorities);
        ctx.addZuulRequestHeader("json-token", JSON.toJSONString(jsonToken));
        return null;
    }

}
