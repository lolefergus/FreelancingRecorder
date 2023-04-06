-- CREATE DATABASE FreelanceShifts;

create table company (
  companyId INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  email VARCHAR(256) NOT NULL,
  address VARCHAR(255),
  PRIMARY KEY (companyId)
);

create table payScale (
  payId INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(10) NOT NULL,
  companyId INT  NOT NULL,
  amount INT NOT NULL,
  description VARCHAR(255),
  PRIMARY KEY (payId),
  FOREIGN KEY (companyId) REFERENCES company(companyId)
);

create table shifts (
  shiftId INT NOT NULL AUTO_INCREMENT,
  date DATE NOT NULL,
  companyId INT NOT NULL,
  description VARCHAR(255) NOT NULL,
  payId INT NOT NULL,
  PRIMARY KEY (shiftId),
  FOREIGN KEY (companyId) REFERENCES company(companyId),
  FOREIGN KEY (payId) REFERENCES company(companyId)
);

create table invoices (
  invoiceId INT NOT NULL AUTO_INCREMENT,
  dateCreated DATE NOT NULL,
  periodStart DATE NOT NULL,
  periodEnd DATE,
  companyId INT NOT NULL,
  total INT,
  paid BOOLEAN DEFAULT FALSE,
  PRIMARY KEY (invoiceId),
  FOREIGN KEY (companyId) REFERENCES company(companyId)
);

create table invoicePayments (
  paymentId INT NOT NULL AUTO_INCREMENT,
  invoiceId INT NOT NULL,
  shiftId INT NOT NULL,
  PRIMARY KEY (paymentId),
  FOREIGN KEY (invoiceId) REFERENCES invoices(invoiceId),
  FOREIGN KEY (shiftId) REFERENCES shifts(shiftId)
);