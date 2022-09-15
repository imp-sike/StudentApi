# Basic Example of CRUD API using Spring Boot

Available Endpoint:  
1. GET  /students   => Gets all the available students

2. POST /students ({"firstName": "", "lastName": "", "emailId": ""}) 
   => Creates a new students in database

3. GET  /student/{id}  => Get a specific student detail via supplied ID

4. DELETE /student/{id} => Deletes  a specific student detail via supplied ID

5. PUT /student/{id} ({"firstName": "", "lastName": "", "emailId": ""}) 
   => updates the datail of existing students in database