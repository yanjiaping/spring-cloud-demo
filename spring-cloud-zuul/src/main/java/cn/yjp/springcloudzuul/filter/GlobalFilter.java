package cn.yjp.springcloudzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器类
 */
@Component
public class GlobalFilter extends ZuulFilter {

    /**
     * 过滤器类型，执行过滤器的时机
     * pre：路由前
     * routing：路由时
     * post：路由后
     * error：发送错误时
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤，可以丰富代码进行逻辑判断，true：过滤；false：不过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体逻辑实现
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest servletRequest = context.getRequest();
        Object token = servletRequest.getHeader("token");
        if (token == null) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("error: token is null");
            } catch (IOException e) {
            }
        }
        return null;
    }
}
