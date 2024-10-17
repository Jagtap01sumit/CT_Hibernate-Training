# CT_Hibernate-Training

## ORM (Object Releation Mappping) Framework


### Every application is mainly divided into 3 layers/logics:
#####    a. presentation layer
#####    b. Business Logic/Layer
#####    c. Data Logic/Layer

### -> Hibernate is basically used to write persistent layer logic(Data layer logic)

## Why ORM framework/ Tools?
#### -> Boiler-plate code in JDBC ( which is a disadvantage when we change the db or schema).
##### - Opening connection with database
##### - Creating Query
##### - Creating PreparedStatment object
##### - Execute the query and get the result
##### - Process the result
##### - Close all the resouce.

#### -> We should keep Database structure in mind while writing JDBC Code . If database table schema changes, you have to modify JDBC code as well.
#### -> Mandatory to handle checked exception i.e. SQLException.
#### -> In java application, data is in the form of objects. 
#### -> To store objects into database we need to convert Ojbect => Text

```sql

Employee employee = new Employee(101,"Alex Browning", "HR", 23000);

insert into employees values(?,?,?,?);
statement.setInt(1,employee.getId());
statement.setString(2,employee.getName());
statment.setString(3,employee.getDepartment()):
statment.setInt(4,employee.getSalary());

```
#### -> To retrieve Objects(data) from database we need to convert Text => Object

```sql
select * from empooyees where id =101;
-- db is like => |101| Alex Browning | HR | 23000|
resultSet rs = statment.executeQuery():
int id= rs.getInt(1);
String name =rs.getString(2); -- this 1...2...3 is a column numbers which starts from 1 not from 0
String department = rs.getString(3);
int salary = rs.getInt(4);
--fetch then save into obj 
Employee employee = new Employee(id,name,department,salary); 

```
#### -> SQL queries are database dependents. If we change our database, we have to change queries in JDBC code.
#### -> Programmer / developer has to manage resources explicitly (Closing connection, statment, result set ojbects etc...)
##  Major benefits of ORM tools / frameworks:
#### All ORM tools / frameworks use JDBC internally to talk to databases.
##### 1. Data transfer is in the form of objects.
##### 2. Persistent logic is independant of the database.

### What is Ojbect Relational Mapping (ORM)?
```sql
--we just write
Employee employee = new Employee(101,"Alex Browning", "HR", 23000);
session.save(employee);



--but question is how to orm know tha in which table this obj will store => so we just explicitely define it
--Mapping => this employee class will map to which table => every field or varible map to which column. => this is called ORM Mapping.
-- How we do this mapping => 1. using XML(we not use it) 2. using annotations.

--to get
session.get(Employee.class,101) -- it get all fields direcly from table of employee classss
-- if we execute this command
-- the orm internally execute jdbc code like previous
--select * from empooyees where id =101;
-- db is like => |101| Alex Browning | HR | 23000|
--resultSet rs = statment.executeQuery():
--int id= rs.getInt(1);
--String name =rs.getString(2); -- this 1...2...3 is a column numbers which starts from 1 not from 0
--String department = rs.getString(3);
--int salary = rs.getInt(4);
--fetch then save into obj 
--Employee employee = new Employee(id,name,department,salary); 
```
#### -> ORM frameworks / tools provides abstraction layer over JDBC technology (core technology)

