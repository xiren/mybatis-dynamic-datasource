package com.example.mybatisdynamicdatasource.datasource;

public class DynamicDataSourceHolder {

    private static final ThreadLocal<DynamicDataSourceName> HOLDER = new ThreadLocal<>();

    private DynamicDataSourceHolder() {

    }

    public static void setDataSource(DynamicDataSourceName dataSourceName) {
        HOLDER.set(dataSourceName);
    }

    public static DynamicDataSourceName getDataSource() {
        return HOLDER.get();
    }

    public static void clearDataSource() {
        HOLDER.remove();
    }
}
