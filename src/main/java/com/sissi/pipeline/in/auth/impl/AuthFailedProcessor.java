package com.sissi.pipeline.in.auth.impl;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.Stream;
import com.sissi.protocol.iq.auth.Failure;

/**
 * @author kim 2013-10-24
 */
public class AuthFailedProcessor implements Input {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		context.write(Failure.INSTANCE_NOTAUTHORIZED);
		if (!context.setAuthFailed().isAuthRetry()) {
			context.write(Stream.closeGracefully());
			context.close();
		}
		return false;
	}
}
