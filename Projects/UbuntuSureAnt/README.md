# UbuntuSure Insurance Management System (Java Ant)

This is the organised starter project for the UbuntuSure assessment. It targets Java 17, NetBeans Ant, MySQL and JDBC.

## Current baseline
- NetBeans Ant project structure and build script.
- MySQL schema with common policies, four product-detail tables, customers, users, claims and claim assessments.
- Role-aware login and a Swing dashboard.
- Customer registration/listing with validation.
- Product model classes implementing the four required premium formulas using `BigDecimal` and polymorphism.
- CSV export foundations for customer, policy and claim registers.

The Policies and Claims screens, assessment workflows, complete role/user administration, SMTP delivery, asynchronous database/report operations and comprehensive tests are intentionally scheduled for the incremental implementation sessions. The email adapter currently logs that SMTP is not configured; it does not falsely claim to send messages.

## 1. Requirements
Install JDK 17 or newer, NetBeans with Java/Ant support, MySQL Server and MySQL Workbench.

Download the MySQL Connector/J JAR from the official MySQL site and place it in `lib/` (keep the JAR out of source control if required by your course). The source compiles without it, but runtime database access needs it.

## 2. Create the database
1. Open MySQL Workbench and connect to your local server.
2. Open and execute `sql/ubuntusure.sql`.
3. Configure connection settings. Defaults are `jdbc:mysql://localhost:3306/ubuntusure`, username `root`, and an empty password. Prefer environment variables for your own setup:
   - `UBUNTUSURE_DB_URL`
   - `UBUNTUSURE_DB_USER`
   - `UBUNTUSURE_DB_PASSWORD`

## 3. Open in NetBeans
Choose **File → Open Project**, select the `UbuntuSureAnt` folder, and open it. If NetBeans does not recognise the freeform Ant project automatically, use **File → Open Project** on the folder containing `build.xml`, or create a Java with Ant project and copy the `src` tree and build script into it. Add `lib/mysql-connector-j-<version>.jar` to the project libraries/classpath.

Build and run using the Ant targets `clean`, `compile`, and `run`, or use the NetBeans Run action.

## 4. Demo accounts
The included demo accounts are `officer`, `claims`, and `admin`. The password for all three is `UbuntuDemo123!`. Change these before real use. This is a coursework prototype: production systems should use a salted adaptive password hash such as BCrypt/Argon2, not plain SHA-256.

## 5. Project structure
- `src/ubuntusure/app` — application entry point
- `src/ubuntusure/config` — database connection configuration
- `src/ubuntusure/model` — domain models and policy inheritance hierarchy
- `src/ubuntusure/dao` — SQL access
- `src/ubuntusure/service` — validation and business operations
- `src/ubuntusure/ui` — Swing windows
- `src/ubuntusure/util` — validation, CSV and password utilities
- `sql` — schema and seed script
- `docs` — design, test and assessment documentation

## Important
This is a staged assessment project, not a production insurance platform. Do not use real customer data. Before submission, complete the remaining features, replace the demo password hashes, configure SMTP, test every rule and update the diagrams so they match the final implementation.
