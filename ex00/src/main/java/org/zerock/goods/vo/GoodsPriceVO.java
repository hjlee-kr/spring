package org.zerock.goods.vo;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsPriceVO {

	private Long goods_price_no;
	private Integer price;
	private Integer discount;
	private Integer discount_rate;
	private Integer saved_rate;
	private Integer delivery_charge;
	private Date sale_start_date;
	private Date sale_end_date;
	private Long goods_no;
}




