package org.sparkliang.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sparkliang.controller.DataConsumeController;

import java.io.IOException;
import java.io.PrintWriter;

public class JacksonUtils {
    private static final Logger LOG = LoggerFactory.getLogger(DataConsumeController.class);

    private static ThreadLocal<ObjectMapper> mapper = new ThreadLocal<ObjectMapper>() {
        @Override
        protected ObjectMapper initialValue() {
            return new ObjectMapper();
        }
    };

    public static String bean2Json(Object object) throws JsonProcessingException {
        try {
            return mapper.get().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOG.error(
                    "Failed to serialize the object:{}\nReason:{}"
                    , object, ExceptionUtils.getStackTrace(e)
            );
            throw e;
        }
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass) throws IOException {
        try {
            return mapper.get().readValue(jsonStr,objClass);
        } catch (IOException e) {
            LOG.error(
                    "Failed to deserialize the jsonstring:{}\nReason:{}"
                    , jsonStr, ExceptionUtils.getStackTrace(e)
            );
            throw e;
        }
    }

}
