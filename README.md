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




