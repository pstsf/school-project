# Example school project

### Prerequisites

* Git
* Maven
* Intellij Idea
* docker
* kdiff3

### Checkout, Build and Compile
git clone https://github.com/pstsf/school-project.git
git checkout develop
cd school-project
mvn clean compile
mvn clean package

### Configure Database
In order to run the application one needs to set the following database configuration properties:

-DDATABASE_URL=jdbc:postgresql://localhost:5432/kbdb 
-DDATABASE_USER=kbuser 
-DDATABASE_PASSWORD=kbpass

### Example Requests
curl -X POST --user 'school:password' -d 'grant_type=password&username=peter@example.com&password=password' http://localhost:8080/oauth/token
curl -i -H "Accept: application/json" -H "Authorization: Bearer 40fdcd59-548f-4f1c-89c7-ab0e16a34f6c" -X GET http://localhost:8080/school/people
 
 
 