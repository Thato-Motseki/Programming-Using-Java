# UbuntuSure: requirements and initial design

## Problem statement
UbuntuSure's paper records and spreadsheets create delays, missing records, inconsistent premium calculations and weak management reporting. The proposed desktop application centralises customer, policy and claim data in MySQL and provides controlled workflows through Java Swing.

## Roles and permissions
| Capability | Insurance Officer | Claims Officer | Administrator |
|---|---:|---:|---:|
| Register/view customers | Yes | No by default | Yes |
| Create/view/update policies | Yes | View policy context | Yes |
| Submit claims | Yes | No | Administrative oversight |
| Assess claims | No | Yes | Oversight |
| Manage users | No | No | Yes |
| Export reports | Yes | Limited to claim work | Yes |

Enforce permissions in service methods as well as by hiding or disabling UI controls.

## Key domain design
`InsurancePolicy` is an abstract superclass for `MotorPolicy`, `PropertyPolicy`, `LifePolicy` and `HealthPolicy`. Each subclass overrides `calculateAnnualPremium()`, avoiding a large conditional statement. `Customer` can own zero or many policies; each policy belongs to exactly one customer. A policy can have many claims; each claim references one policy and customer. A claim can have one or more assessment history records, each recorded by a user.

## Core business rules
- Customer national ID/passport is unique; first name, surname and phone are mandatory.
- Policy number is unique; customer must exist; coverage is positive; start date is not after end date.
- Only ACTIVE policies can accept claims. CANCELLED and EXPIRED policies cannot accept claims.
- Motor premium rates: Motorcycle 2%/4%, Private Car 2.5%/5%, Minibus 3%/6%, Truck 3.5%/7% for Third Party/Comprehensive.
- Property premium: Residential 1.5%, Commercial 2.5%, plus optional contents at 1% of contents value.
- Life premium: ages 18–30 1%, 31–40 1.5%, 41–50 2%, 51–60 3%, 61–65 4%; age eligibility is checked at policy creation.
- Health premium: Basic M3,000, Standard M5,000, Premium M8,000 plus M1,000 per dependant.
- Claim amount is positive; approval requires review; approved amount is distinct from claimed amount and cannot exceed product limits; rejected claims require a reason; only approved claims can become PAID.
- Health remaining annual cover is policy-year coverage less previous approved claims within that year.

## Reports
1. Customer directory: supports contact verification and duplicate review.
2. Policy register: supports active/expired portfolio review and premium oversight.
3. Claims register: supports claim status and payout monitoring.
All exports are CSV and should be generated from database records, not only currently visible UI rows.

## Initial relational design
`customers(customer_id PK)` 1—M `policies(policy_id PK, customer_id FK)`. `policies` 1—0/1 each of `motor_policy_details`, `property_policy_details`, `life_policy_details`, and `health_policy_details`, with the matching detail table selected by `product_type`. `policies` 1—M `claims(claim_id PK, policy_id FK, customer_id FK)`. `claims` 1—M `claim_assessments(assessment_id PK, claim_id FK, assessed_by FK to users)`. `users(user_id PK)` links to policy creation and claim assessments.

## Design decisions to justify in final report
Use `BigDecimal` for money; prepared statements for SQL; a DAO/service/UI separation for maintainability; database constraints as a second line of defence; and a background worker for slow database, email and report work so the Swing event dispatch thread remains responsive. Email delivery must be configured and tested before claiming the requirement is complete.
