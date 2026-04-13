# eagle-bank
Barclays interview project

# What's included

Implementation of the following: 

- Login API to authenicate any subsequent requests
- Create user API
- Fetch user API
- Create account API
- Fetch accounts API
- Create transaction API
- Fetch transaction API

Api's are unauthorized without a value JWT token from the login API

Local in-memory database used for storing user, account & transaction data

Cache used for mapping JWT token to userId

Bruno request collection used for manual testing of API's


# Limitations/Improvements

The project currently contains no tests. All testing has been carried out manually. 
Given real implementation each class would contain a number of unit tests (with mocks used for dependent classes), and each endpoint would contain a number of integration tests to assert each type of response highlighted in the OAS.
This could be further expanded upon with acceptance tests in a more 'formal' testing environment

secret/secure value are currently just stored as properties.
Given real implementation these values would;
- Be environment-specific variables 
- **NOT BE STORED AS PLAIN TEXT** - either stored in a secure database or secure tool (ie. Vault) and looked-up when needed

Caching solution could be improved 
- this could be made more robust as a session cookie for storing data required for subsequent request
- Mechanism could also be moved to the database for more persistence if required

Database configuration/setup
- It's currently a very simple setup, would be more robust as a relational database, eg. adding Foreign Key constraints on accounts table with one-to-many relationships between users and accounts
- A relational database would still make sense when up-scaling data as indexes could be added to speed up reads, eg. index added on the accountNumber field in accounts table as it's commonly searched on. 
- Could incorporate a housekeeping solution involving 'archiving' historic data (ie. transactions older than X years) where data is exported to a separate database and then removed from the 'working' database to speed up queries

Security abstraction
- Another potential improvement could be to extract the security measures away from the business logic services (perhaps into a front-facing gateway that validates & forwards validated requests through to the service). This can prevent any malicious requests from getting into the service/network.

CI/CD
- Adding CI/CD pipelines would provide a number of improvements including:
  - Improving reliability of code changes
  - speeding up development of future changes
  - provides a means to deploy code to different environments

Complete full spec
- With more time available the full requirements could be implemented.


Lastly, thank you for taking the time to review the project & reading through this document. I look forward to showcasing this work!
