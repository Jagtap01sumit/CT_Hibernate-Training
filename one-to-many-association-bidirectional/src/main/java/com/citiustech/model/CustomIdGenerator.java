package com.citiustech.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		Random random = new Random();
		int value = random.nextInt(100);
		LocalTime time = LocalTime.now();
		return value + time.getMinute() + time.getSecond() + time.getNano();
	}

}
//we can create table in database that contains only one column which is a primary key value
//---------------------
//primary key value	|
//---------------------
//		102			|
//---------------------