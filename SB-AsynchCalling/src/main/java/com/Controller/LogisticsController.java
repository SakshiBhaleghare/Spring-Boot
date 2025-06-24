package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OrderService.OrderService;
import com.OtherServices.OtherServices;

@RestController
public class LogisticsController {

	@Autowired
	private OrderService os;

	@Autowired
	private OtherServices others;

	@GetMapping("/placeorder")
	public void DoEcommerce() {
		try {

			os.doOrder();
			others.notificaton();
			others.Invoice();
			others.packaging();
			others.shipping();

		} catch (Exception e) {

			System.out.println(e);
		}

	}

}
