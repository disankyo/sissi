package com.sissi.pipeline.in.iq.muc.owner;

import com.sissi.pipeline.in.ClassMatcher;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.ProtocolType;
import com.sissi.protocol.muc.Owner;

/**
 * @author kim 2014年3月25日
 */
public class MucOwnerActionMatcher extends ClassMatcher {

	private final ProtocolType type;

	public MucOwnerActionMatcher(String action) {
		super(Owner.class);
		this.type = ProtocolType.parse(action);
	}

	public boolean match(Protocol protocol) {
		return super.match(protocol) && protocol.parent().type(this.type);
	}
}
