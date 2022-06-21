package com.shipment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.shipment.main.entity.Buyer;
import com.shipment.main.entity.Country;
import com.shipment.main.enums.BuyerType;
import com.shipment.main.services.BuyerServices;
import com.shipment.main.services.CountryServices;

@Controller
public class BuyerController {

	@Autowired
	private BuyerServices buyerServices;
	
	@Autowired
	private CountryServices countryServices;
	
	@GetMapping("/buyer")
	public String AllBuyerInfo(Model model) {
		model.addAttribute("title","Buyer Information");
		model.addAttribute("buyerList",buyerServices.getAllBuyer());
		
		return "AllBuyerInfo.html";
	}
	
	@GetMapping("/buyer/add")
	public String showBuyerAddForm(Model model) {
		model.addAttribute("title","Add New Buyer");
		Buyer buyer = new Buyer();
		model.addAttribute("buyer",buyer);
		
		// Get List Of BuyerType
		model.addAttribute("buyerTypes", BuyerType.values());
		
		// Get List Of Country
		List<Country> countryList = countryServices.getAllCountry();
		model.addAttribute("countryList",countryList);
		return "AddNewBuyer.html";
	}
	
	@PostMapping("/buyer/save")
	public String saveBuyer(@ModelAttribute("buyer") Buyer buyer) {
		buyerServices.saveBuyer(buyer);
		return "redirect:/buyer";
	}
	
	@GetMapping("/buyer/update/{id}")
	public String updateBuyer(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("title","Update Buyer");
		Buyer buyer = buyerServices.getBuyerById(id);
		model.addAttribute("buyer",buyer);
		
		// Get List Of BuyerType
		model.addAttribute("buyerTypes", BuyerType.values());
		
		// Get List Of Country
		List<Country> countryList = countryServices.getAllCountry();
		model.addAttribute("countryList",countryList);
		return "UpdateBuyer.html";
	}
	
	@GetMapping("/buyer/detail/{id}")
	public String showBuyerDetail(@PathVariable(value="id") Long id, Model model) {
		model.addAttribute("title","Buyer Detail Information");
		Buyer buyer = buyerServices.getBuyerById(id);
		model.addAttribute("buyer",buyer);
		
		// Get List Of BuyerType
		model.addAttribute("buyerTypes", BuyerType.values());
		
		// Get List Of Country
		List<Country> countryList = countryServices.getAllCountry();
		model.addAttribute("countryList",countryList);
		return "DetailBuyerInfo.html";
	}
	
	@GetMapping("/buyer/delete/{id}")
	public String deleteBuyer(@PathVariable(value="id") Long id) {
		this.buyerServices.deleteBuyerById(id);
		return "redirect:/buyer";
	}
	
	
}
