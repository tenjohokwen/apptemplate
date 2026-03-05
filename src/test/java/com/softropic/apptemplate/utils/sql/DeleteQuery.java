package com.softropic.apptemplate.utils.sql;

public class DeleteQuery extends SqlQuery {
    @Override
    protected String getQueryType() {
        return "DELETE";
    }
}
