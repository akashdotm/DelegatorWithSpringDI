package com.jvb.collect.basic.impl;

import com.jvb.collect.basic.DelegatedInterface;

public class DelegatedClassTwo implements DelegatedInterface {
    @Override
    public void callDelegateEmitMethod() {
        System.out.println("Coming in from Delegated Class 2.");
    }

    @Override
    public int getDelegateMarker() {
        return 2;
    }
}
