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

