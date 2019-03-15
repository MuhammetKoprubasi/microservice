package com.microservice.netflixzuulapigatewayserver.filter;

import com.netflix.zuul.ZuulFilter;


import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "pre"; //pre, post, error
    }

    @Override
    public int filterOrder() {
        return 1; // order number if we have other filters
    }

    @Override
    public boolean shouldFilter() {
        return true; // should filter active
    }


    //example logic for a logging mechanism
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();

        logger.debug("request -> {} , requestUri -> {}", request, request.getRequestURI());

        return null;
    }
}
