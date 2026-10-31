-- UbuntuSure Insurance System
-- MySQL 8.0+
-- Database creation script based on Ubuntu_ERD.drawio.
-- Run this script in MySQL Workbench.
-- It creates the schema only; demo records will be added separately.

CREATE DATABASE IF NOT EXISTS ubuntusure_insurance
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_0900_ai_ci;

USE ubuntusure_insurance;

CREATE TABLE IF NOT EXISTS ROLE (
    role_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    roleName VARCHAR(50) NOT NULL,
    description VARCHAR(255) NULL,
    PRIMARY KEY (role_ID),
    CONSTRAINT uq_role_name UNIQUE (roleName)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS USER (
    user_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    role_ID INT UNSIGNED NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    username VARCHAR(80) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    email VARCHAR(254) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_ID),
    CONSTRAINT uq_user_username UNIQUE (username),
    CONSTRAINT fk_user_role
        FOREIGN KEY (role_ID) REFERENCES ROLE(role_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CUSTOMER (
    customer_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    registered_by_user_ID INT UNSIGNED NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL,
    national_ID VARCHAR(50) NOT NULL,
    DOB DATE NOT NULL,
    gender VARCHAR(30) NULL,
    phone_number VARCHAR(30) NOT NULL,
    email VARCHAR(254) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (customer_ID),
    CONSTRAINT uq_customer_national_id UNIQUE (national_ID),
    CONSTRAINT fk_customer_registered_by
        FOREIGN KEY (registered_by_user_ID) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS INSURANCE_POLICY (
    policy_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_ID INT UNSIGNED NOT NULL,
    created_by_user_ID INT UNSIGNED NOT NULL,
    policy_number VARCHAR(40) NOT NULL,
    policy_type ENUM('MOTOR','PROPERTY','LIFE','HEALTH') NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    coverage_amount DECIMAL(12,2) NOT NULL,
    annual_premium DECIMAL(12,2) NOT NULL,
    status ENUM('ACTIVE','EXPIRED','CANCELLED') NOT NULL DEFAULT 'ACTIVE',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (policy_ID),
    CONSTRAINT uq_policy_number UNIQUE (policy_number),
    CONSTRAINT chk_policy_coverage CHECK (coverage_amount > 0),
    CONSTRAINT chk_policy_premium CHECK (annual_premium >= 0),
    CONSTRAINT chk_policy_dates CHECK (end_date >= start_date),
    CONSTRAINT fk_policy_customer
        FOREIGN KEY (customer_ID) REFERENCES CUSTOMER(customer_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_policy_created_by
        FOREIGN KEY (created_by_user_ID) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS MOTOR_POLICY (
    policy_ID INT UNSIGNED NOT NULL,
    vehicle_registration VARCHAR(30) NOT NULL,
    make VARCHAR(80) NOT NULL,
    model VARCHAR(80) NOT NULL,
    vehicle_year SMALLINT UNSIGNED NOT NULL,
    vehicle_value DECIMAL(12,2) NOT NULL,
    vehicle_type ENUM('MOTORCYCLE','PRIVATE_CAR','MINIBUS','TRUCK') NOT NULL,
    cover_type ENUM('THIRD_PARTY','COMPREHENSIVE') NOT NULL,
    PRIMARY KEY (policy_ID),
    CONSTRAINT uq_motor_vehicle_registration UNIQUE (vehicle_registration),
    CONSTRAINT chk_motor_vehicle_value CHECK (vehicle_value > 0),
    CONSTRAINT fk_motor_policy_parent
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS PROPERTY_POLICY (
    policy_ID INT UNSIGNED NOT NULL,
    property_address VARCHAR(255) NOT NULL,
    property_type ENUM('RESIDENTIAL','COMMERCIAL') NOT NULL,
    property_value DECIMAL(12,2) NOT NULL,
    contents_value DECIMAL(12,2) NOT NULL DEFAULT 0,
    contents_covered BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (policy_ID),
    CONSTRAINT chk_property_value CHECK (property_value > 0),
    CONSTRAINT chk_contents_value CHECK (contents_value >= 0),
    CONSTRAINT chk_contents_cover_value
        CHECK (contents_covered = TRUE OR contents_value = 0),
    CONSTRAINT fk_property_policy_parent
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS LIFE_POLICY (
    policy_ID INT UNSIGNED NOT NULL,
    occupation VARCHAR(100) NOT NULL,
    beneficiary_name VARCHAR(200) NOT NULL,
    beneficiary_contact VARCHAR(50) NOT NULL,
    PRIMARY KEY (policy_ID),
    CONSTRAINT fk_life_policy_parent
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS HEALTH_POLICY (
    policy_ID INT UNSIGNED NOT NULL,
    health_plan ENUM('BASIC','STANDARD','PREMIUM') NOT NULL,
    number_of_dependants INT UNSIGNED NOT NULL DEFAULT 0,
    PRIMARY KEY (policy_ID),
    CONSTRAINT fk_health_policy_parent
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CLAIM (
    claim_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    policy_id INT UNSIGNED NOT NULL,
    submitted_by_user_id INT UNSIGNED NOT NULL,
    claim_number VARCHAR(40) NOT NULL,
    date_submitted DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    claim_amount DECIMAL(12,2) NOT NULL,
    description TEXT NOT NULL,
    status ENUM('SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','PAID')
        NOT NULL DEFAULT 'SUBMITTED',
    PRIMARY KEY (claim_ID),
    CONSTRAINT uq_claim_number UNIQUE (claim_number),
    CONSTRAINT chk_claim_amount CHECK (claim_amount > 0),
    CONSTRAINT fk_claim_policy
        FOREIGN KEY (policy_id) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_claim_submitted_by
        FOREIGN KEY (submitted_by_user_id) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_claim_policy (policy_id),
    INDEX idx_claim_status (status),
    INDEX idx_claim_date (date_submitted)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CLAIM_ASSESSMENT (
    assessment_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    claim_ID INT UNSIGNED NOT NULL,
    assessed_by_user_id INT UNSIGNED NOT NULL,
    assessment_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    decision ENUM('APPROVED','REJECTED') NOT NULL,
    approved_amount DECIMAL(12,2) NULL,
    assessment_notes TEXT NULL,
    rejection_reason TEXT NULL,
    PRIMARY KEY (assessment_ID),
    CONSTRAINT chk_assessment_approved_amount
        CHECK (approved_amount IS NULL OR approved_amount >= 0),
    CONSTRAINT chk_assessment_decision_fields CHECK (
        (decision = 'APPROVED' AND approved_amount IS NOT NULL
            AND rejection_reason IS NULL)
        OR
        (decision = 'REJECTED' AND rejection_reason IS NOT NULL
            AND CHAR_LENGTH(TRIM(rejection_reason)) > 0)
    ),
    CONSTRAINT fk_assessment_claim
        FOREIGN KEY (claim_ID) REFERENCES CLAIM(claim_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_assessment_user
        FOREIGN KEY (assessed_by_user_id) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_assessment_claim_date (claim_ID, assessment_date)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CLAIM_PAYMENT (
    payment_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    claim_ID INT UNSIGNED NOT NULL,
    processed_by_user_ID INT UNSIGNED NOT NULL,
    payment_reference VARCHAR(100) NOT NULL,
    payment_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    payment_status ENUM('PENDING','COMPLETED','FAILED') NOT NULL DEFAULT 'PENDING',
    payment_amount DECIMAL(12,2) NOT NULL,
    PRIMARY KEY (payment_ID),
    CONSTRAINT uq_payment_reference UNIQUE (payment_reference),
    CONSTRAINT chk_payment_amount CHECK (payment_amount > 0),
    CONSTRAINT fk_payment_claim
        FOREIGN KEY (claim_ID) REFERENCES CLAIM(claim_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_payment_user
        FOREIGN KEY (processed_by_user_ID) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_payment_claim (claim_ID),
    INDEX idx_payment_status (payment_status)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS EMAIL_NOTIFICATION (
    notification_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    customer_ID INT UNSIGNED NOT NULL,
    policy_ID INT UNSIGNED NULL,
    claim_ID INT UNSIGNED NULL,
    notification_type VARCHAR(50) NOT NULL,
    recipient_email VARCHAR(254) NOT NULL,
    sent_at DATETIME NULL,
    delivery_status ENUM('PENDING','SENT','FAILED') NOT NULL DEFAULT 'PENDING',
    error_message TEXT NULL,
    PRIMARY KEY (notification_ID),
    CONSTRAINT fk_notification_customer
        FOREIGN KEY (customer_ID) REFERENCES CUSTOMER(customer_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_notification_policy
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_notification_claim
        FOREIGN KEY (claim_ID) REFERENCES CLAIM(claim_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_notification_status (delivery_status),
    INDEX idx_notification_customer (customer_ID)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS POLICY_STATUS_HISTORY (
    history_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    policy_ID INT UNSIGNED NOT NULL,
    changed_by_user_ID INT UNSIGNED NOT NULL,
    previous_status VARCHAR(30) NULL,
    new_status VARCHAR(30) NOT NULL,
    changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reason TEXT NULL,
    PRIMARY KEY (history_ID),
    CONSTRAINT fk_policy_history_policy
        FOREIGN KEY (policy_ID) REFERENCES INSURANCE_POLICY(policy_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_policy_history_user
        FOREIGN KEY (changed_by_user_ID) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_policy_history_policy_date (policy_ID, changed_at)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS CLAIM_STATUS_HISTORY (
    history_ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    claim_ID INT UNSIGNED NOT NULL,
    changed_by_user_ID INT UNSIGNED NOT NULL,
    previous_status VARCHAR(30) NULL,
    new_status VARCHAR(30) NOT NULL,
    changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reason TEXT NULL,
    PRIMARY KEY (history_ID),
    CONSTRAINT fk_claim_history_claim
        FOREIGN KEY (claim_ID) REFERENCES CLAIM(claim_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_claim_history_user
        FOREIGN KEY (changed_by_user_ID) REFERENCES USER(user_ID)
        ON UPDATE CASCADE ON DELETE RESTRICT,
    INDEX idx_claim_history_claim_date (claim_ID, changed_at)
) ENGINE=InnoDB;

-- Starter role records. Passwords and demo users are intentionally not inserted here.
INSERT INTO ROLE (roleName, description)
VALUES
    ('Insurance Officer', 'Registers customers and manages insurance policies.'),
    ('Claims Officer', 'Reviews, assesses and processes claims.'),
    ('Administrator', 'Manages system users and configuration.')
ON DUPLICATE KEY UPDATE description = VALUES(description);

-- End of schema.
-- Important: business rules involving policy subtype consistency, premium
-- calculation, age eligibility, claim limits, role permissions and total
-- payments must also be enforced in the Java application using transactions.
