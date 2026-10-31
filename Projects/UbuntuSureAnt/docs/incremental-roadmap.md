# Incremental build roadmap

## Build 1 — project foundation (included)
Project skeleton, database schema, login, customer registration/listing, CSV export foundation, domain inheritance and premium formula classes.

## Build 2 — policy workflow
Add policy DAO/service, customer selection, product-specific Swing forms, automatic premium preview and persistence for each product detail table. Enforce policy dates, coverage, unique policy number and status rules. Add customer/policy assignment notifications.

## Build 3 — claim workflow
Add claim submission, pending queue, review, approval/rejection with reason, approved amount limits, PAID transition checks, beneficiary capture, health remaining-cover calculations and assessment history. Add status-change notifications.

## Build 4 — administration and role security
Add user management, service-layer authorization checks, account activation/deactivation and password update flow. Remove any role access that is only controlled by the GUI.

## Build 5 — resilience and technical marks
Use SwingWorker for database queries, exports and notification work; add robust error handling, edge-case validation, collections where justified, and SMTP delivery configuration.

## Build 6 — evidence and submission
Add JUnit tests (or documented test harness if library setup is restricted), integration test evidence, final UML/ER exports, README screenshots, user guide, final report and a rehearsed demonstration script.
