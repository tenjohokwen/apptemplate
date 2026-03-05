package com.softropic.apptemplate.utils.sql;

public class InsertQuery extends SqlQuery {
    @Override
    protected String getQueryType() {
        return "INSERT";
    }
}
