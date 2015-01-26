package com.ejunhai.qutihuo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejunhai.qutihuo.common.base.BaseController;
import com.ejunhai.qutihuo.common.base.Pagination;
import com.ejunhai.qutihuo.errors.JunhaiAssert;
import com.ejunhai.qutihuo.order.dto.OrderMainDto;
import com.ejunhai.qutihuo.order.model.OrderMain;
import com.ejunhai.qutihuo.order.service.OrderMainService;

/**
 * 
 * 订单管理
 * 
 * @date 2015-1-26 下午3:49:36
 * @version 0.1.0 
 */
@Controller
@RequestMapping("orderMain")
public class OrderMainController extends BaseController {

	@Resource
	private OrderMainService orderMainService;

	@RequestMapping("/orderMainList")
	public String orderMainList(HttpServletRequest request, OrderMainDto orderMainDto, ModelMap modelMap) {
		Integer iCount = orderMainService.queryOrderMainCount(orderMainDto);
		Pagination pagination = new Pagination(orderMainDto.getPageNo(), iCount);

		// 获取分页数据
		List<OrderMain> orderMainList = new ArrayList<OrderMain>();
		if (iCount > 0) {
			orderMainDto.setOffset(pagination.getOffset());
			orderMainDto.setPageSize(pagination.getPageSize());
			orderMainList = orderMainService.queryOrderMainList(orderMainDto);
		}

		modelMap.put("pagination", pagination);
		modelMap.put("orderMainDto", orderMainDto);
		modelMap.put("orderMainList", orderMainList);
		return "order/orderMainList";
	}

	@RequestMapping("/orderMainDetail")
	public String orderMainDetail(HttpServletRequest request, OrderMain orderMain, ModelMap modelMap) {
		if (orderMain.getId() != null) {
			orderMain = orderMainService.read(orderMain.getId());
		}

		modelMap.put("orderMain", orderMain);
		return "order/orderMainEdit";
	}

	@RequestMapping("/saveOrderMain")
	@ResponseBody
	public String saveOrderMain(HttpServletRequest request, OrderMain orderMain) {
		//JunhaiAssert.notBlank(orderMain.getActionName(), "操作名不能为空");
		if (orderMain.getId() != null && orderMain.getId() > 0) {
			orderMainService.update(orderMain);
		} else {
			orderMainService.insert(orderMain);
		}
		return jsonSuccess();
	}

	@RequestMapping("/deleteOrderMain")
	@ResponseBody
	public String deleteOrderMain(HttpServletRequest request, OrderMain orderMain) {
		JunhaiAssert.notNull(orderMain.getId(), "id不能为空");
		orderMainService.delete(orderMain.getId());
		return jsonSuccess();
	}

}