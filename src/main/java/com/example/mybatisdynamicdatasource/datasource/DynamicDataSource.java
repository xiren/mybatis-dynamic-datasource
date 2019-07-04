package com.example.mybatisdynamicdatasource.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        DynamicDataSourceName dataSourceName = DynamicDataSourceHolder.getDataSource();
        if (dataSourceName == null || dataSourceName == DynamicDataSourceName.WRITE) {
            return DynamicDataSourceName.WRITE;
        }
        return DynamicDataSourceName.READ;
    }
}
