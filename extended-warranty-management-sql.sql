create database extended_warrenty_system;
use extended_warrenty_system;
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE CarModels (
    model_id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(100) NOT NULL,
    model_name VARCHAR(100) NOT NULL,  
    year INT NOT NULL,            
    base_price DECIMAL(10,2) NOT NULL,  
    engine_type ENUM('Petrol', 'Diesel', 'Electric', 'Hybrid') DEFAULT 'Petrol',
    transmission ENUM('Manual', 'Automatic', 'Semi-Automatic') DEFAULT 'Automatic',
    fuel_type ENUM('Petrol', 'Diesel', 'Electric', 'Hybrid') DEFAULT 'Petrol',
    seating_capacity INT,
    warranty_duration_months INT,
    warranty_km_limit INT, 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE CarModels 
MODIFY COLUMN transmission ENUM('Manual', 'Automatic', 'SemiAutomatic') DEFAULT 'Automatic';



CREATE TABLE CarTypes (
    car_type_id INT PRIMARY KEY AUTO_INCREMENT,
    car_type_name ENUM('Personal', 'Commercial', 'Used Personal', 'Used Commercial') NOT NULL
);

desc carTypes;
desc carmodels;




ALTER TABLE CarTypes 
MODIFY COLUMN car_type_name ENUM('Personal', 'Commercial', 'UsedPersonal', 'UsedCommercial') NOT NULL;

CREATE TABLE CarSaleRecords (
    car_sale_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT,
    model_id INT,
	car_type_id INT, 
    purchase_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (model_id) REFERENCES CarModels(model_id),
	FOREIGN KEY (car_type_id) REFERENCES CarTypes(car_type_id)
);


CREATE TABLE WarrantyTypes (
    warranty_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name ENUM('Basic', 'Extended') NOT NULL
);

CREATE TABLE CoverageTypes (
    coverage_type_id INT PRIMARY KEY AUTO_INCREMENT,
    name ENUM('Comprehensive', 'Limited') DEFAULT 'Limited'
);


CREATE TABLE WarrantyPlans (
    plan_id INT PRIMARY KEY AUTO_INCREMENT,    
    name VARCHAR(50),
    duration_months INT,
    km_limit INT,
	warranty_type_id INT,
    coverage_type_id INT,
    base_price DECIMAL(10,2),
    surcharge_percent DECIMAL(5,2) DEFAULT 0.0,
    FOREIGN KEY (warranty_type_id) REFERENCES WarrantyTypes(warranty_type_id),
	FOREIGN KEY (coverage_type_id) REFERENCES CoverageTypes(coverage_type_id)
);


CREATE TABLE CarWarranties (
    car_warranty_id INT PRIMARY KEY AUTO_INCREMENT,
    car_sale_id INT,
    plan_id INT,
    bw_start_date DATE,
    bw_end_date DATE,
    bw_km_start INT,
    bw_km_end INT,
	exw_start_date DATE,
    exw_end_date DATE,
    exw_km_start INT,
    exw_km_end INT,
    price_paid DECIMAL(10,2),
    purchased_during_basic BOOLEAN DEFAULT TRUE,
	exw_purchase_date DATE,
	is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (car_sale_id) REFERENCES CarSaleRecords(car_sale_id),
    FOREIGN KEY (plan_id) REFERENCES WarrantyPlans(plan_id)
);