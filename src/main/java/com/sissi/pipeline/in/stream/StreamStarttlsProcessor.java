package com.sissi.pipeline.in.stream;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.Input;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.Stream;
import com.sissi.protocol.feature.Compression;
import com.sissi.protocol.feature.Starttls;

/**
 * @author kim 2013年12月18日
 */
public class StreamStarttlsProcessor implements Input {

	@Override
	public Boolean input(JIDContext context, Protocol protocol) {
		if (!context.isTls()) {
			Stream.class.cast(protocol).addFeature(Starttls.FEATURE).addFeature(Compression.FEATURE);
		}
		return true;
	}
}