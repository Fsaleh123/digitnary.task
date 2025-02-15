This project contains automated tests for UI and API testing as part of the assessment. The tests cover different E2E scenarios for two web applications and an API.

Getting Started

Prerequisites

Node.js & npm (if using Playwright)

Java & Maven (if using Rest Assured)

Git (for version control)

Setup

Clone the repo:

git clone <repo-link>
cd <repo-folder>

Install dependencies (if applicable):

npm install

Running Tests

UI Tests

Run all UI tests:

npx playwright test

API Tests

Run API tests:

mvn test

Test Scenarios

E-commerce UI Tests

✅ Add a new product & verify it’s added✅ Edit a product & verify changes✅ Delete a product & verify it’s removed✅ Search for a product & verify results

Counter App UI Test

✅ Click + button & verify counter increases

API Tests

✅ Health check for API✅ Register a new user & verify✅ Login & verify profile data✅ Create, update, and delete a note

Reports

Test execution reports are generated after running the tests.

UI tests capture screenshots on failure.

CI/CD Integration

The project runs tests automatically using GitHub Actions on every push.

Additional Notes

The code is structured for maintainability.

More negative test cases are included for robustness.

Feel free to suggest improvements!
