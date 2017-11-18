package com.java.transaction.command;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.java.transaction.dao.TDao;
import com.java.transaction.dto.TDto;

public class TicketBuyCommand implements TicketCommand {
	
	private TDao tDao;
	private TransactionTemplate transactionTemplate2;
	
	public void setTDao(TDao tDao) {
		this.tDao = tDao;
	}
	
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}
	
	@Override
	public void execute(final TDto tDto) {
		// TODO Auto-generated method stub
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				
				tDto.setAmount("1");
				tDao.buyTicket(tDto);
				
				tDto.setAmount("1");
				tDao.buyTicket(tDto);
			}
		});
	}
	
}
