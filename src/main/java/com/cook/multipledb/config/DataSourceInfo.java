package com.cook.multipledb.config;

import java.util.Map;

public record DataSourceInfo(
        String name,
        String strategy,
        String url,
        String table,
        String user,
        String password,
        Map<String, String> mapping
) {}
