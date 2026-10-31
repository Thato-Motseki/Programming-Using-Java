# Test plan (expand with actual evidence)

| ID | Test | Expected result |
|---|---|---|
| C01 | Register customer with valid required fields | Saved and assigned unique ID |
| C02 | Register duplicate national ID | Database rejects duplicate with understandable message |
| C03 | Omit first name, surname or phone | Validation blocks save |
| P01 | Create policy with coverage <= 0 | Rejected |
| P02 | Start date after end date | Rejected |
| P03 | Submit claim against non-active policy | Rejected |
| M01 | Private car M150,000, comprehensive | Annual premium M7,500 |
| PR01 | Residential property M500,000 with M100,000 contents | Premium M8,500 |
| L01 | Life cover M500,000, age 35 | Annual premium M7,500 |
| H01 | Standard health plan, 3 dependants | Annual premium M8,000 |
| CL01 | Approved payout exceeds product limit | Rejected or capped according to documented policy decision; never over limit |
| CL02 | Reject claim without reason | Rejected by validation/database |
| CL03 | Mark rejected claim PAID | Rejected |
| CSV01 | Export each report | Valid CSV with header and database-backed rows |
| GUI01 | Run slow query/report | GUI remains responsive through SwingWorker |
| AUTH01 | Role attempts unauthorised action | Access denied at service layer |
| EMAIL01 | Register customer / assign policy / update claim status | Customer receives event email after SMTP configuration |

Record actual outcome, date, test data, screenshot and defect reference for each test before submission.
