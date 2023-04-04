# Task Description
The task is to implement Rest-API for the electric vehicle charging stationEntity management system.

Notes:

* You are free to choose any kind of technology/language that fits you the best.
* You must use the provided database schema in your implementation, however, feel free to add/modify everything as needed.
* Pay attention to the scalability of the API.
* One charging companyEntity can own one or more other charging companies.

  Hence, the parent companyEntity should have the access to all the child companyEntity's stations hierarchically.
  For example, we got 3 companies A, B and C accordingly with 10,5 and 2 stations.
  Company B belongs to A and companyEntity C belongs to B. Then we can say that companyEntity A has 17, companyEntity B has 7 and companyEntity C has 2
  stations in total.


#### The database schema for start point:
    1. Station (id, name, latitude, longitude, company_id)
    2. Company (id, parent_company_id, name)

You should make a git repository (perhaps bitbucket will be a good choice) and commit as frequently as you can. Then, as a submission share your code with us at `mohammad.nourinik@devolon.fi` and `mariam.vardanyan@devolon.fi`.

## Task 1
##### Api should support CRUD for stations and companies.

## Task 2
##### Implement endpoint which gets all stations.
* Within the radius of n kilometers from a point (latitude, longitude) ordered by distance.
* Including all the children stations in the tree, for the given company_id.


## Task 3
##### Write a simple, not fancy interface that will consume your API programmatically.

## Task 4
##### You will get extra 100 points if you will do all with TDD :D (it is optional though).
