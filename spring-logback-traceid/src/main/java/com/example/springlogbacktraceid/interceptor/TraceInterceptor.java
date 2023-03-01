package com.example.springlogbacktraceid.interceptor;

import com.example.springlogbacktraceid.util.TraceUtil;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : brian
 * @since 0.1
 */
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler) {
        return TraceUtil.traceId();
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request,@NonNull HttpServletResponse response,@NonNull Object handler, @Nullable Exception ex) {
        TraceUtil.destroy();
    }
}
