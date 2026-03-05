package com.softropic.apptemplate.common.message;

public record Failure(String helpCode, String msgKey, String msg) implements Response {
}
