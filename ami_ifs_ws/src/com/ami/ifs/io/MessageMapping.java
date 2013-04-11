package com.ami.ifs.io;

import com.ami.ifs.ws.common.Message;

@javax.xml.bind.annotation.XmlType(name="MessageMapping")
public class MessageMapping {
	private Message KeyErrorMessageForEc;
	private Message TimestampErrorMessageForEc;
	private Message OrderHeadErrorMessageForEc;
	private Message StoreErrorMessageForEc;
	private Message OrigOrderNoErrorMessageForEc;
	private Message OrigOrderTypeMessageForEc;
	private Message OrigOrderStatusErrorMessageForEc;
	private Message OrderStatusErrorMessageForEc;
	private Message OrderLineErrorMessageForEc;
	private Message OperateTypeErrorMessageForEc;

	private Message KeyErrorMessageForAsp;
	private Message TimestampErrorMessageForAsp;
	private Message OrderHeadErrorMessageForAsp;
	private Message StoreErrorMessageForAsp;
	private Message OrigOrderNoErrorMessageForAsp;
	private Message OrderStatusErrorMessageForAsp;
	private Message OperateTypeErrorMessageForAsp;
	private Message InvItemCdErrorMessageForAsp;
	private Message InvSkuListErrorMessageForAsp;
	private Message InvSkuCdErrorMessageForAsp;
	private Message InvErrorMessageForAsp;
	private Message InvQtyErrorMessageForAsp;
	private Message PriceItemCdErrorMessageForAsp;
	private Message PriceSkuListErrorMessageForAsp;
	private Message PriceSkuCdErrorMessageForAsp;
	private Message PriceErrorMessageForAsp;
	private Message StdPriceErrorMessageForAsp;
	private Message ItemCdErrorMessageForEc;
	private Message OrigItemTypeMessageForEc;
	private Message SkuListErrorMessageForEc;
	private Message SkuCdErrorMessageForEc;

	public Message getKeyErrorMessageForEc() {
		if (KeyErrorMessageForEc == null)
			KeyErrorMessageForEc = new Message("ec.key-error", "key或cd错误");
		return KeyErrorMessageForEc;
	}

	public Message getOrderHeadErrorMessageForEc() {
		if (OrderHeadErrorMessageForEc == null)
			OrderHeadErrorMessageForEc = new Message("ec.order-head-error",
					"无订单内容");
		return OrderHeadErrorMessageForEc;
	}

	public Message getStoreErrorMessageForEc() {
		if (StoreErrorMessageForEc == null)
			StoreErrorMessageForEc = new Message("ec.store-error", "店铺错误");
		return StoreErrorMessageForEc;
	}

	public Message getOrigOrderNoErrorMessageForEc() {
		if (OrigOrderNoErrorMessageForEc == null)
			OrigOrderNoErrorMessageForEc = new Message(
					"ec.orig-order-no-error", "没有原订单号");
		return OrigOrderNoErrorMessageForEc;
	}

	public Message getOrigOrderTypeMessageForEc() {
		if (OrigOrderTypeMessageForEc == null)
			OrigOrderTypeMessageForEc = new Message("ec.orig-order-type-error",
					"没有原订单类型");
		return OrigOrderTypeMessageForEc;
	}

	public Message getOrigOrderStatusErrorMessageForEc() {
		if (OrigOrderStatusErrorMessageForEc == null)
			OrigOrderStatusErrorMessageForEc = new Message(
					"ec.orig-order-status-error", "没有原订单状态");
		return OrigOrderStatusErrorMessageForEc;
	}

	public Message getOrderStatusErrorMessageForEc() {
		if (OrderStatusErrorMessageForEc == null)
			OrderStatusErrorMessageForEc = new Message(
					"ec.orig-order-status-error", "没有原订单状态");
		return OrderStatusErrorMessageForEc;
	}

	public Message getOrderLineErrorMessageForEc() {
		if (OrderLineErrorMessageForEc == null)
			OrderLineErrorMessageForEc = new Message("ec.order-line-error",
					"没有订单明细");
		return OrderLineErrorMessageForEc;
	}

	public Message getOperateTypeErrorMessageForEc() {
		if (OperateTypeErrorMessageForEc == null)
			OperateTypeErrorMessageForEc = new Message("ec.operate-type-error",
					"没操作类型");
		return OperateTypeErrorMessageForEc;
	}

	public Message getKeyErrorMessageForAsp() {
		if (KeyErrorMessageForAsp == null)
			KeyErrorMessageForAsp = new Message("asp.key-error", "key或cd错误");
		return KeyErrorMessageForAsp;
	}

	public Message getOrderHeadErrorMessageForAsp() {
		if (OrderHeadErrorMessageForAsp == null)
			OrderHeadErrorMessageForAsp = new Message("asp.order-head-error",
					"无订单内容");
		return OrderHeadErrorMessageForAsp;
	}

	public Message getStoreErrorMessageForAsp() {
		if (StoreErrorMessageForAsp == null)
			StoreErrorMessageForAsp = new Message("asp.store-error", "店铺错误");
		return StoreErrorMessageForAsp;
	}

