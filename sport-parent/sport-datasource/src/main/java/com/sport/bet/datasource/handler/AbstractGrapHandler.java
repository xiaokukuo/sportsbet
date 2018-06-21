package com.sport.bet.datasource.handler;

import java.io.UnsupportedEncodingException;

public abstract class AbstractGrapHandler {

	abstract void grabData(int resourceId, String url) throws UnsupportedEncodingException;
}
