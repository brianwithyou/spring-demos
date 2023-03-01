package com.example.springlogbacktraceid.util;

import cn.hutool.core.util.StrUtil;
import com.example.springcommon.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author : brian
 * @since 0.1
 */
@Slf4j
public class TraceUtil {

    static String TRACE_ID = "traceId";

    public static boolean traceId() {
        String traceId = MDC.get(TRACE_ID);
        if (StrUtil.isBlank(traceId)) {
            traceId = CommonUtil.generateUuid().replaceAll("-", "").toLowerCase();
            log.debug("create traceId :{}", traceId);
            MDC.put(TRACE_ID, traceId);
        }
        return true;
    }

    public static void destroy() {
        log.debug("destroy traceId :{}", MDC.get(TRACE_ID));
        // or   MDC.clear()
        MDC.remove(TRACE_ID);

    }

}
