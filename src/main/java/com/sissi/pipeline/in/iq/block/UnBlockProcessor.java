package com.sissi.pipeline.in.iq.block;

import com.sissi.context.JIDContext;
import com.sissi.pipeline.in.ProxyProcessor;
import com.sissi.protocol.Protocol;
import com.sissi.protocol.iq.block.BlockListItem;
import com.sissi.protocol.iq.block.UnBlock;
import com.sissi.ucenter.user.BlockContext;

/**
 * @author kim 2013年12月6日
 */
public class UnBlockProcessor extends ProxyProcessor {

	private final BlockContext blockContext;

	public UnBlockProcessor(BlockContext blockContext) {
		super();
		this.blockContext = blockContext;
	}

	@Override
	public boolean input(JIDContext context, Protocol protocol) {
		UnBlock ub = protocol.cast(UnBlock.class);
		return ub.isUnBlockAll() ? this.unblockAndReturn(context) : this.unblockAndReturn(context, ub.getItem());
	}

	private boolean unblockAndReturn(JIDContext context, BlockListItem item) {
		this.blockContext.unblock(context.jid(), super.build(item.getJid()));
		return true;
	}

	private boolean unblockAndReturn(JIDContext context) {
		this.blockContext.unblock(context.jid());
		return true;
	}
}
