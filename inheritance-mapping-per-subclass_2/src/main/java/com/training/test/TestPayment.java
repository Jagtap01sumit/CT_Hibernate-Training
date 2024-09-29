package com.training.test;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.CardPayment;
import com.training.model.ChequePayment;
import com.training.model.Payment;
import com.training.util.HibernateUtil;

public class TestPayment {
	public static void main(String[] args) {
//		int paymentId , LocalDate paymentDate , int paymentAmount,long cardNo , int validUptoDate , int validUptoYear, int cvv
		CardPayment payment1 = new CardPayment(101, LocalDate.now(), 1500, 1111222223333444L ,3,2023,5434);
		ChequePayment payment2 = new ChequePayment(102, LocalDate.now(), 29800,5000 , "PCD");
		
		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
		
//		session.save(payment1);
//		session.save(payment2);
		
		Payment payment =session.get(Payment.class, 102);
		if(payment instanceof CardPayment) {
			CardPayment cp = (CardPayment) payment;
			System.out.println("payment id -> "+ cp.getPaymentId());
			System.out.println("card no. -> "+ cp.getCardNo());
			System.out.println("payment date -> "+cp.getPaymentDate());
			System.out.println("payment amount -> "+ cp.getPaymentAmount());
			System.out.println("cvv -> "+ cp.getCvv());
	
		}else {
			ChequePayment cp = (ChequePayment) payment;
			System.out.println("payment id -> "+ cp.getPaymentId());

			System.out.println("check no. "+cp.getChequeNo());
			System.out.println("cheque type -> "+cp.getChequeType());
			System.out.println("cheque amount -> "+cp.getPaymentAmount());
		}
//		tx.commit();
		
		session.close();
		HibernateUtil.closeSessionFactory();
		
	}
}
