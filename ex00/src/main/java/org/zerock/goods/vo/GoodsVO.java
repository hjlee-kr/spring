package org.zerock.goods.vo;

import java.util.Date;

import lombok.Data;

@Data
public class GoodsVO {

	// goods
	private Long goods_no;
	private String goods_name;
	private Integer cate_code1;
	private Integer cate_code2;
	private String image_name;
	private String content;
	private String company;
	private Date product_date;
	
	// goods_price (현재 판매 기준)
	private Integer price;
	private Integer discount;
	private Integer discount_rate;
	private Integer saved_rate;
	private Integer delivery_charge;
	private Date sale_start_date;
	private Date sale_end_date;
}




