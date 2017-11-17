package com.java.transaction.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.transaction.dao.TDao;
import com.java.transaction.dto.TDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TController {
	private TDao dao;
	
	@Autowired
	public void setDao(TDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/buy_ticket")
	public String buy_ticket(HttpServletRequest hsr, Model model) {
		return "buy_ticket";
	}
	
	@RequestMapping("/buy_ticket_card")
	public String buy_ticket_card(TDto tDto, Model model) {
		System.out.println("Consumer ID : " + tDto.getConsumerId());
		System.out.println("Amount : " + tDto.getAmount());
		
		dao.buyTicket(tDto);
		
		model.addAttribute("ticketInfo", tDto);
		
		return "buy_ticket_end";
	}
}