	public Message getOrigOrderNoErrorMessageForAsp() {
		if (OrigOrderNoErrorMessageForAsp == null)
			OrigOrderNoErrorMessageForAsp = new Message(
					"asp.orig-order-no-error", "没有原订单号");
		return OrigOrderNoErrorMessageForAsp;
	}

	public Message getOrderStatusErrorMessageForAsp() {
		if (OrderStatusErrorMessageForAsp == null)
			OrderStatusErrorMessageForAsp = new Message(
					"asp.order-status-error", "没有订单状态");
		return OrderStatusErrorMessageForAsp;
	}

	public Message getOperateTypeErrorMessageForAsp() {
		if (OperateTypeErrorMessageForAsp == null)
			OperateTypeErrorMessageForAsp = new Message(
					"asp.operate-type-error", "没操作类型");
		return OperateTypeErrorMessageForAsp;
	}

	public Message getInvItemCdErrorMessageForAsp() {
		if (InvItemCdErrorMessageForAsp == null)
			InvItemCdErrorMessageForAsp = new Message("asp.inv-item-cd-error",
					"库存更新没item cd");
		return InvItemCdErrorMessageForAsp;
	}

	public Message getInvSkuListErrorMessageForAsp() {
		if (InvSkuListErrorMessageForAsp == null)
			InvSkuListErrorMessageForAsp = new Message("asp.inv-sku-list-error",
					"库存更新没sku");
		return InvSkuListErrorMessageForAsp;
	}

	public Message getInvErrorMessageForAsp() {
		if (InvErrorMessageForAsp == null)
			InvErrorMessageForAsp = new Message("asp.inv-error", "无库存更新内容");
		return InvErrorMessageForAsp;
	}

	public Message getInvQtyErrorMessageForAsp() {
		if (InvQtyErrorMessageForAsp == null)
			InvQtyErrorMessageForAsp = new Message("asp.inv-qty-error", "无库存数量");
		return InvQtyErrorMessageForAsp;
	}

	public Message getPriceItemCdErrorMessageForAsp() {
		if (PriceItemCdErrorMessageForAsp == null)
			PriceItemCdErrorMessageForAsp = new Message(
					"asp.price-item-cd-error", "价格更新没item cd");
		return PriceItemCdErrorMessageForAsp;
	}

	public Message getPriceSkuListErrorMessageForAsp() {
		if (PriceSkuListErrorMessageForAsp == null)
			PriceSkuListErrorMessageForAsp = new Message(
					"asp.price-sku-list-error", "价格更新没sku");
		return PriceSkuListErrorMessageForAsp;
	}

	public Message getPriceErrorMessageForAsp() {
		if (PriceErrorMessageForAsp == null)
			PriceErrorMessageForAsp = new Message("asp.price-error", "无价格更新内容");
		return PriceErrorMessageForAsp;
	}

	public Message getStdPriceErrorMessageForAsp() {
		if (StdPriceErrorMessageForAsp == null)
			StdPriceErrorMessageForAsp = new Message("asp.std-price-error",
					"无销售价格");
		return StdPriceErrorMessageForAsp;
	}

	public Message getTimestampErrorMessageForEc() {
		if (TimestampErrorMessageForEc == null)
			TimestampErrorMessageForEc = new Message("ec.std-price-error",
					"没有传入timestamp");
		return TimestampErrorMessageForEc;
	}

	public Message getTimestampErrorMessageForAsp() {
		if (TimestampErrorMessageForAsp == null)
			TimestampErrorMessageForAsp = new Message("asp.std-price-error",
					"没有传入timestamp");
		return TimestampErrorMessageForAsp;
	}

	public Message getInvSkuCdErrorMessageForAsp() {
		if (InvSkuCdErrorMessageForAsp == null)
			InvSkuCdErrorMessageForAsp = new Message("asp.std-price-error",
					"无SKU CD");
		return InvSkuCdErrorMessageForAsp;
	}

	public Message getPriceSkuCdErrorMessageForAsp() {
		if (PriceSkuCdErrorMessageForAsp == null)
			PriceSkuCdErrorMessageForAsp = new Message("asp.std-price-error",
					"无SKU CD");
		return PriceSkuCdErrorMessageForAsp;
	}

	public Message getItemCdErrorMessageForEc() {
		if (ItemCdErrorMessageForEc == null)
			ItemCdErrorMessageForEc = new Message("ec.item-cd-error",
					"无ITEM CD");
		return ItemCdErrorMessageForEc;
	}

	public Message getOrigItemTypeMessageForEc() {
		if (OrigItemTypeMessageForEc == null)
			OrigItemTypeMessageForEc = new Message("ec.orig-item-type-error",
					"无ORIG ITEM TYPE");
		return OrigItemTypeMessageForEc;
	}

	public Message getSkuListErrorMessageForEc() {
		if (SkuListErrorMessageForEc == null)
			SkuListErrorMessageForEc = new Message("ec.sku-list-error",
					"无SKU列表");
		return SkuListErrorMessageForEc;
	}

	public Message getSkuCdErrorMessageForEc() {
		if (SkuCdErrorMessageForEc == null)
			SkuCdErrorMessageForEc = new Message("ec.sku-cd-error",
					"无SKU CD");
		return SkuCdErrorMessageForEc;
	}

}
