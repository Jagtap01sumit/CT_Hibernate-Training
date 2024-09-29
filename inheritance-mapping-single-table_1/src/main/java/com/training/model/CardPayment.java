package com.training.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DiscriminatorValue("card")
public class CardPayment extends Payment {
	private long cardNo;
	private int validUptoDate;
	private int validUptoYear;
	private int cvv;
	
	
	public CardPayment(int paymentId , LocalDate paymentDate , int paymentAmount,long cardNo , int validUptoDate , int validUptoYear, int cvv) {
		super(paymentId, paymentDate, paymentAmount);
		this.cardNo=cardNo;
		this.validUptoDate=validUptoDate;
		this.validUptoYear=validUptoYear;
		this.cvv=cvv;
	}
}