![design-of-jdbc](https://github.com/user-attachments/assets/b044caf6-e04b-4960-ad28-b529f9816a6b)

### Implementation of JDBC specification

### To Configure ith diff diff db it use the web driver for this particular database. this driver are provides by the database people like sql driver provided by the sql .

#### JPA -> It is a specification provided by Java for Object-Relational Mapping (ORM).

## Diff ORM Frameworks
##### Hibernate -> JBoss
##### iBatis -> Apache
#### TopLink -> Oracle corp
##### JDO -> Adobe


##### ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
##### OJB -> Ojbect java Bean
##### JDO -> Java Data Object

![images (1)](https://github.com/user-attachments/assets/043d803f-0165-42ac-ad52-5fda56fc72a6)

### Implementations of JPA Specification -- ( EclipseLink , DataNucleus is also a ORM frameworks same like mention above.) 
### we mostly use Hibernate only.

## Flow of data 
#### JavaApplication ---------->  ORM Tool ----------> DB 

## Advantage of Hibernate (ORM Tool):
##### - Automatic creation of schema.
##### - Inheritance mapping.
##### - Association mapping. => entities which are independent on each other 
##### - Caching support
![download](https://github.com/user-attachments/assets/7ab78fe2-c9cd-42db-83ab-e4058df64340)
##### - Unchecked Exception -> any exception are not forced u to handle the exception.
##### - Hibernate Query Languages (HQL) - Queries are databse independents.
``` sql
SEELCT emp_id , emp_name , emp_dept , emp_salary FROM employees  -- this is a SQL Query

---------------------------HQL QUERY-----------------------------------

SELECT id , name , department , salary FROM Employee  ------ this is HQL => this is database independent.
```
##### -  Versioning and Timestamp -> versioning => how many time your data is updated in db. ;  Timestamp => when the data is updtated last time ( It stores timestamp of recent updation of data)



## Create maven project 
### Dependencies 
#### 1. lombok 


### Annotations
##### 1- @Data => provide getter for all fields , a useful toString method. its equivalent to -> @Getter @Setter 
##### 1- @NoArgsConstructor
##### 1- @AllArgsConstructor
##### 1- @Entity ->  it will be mapped to a table in the database.-> its mean create a table in db with name of class and variable as a column names.
##### 1- @Table(name ="table_name") -> its override the table name -> if you only mention @Entity then its take class name as a table name ex. Employee.
##### 1- @Id  -> above the vaiable which will be the primary key in db table
##### 1- @Column(name="your_column_name")  -> if you want a vaibale name in class and the column name in db will be separate then u can set above va


```sql
-- in JDBC we explicitely connect with db using drivermanager but in every method we need to metion this line (open conn and close conn).
Connection connection = DriverManager.getConnection(url, username, password);

-- but in real time project there is lots of req came thus we req connection obj
-- thus there is an connection pool (collection of connection obj) , in this pool there is so many connection objects which represent connection of db( sql ).
-- Thus we have interface DataSource which represent collection pool,
Connection connection = dataSource.getConnection(); --we get one connection from connection pool


-- similar to this in hibernate there is concept sessionFactory which is collection of session obj.
-- Here is a interface sessionFactory , so there will be implementation classes exists, where the connection obj is implemented (hibernate internally use JDBC).
-- Session obj used to interact with db.
-- There is one SessionFactory obj per application.

-- for this we need to configer the db connection where mention the url , username and password. thus we configor this in src/test/resources file in a type of  XML file.
-- default file name => hibernate search for => hibernate.cfg.xml
```
![Screenshot 2024-09-21 170649](https://github.com/user-attachments/assets/fda56f92-5564-4662-82fb-7bcf12f1d07c)

## To configer the db connection where mention the url , username and password we configure this in resouces (file).

##### we configor this in src/test/resources file in a type of  XML file.  
> [!IMPORTANT]
> #### default file name => hibernate search for => hibernate.cfg.xml


```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC 
  "-//Hibernate/Hibernate Configuration DTD 3.0//EN" 
  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<!-- Version 8 MySQL hiberante-cfg.xml example for Hibernate 5 -->

<hibernate-configuration>
  <session-factory>
        <!--connection setting-->
        <!--here is configuration of session factory => url , username , password-->
        <property name = "hibernate.connection.driver_class"> com.mysql.cj.jdbc.Driver</property>
        <property name = "connection.url">jbc:mysql://localhost:3306/your_db_name</property>
        <property name="connecion.username">root</property>
        <property name= "connection.password">root</property>
       

        <!--SQL Dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.MYSQL8Dialect</property> -- this is based on version of mysql ... currenctly my version is 8

        <property name="hibernate.hbm2ddl.auto">update</property>   <!-- Schema generation -->

        <property name ="show_sql">true</property> -- hibernate interlly create sql querys , to see this queries in console we use this property
        <property name="formate_sql">true</property> 
        
  </session-factory>
</hibernate-configuration>

```
## Purpose of dialet class
#### as a programer we use hibernate but hibernate internally use JDBC so take care of generating the queries , optimization because db cannot understand the obj.

## Schema generation
``` xml
        <!-- every time its create a new schema-->
        <property name="hibernate.hbm2ddl.auto">create</property>   <!-- Schema generation  -->

        <!---------------------------------------------------------------------------------------------------------->
        <property name="hibernate.hbm2ddl.auto">update</property> 
        <!-- but we want it only once .. ex if there is not table then it create if exist so no need to create-->
        <!-- for this we use update -> it check is update requires-->

       <!---------------------------------------------------------------------------------------------------------->
       <!-- it just validate the schema using using appropiate  mapping... its assume schema is already setup, its only validate like column name , tablename.....-->
       <property name="hibernate.hbm2ddl.auto">validate</property>

       <!---------------------------------------------------------------------------------------------------------->
       <!--  This is only used for testing and dev purpose .....-->
       <!-- when we start the application schema is create , once u stop the application all the schema (table) will dropped-->
       <property name="hibernate.hbm2ddl.auto">create-drop</property> 

```
> [!IMPORTANT]
> #### Thus we mostly use update property

## Formated query
##### <property name="formate_sql">true</property> 
```sql
  --normal query
  select * from employee where employee_id=101


  -- Formated query -> 
  SELECT *
  FROM EMPLOYEE
  WHERE employee_id =101
```

## diff dialet class available in depndencies
##### - CockroachDB1
##### - DB2 Dialet class -> IBM
##### - MariaDB
##### - MySQL
##### - Oracle
##### - PostgresSQL
##### - SQL server
##### - SYbase

## Now Create class create obj of session factory and session obj , and read the peoperty file(xml file).
### In Static block 
##### Configuration configuration = new Configuration().configure() -> this use mappings and properties specified in an application resource (resource file name).
> [!NOTE]
> ##### Configuration class responsible to read the properties in xml file.
> ##### automatically it search for this file ( to find resource config..s) ->  hibernate.cfg.xml
```java 
class HibernateUtil{
    private static SessionFactory factory;     // from org.hibernate.SessionFactory
    public static Session getSession(){
        return factory.openSession():
    }
    public static void closeSessionFactory(){
      factory.close();
    }
    static {
        Configuration configuration = new Configuration().configure() //reding the configuratio mapping properties in resource files.
                                                                    .addAnnotatedClass(Employee.class) //we need to specifies all anoted class -> hibernate must know which class is there whose mapping it has to done.
        StandardServciceRegistryBuilder  builder = new StandardServicesRegistryBuilder().applySetting(configuration.getProperties()); // this properties are get from the resource file where          //we save the resouce in a form of key value pair key -> name , value-> value of the xml ele. 
        factory=Configuration.buildSessionFactory(builder.build());
    }
}
```

> [!WARNING]
> The db name mention in a resource file is need to create explicitly.

## Diff between session.get() and session.load()
![download (1)](https://github.com/user-attachments/assets/ad6dcbcb-3af6-42cf-97fc-350d1f7114da)


##### @Embeddable
```java public class Address{
	private String street;
	private String state;
	private String city;
	private String country;
	private int zipcode;
}

public class Person{
	private int id;
	private String name;
	private String contact;
	@Embedded
	private Address address;
}
```
#### @Embeddable 
##### -> Specifies a class whose instance are stored as an intrinsic part of an owning entity and share the identity of the entity. Each of the persistent properties of fields of the embedded objec is mapped to the database table for the entity.
##### -> embeddable class is a class whose instances can be stored in a single column 
##### -> An embeddable class typically has a set of fields, getters, and setters, just like an entity class. However, it does not have a primary key or a table associated with it.
##### -> | id | name | contact | street | state | city | country | zipcode |

#### @Embedded -> 





### Persistent Life Cycle:
#### Object having three states
##### 1. Trasient state ->  the state where obj is not associate with session
##### 2. Persistent state -> the state where obj is associate with the session ex. update without using update() -> 
##### 3.Detached state -> detach obj from the session 


### Managing Hibernate Session
#### session.evict(obj); -> detach only particular persistent obj;
##### session.clear(); -> detach all the persistant obj -> it not close the session its just detach the obj which associate with session

### Relationship between the tables
#### one to many relation
```java
public class Address {
	//passport doesnot exist without person
	private String street ;
	private String city;
	private String state;
	private String country;
	private int zipcode;
}


public class Customer {
	
	@Id
	@Column(name="customer_id")
	private int id;
	private String name;
	private String contact;
	@ElementCollection
	private List<Address> addresses;
}
```
 ``` java
package com.training.test;

public class TestCustomer {
	public static void main(String[] args) {
		
		ArrayList<Address> addresses = new ArrayList<>();
		addresses.add(new Address("MG road", "Mumbai", "Maharastra", "India", 42820));
		addresses.add(new Address("FC road","Pune","Maharastra","India",18278));
		
		Customer customer = new Customer(101,"sumit","81777192791",addresses);
		
		session.save(customer);
		
		
		}
}
``` 
#### @ElementCollection  
##### Its a  Hibernate annotation that allows you to store a collection of objects (like a list or set) as a part of another object.
##### its allow lazy loading -> when we print data only that time it hit address db.

#### @JoinTable(name="addresses",joinColumns=@JoinColumn(name="customer_id")) 
##### its create new db address and store the addresses there with the primary key of customer

#### @ElementCollection(fetch=FetchType.EAGER) 
##### when we use @ElementCollection(fetch=FetchType.EAGER) -> ITS EAGER loading -> when we call the customer db then it also hit address db.









## how to tabe creatation done in inheritance
### diagram of inheritance table and three way to store data in table
##### 1. single table
##### 2. table per subclass
##### 3. table per concrete class

![Screenshot 2024-09-29 140935](https://github.com/user-attachments/assets/28bb0281-fcc9-4628-b025-287e33df58a2)

### single table

![Screenshot 2024-09-29 144154](https://github.com/user-attachments/assets/7939928d-f414-4a4e-b49e-6ff732e7c1a4)

#### payment class ->
> 	@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
> 	@DiscriminatorColumn(name="payment_mode", discriminatorType = 				DiscriminatorType.STRING)
#### cardPayment class ->
> @DiscriminatorValue("card")

#### Cheque Pyament class -> 
> @DiscriminatorValue("cheque")

### table per subclass
####  create three diff tables payment , cardpayemnts , cheque payments
####  common key is paymentId

#### Payment Class
 	> @Inheritance(strategy = InheritanceType.JOINED)

####  cardpayment class
	> @Table(name="cardpayments")
#### cheque payment class
	> @Table(name="chequepayments")

#### three table is like this.
> 1. | paymentId | paymentDate | paymentAmount |
> 2. | paymentId | chequeNo | chequeType |
> 3. | paymentId | cardNo | validUptoDate | validUptoYear | cvv |
### table per concrete class
#### two separate table createted
#####  ex. card table contains all the properties in the card related also paymentid , paymentDate , paymentAmount

> | paymentID | paymentDate | paymentAmount | chequeNo | chequeType |

> | paymentId | paymentDate | paymentAmount | cardNo | validUptoDate | validUptoYear | cvv |


## HQL - Hibernate query language

### In hibernate , we can perform following operations
##### 	 1. Single row operations
##### 	 2. Bulk operations.

### Bulk operation can be performed using;
##### 	1. Hibernate Query Language.
##### 	2. Criteria API.
##### 	3. Native SQL.

##### In JDBC  - select emp_id, name , department, salary from employees

##### In HQL - select id, name , department , salary from Employee;

##### we can use HQL to perform select and non-select operations. (BULK INSERT operation)
```sql
SELECT 
UPDATE
DELETE


SELECT * FROM employees; +> FROM Employee ; (Selecting complete object)

SELECT employee_id , name FROM employees; => SELECT id , name FROM Employee;
```

### Bulk operation in HQL 
``` sql
		
//		Query<Employee> query=session.createQuery("FROM Employee");
//		Query<Employee> query=session.createQuery("FROM Employee WHERE department = 'HR'");
//		Query<Employee> query = session.createQuery("FROM Employee WHERE department = ?1 AND salary > ?2", Employee.class);
		
//		Query<Employee> query = session.createQuery("FROM Employee WHERE department =:dept AND salary > :sal", Employee.class);
//		query.setParameter("dept", "HR"); // set department parameter
//		query.setParameter("sal", 5000); // set salary parameter
		
		
//		Query<Employee> query = session.createQuery("FROM Employee ORDER BY salary DESC");
//		List<Employee> employees = query.list();
//		employees.forEach(System.out::println);
		
		//if we want particular fields data then we use Object[]
//		Query<Object[]> query = session.createQuery("SELECT name, department from Employee");
//		List<Object[]> employees = query.getResultList();
//		employees.forEach(row-> System.out.println(row[0]+" "+row[1]));
		
		// if we want only single field data then we can directly mention the datatype
		Query<String> query = session.createQuery("SELECT name from Employee");
		List<String> employees = query.getResultList();
		employees.forEach(name-> System.out.println(name));

		--UPDATE 
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("UPDATE Employee SET salary = salary + ?1 WHERE department = ?2");
//		query.setParameter(1, 100000);
//		query.setParameter(2, "HR");
//		
//		int count = query.executeUpdate();
//		tx.commit();
//		System.out.println("COUNT: "+count);
		
		
		--DELETE
//		Transaction tx = session.beginTransaction();
//		Query query = session.createQuery("DELETE from Employee WHERE department = ?1");
//		query.setParameter(1, "HR");
//		int count = query.executeUpdate();



```



## Diff ID generator in hibernate

#### There are diff strategies we use for increment id
##### 1. AUTO -> automatically select the stractegy which support the db.
##### 2. IDENTITY -> persistent provider must assig primary keys for the entity using db entity column
##### 3. SEQUENCE ->  persistent provider must assig primary keys for the entity using db sequence
##### 4. TABLE ->  persistent provider must assig primary keys for the entity using underline db table to ensure uniqueness.
```sql 	
	@Id
	@GeneratedValue(stregy = );
	private int id
```


### OneToOne - Relationship

> [!NOTE]
> if we not use @OneToOne(cascade = CascadeType.PERSIST) then we need to persist (save) person and vehicle explisitly.
```sql
public class Person{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	private String name;
	private String contact;
	@OneToOne
	@JoinColumn(name = "vehicle_registration_id")

	private Vehicle vehicle;
	
	
	public Person(String name , String contact , Vehicle vehicle) {
		this.name= name;
		this.contact=contact;
		this.vehicle=vehicle;
	}
}
```
##### vehicle class
```sql
public class Vehicle {
	@Id
	private int registrationId;
	private int price;
	private String type;
}
```
##### main class

```sql
 Vehicle bike = new Vehicle(20091781, 50000, "Bike");
	        Person amit = new Person("Amit", "9137705219", bike);

	        Session session = HibernateUtil.getSession();
	        Transaction tx = session.beginTransaction();

	        session.persist(amit); 
		session.persist(bike); // we need to explicitly add bike obj also.

	        tx.commit();
	        session.close();
	        HibernateUtil.closeSessionFactory();
```

> [!NOTE]
> but if we use  @OneToOne(cascade = CascadeType.PERSIST), we need to only persist ( save) person object.

```sql 
public Person{
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="person_id")
	private int id;
	private String name;
	private String contact;
	@OneToOne@OneToOne(cascade = CascadeType.PERSIST)//when we add person obj then the vehile obj also saved
	@JoinColumn(name = "vehicle_registration_id")

	private Vehicle vehicle;
	
	
	public Person(String name , String contact , Vehicle vehicle) {
		this.name= name;
		this.contact=contact;
		this.vehicle=vehicle;
	}
}
```

##### vehicle class
```sql 
public class Vehicle {
	@Id
	private int registrationId;
	private int price;
	private String type;
}
```

##### main class
```sql 
 Vehicle bike = new Vehicle(20091781, 50000, "Bike");
	        Person amit = new Person("Amit", "9137705219", bike);

	        Session session = HibernateUtil.getSession();
	        Transaction tx = session.beginTransaction();

	        session.persist(amit); // Hibernate will automatically persist the Vehicle entity

	        tx.commit();
	        session.close();
	        HibernateUtil.closeSessionFactory();
```


##### EAGER Loading -> when call the person it also fetch the data from vehicle table also.
```sql 
System.out.println("person Details");
Person person = session.get(Person.class,2);
System.out.println("-----------------------");
System.out.println(person.getId()+"-"+person.getName()+"-" person.getContact());

Vehicle vehicle = person.getVehicle();
System.out.println(vehicle.getRegistrationId()+"-"+vehicle.getType()+"-" vehicle.getPrice());
```
##### Lazy loading -> it only fetch vehicle info when they ask for it ( when we print it)
```sql
@OneToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
```
### OneToMany - Relationship























































| Anotations 		| Use      								 |
|-----------------------|------------------------------------------------------------------------|
|     @Id	     	| set all getters and setters	   					 |


