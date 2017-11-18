package com.java.transaction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.java.transaction.dto.TDto;

public class TDao {
	JdbcTemplate template;
	TransactionTemplate transactionTemplate1;
	
	public void setTransactionTemplate1(TransactionTemplate transactionTemplate) {
		this.transactionTemplate1 = transactionTemplate;
	}
	//PlatformTransactionManager transactionManager;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

//	public void setTransactionManager(PlatformTransactionManager transactionManager) {
//		this.transactionManager = transactionManager;
//	}

	public TDao() {
		System.out.println(template);
	}

	public void buyTicket(final TDto dto) {
		System.out.println("buyTicket()");
		System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
		System.out.println("dto.getAmount() : " + dto.getAmount());
		
		transactionTemplate1.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String query = "insert into card (consumerId, amount) values(?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
						
						return pstmt;
					}
				});
				
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						// TODO Auto-generated method stub
						String query = "insert into ticket (consumerId, amount) values(?, ?)";
						PreparedStatement pstmt = con.prepareStatement(query);
						pstmt.setString(1, dto.getConsumerId());
						pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
						
						return pstmt;
					}
				});
			}
		});
		
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		TransactionStatus status = transactionManager.getTransaction(definition);
//		
//		try {
//			template.update(new PreparedStatementCreator() {
//				
//				@Override
//				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//					// TODO Auto-generated method stub
//					String query = "insert into card (consumerId, amount) values(?, ?)";
//					PreparedStatement pstmt = con.prepareStatement(query);
//					pstmt.setString(1, dto.getConsumerId());
//					pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
//					
//					return pstmt;
//				}
//			});
//			
//			template.update(new PreparedStatementCreator() {
//				
//				@Override
//				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//					// TODO Auto-generated method stub
//					String query = "insert into ticket (consumerId, amount) values(?, ?)";
//					PreparedStatement pstmt = con.prepareStatement(query);
//					pstmt.setString(1, dto.getConsumerId());
//					pstmt.setInt(2, Integer.parseInt(dto.getAmount()));
//					
//					return pstmt;
//				}
//			});
//			
//			transactionManager.commit(status);
//		} catch(Exception e) {
//			
//			e.printStackTrace();
//			transactionManager.rollback(status);
//			
//		}
		
	}
}
