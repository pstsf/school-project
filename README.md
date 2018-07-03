Example school project
curl -X POST --user 'school:password' -d 'grant_type=password&username=peter@example.com&password=password' http://localhost:8080/oauth/token
curl -i -H "Accept: application/json" -H "Authorization: Bearer 40fdcd59-548f-4f1c-89c7-ab0e16a34f6c" -X GET http://localhost:8080/school/people
 