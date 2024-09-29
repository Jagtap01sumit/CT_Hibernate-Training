package com.training.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("cheque")
public class ChequePayment extends Payment {
	private int chequeNo;
	private String chequeType;
	public ChequePayment(int paymentId , LocalDate paymentDate , int paymentAmount, int chequeNo, String chequeType) {
		super(paymentId, paymentDate, paymentAmount);
		this.chequeNo=chequeNo;
		this.chequeType=chequeType;
		
	}
}
