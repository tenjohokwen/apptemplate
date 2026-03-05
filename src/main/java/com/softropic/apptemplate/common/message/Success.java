package com.softropic.apptemplate.common.message;

import java.util.Map;

public record Success(String helpCode, String msgKey, String msg, Map<String, Object> payload) implements Response {
}
