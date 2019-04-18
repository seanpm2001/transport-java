/*
 * Copyright(c) VMware Inc. 2019.
 */
package com.vmware.bifrost.core.interfaces;

/**
 * Bus Services should be able to be enabled and disabled. Online and Offline translate
 * to listening or not listening on the service channel. The service however is still there and can switch
 * state on demand.
 */
public interface BusServiceEnabled {

    /**
     * Switch a service online, start listening on the service channel.
     */
    void online();

    /**
     * Switch a service offline, stop listening on the service channel.
     */
    void offline();
}