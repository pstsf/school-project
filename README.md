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
 
### Development process example
docker ps
docker-compose up -d
cd school-project
git status
git checkout -b implement.user.search 

#### Recreate Database
docker-compose down
docker-compose up

### Git

* By merge conflict google how to resolve, for example with kdiff3
* To create a new branch based on the branch which is current: git checkout -b new.branch
* To add changes to the local git staging: git add . -A
* To commit staged stuff: git commit -m"My Message"
* To undo a commit do: git revert 
* To stash changes: git stash
* To reapply stashed changes to the current branch: git stash apply
* To switch to existing branch git checkout branch.name
* Before doing anything refresh the meta information: git fetch -p origin
