/*
 * Copyright 2018 VMware, Inc. All rights reserved. -- VMware Confidential
 */
package com.vmware.bifrost.core.util;

import com.vmware.bifrost.bridge.spring.config.BifrostBridgeConfiguration;

public class BifrostUtil {

    private BifrostUtil() {}

    public static String getBifrostDestinationPrefix(BifrostBridgeConfiguration config, String destination) {
        if (destination == null) {
            return null;
        }
        destination = destination.toLowerCase().trim();
        for (String prefix : config.getBifrostDestinationPrefixes()) {
            if (destination.startsWith(prefix.toLowerCase())) {
                return prefix;
            }
        }
        return null;
    }

    public static String extractChannelName(BifrostBridgeConfiguration config, String destination) {
        String destinationPrefix = getBifrostDestinationPrefix(config, destination);
        if (destination != null && destinationPrefix != null) {
            return destination.substring(destinationPrefix.length()).trim();
        }
        return null;
    }
}
