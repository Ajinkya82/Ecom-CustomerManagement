create table employee(firstName varchar(30),
    middleName varchar(30),
    lastName varchar(30),
    emprole varchar(30),
    emptype varchar(10),
    salary float(2),
    joining Date,
    city varchar(10),
    status varchar(10),
    empid varchar(10),
    emppw varchar(20),
    CONSTRAINT PK_empid PRIMARY KEY (empid));
    
    create table customer (firstName varchar(30),
    middleName VARCHAR(30),
    lastName varchar(30),
    dob Date,
    gender varchar(10),
    permanentAddress varchar(100),
    presentAddress varchar(100),
    email varchar(30),
    phone number(10),
    id varchar(10),
    password varchar(20),
    CONSTRAINT PK_id PRIMARY KEY (id));
    
    create table status(
    status varchar(15),
    reason varchar(200),
    id varchar(10) NOT NULL PRIMARY KEY);
    
    create table transfer(
    currentcity varchar(20),
    preferredcity varchar(20),
    rreason varchar(200),
    status varchar(10),
    reason varchar(200),
    empid varchar(10) NOT NULL PRIMARY KEY,
    role varchar(30));
    
    insert into employee(empid, emppw) values('snm', 'snm');
    insert into employee(empid, emppw) values('ih', 'ih');
    insert into employee(empid, emppw) values('sk', 'sk');
    insert into employee(empid, emppw) values('de', 'de');
    insert into employee(empid, emppw) values('se', 'se');
    insert into employee(empid, emppw) values('md', 'md');
    insert into customer(id, password) values('cust', 'cust');
    update employee set emprole='Delivery Executive' where empid='de';
    update employee set emprole='Sales Executive' where empid='se';
    update employee set emprole='Sales and Marketing Head' where empid='snm';
    update employee set emprole='Inventory Head' where empid='ih';
    update employee set emprole='Store Keeper' where empid='sk';
    update employee set emprole='Managing Director' where empid='md';
    commit;
    
    
    
  