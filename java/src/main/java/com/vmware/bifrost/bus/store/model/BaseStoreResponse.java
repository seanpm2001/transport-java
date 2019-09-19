/*
 * Copyright 2019 VMware, Inc. All rights reserved. -- VMware Confidential
 */
package com.vmware.bifrost.bus.store.model;

public class BaseStoreResponse {

    public final String storeId;

    public final String responseType;

    /**
     * The current version of the store
     */
    public final long storeVersion;

    BaseStoreResponse(String responseType, String storeId, long storeVersion) {
        this.storeId = storeId;
        this.responseType = responseType;
        this.storeVersion = storeVersion;
    }
}
