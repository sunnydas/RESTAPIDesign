# RESTAPIDesign
An experiment in learning more about REST API design


The services are : 

1.) User Service (With illustration of bean validation)

Example:

get all users :
    http://localhost:8080/InnovRestTraining/api/rest/users
    
add users

POST /InnovRestTraining/api/rest/users HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: d9cc9a3f-3e9a-5450-3469-8979b021129e

{
	"fName" : "moby",
	"lName" : "dick",
	"primaryEmailAddress" : "moby.dick@test.com",
	"homeAddress": "22 nd street 5th avenue NY",
	"age": 32,
	"primayMobilePhoneNumber": "+1381820931289"
}

{
	"fName" : "moby",
	"lName" : "dick",
	"primaryEmailAddress" : "moby.dick@test.com",
	"homeAddress": "22 nd street 5th avenue NY",
	"age": 32,
	"primayMobilePhoneNumber": "+1381820931289"
}    


2.) Endurance sports service (With illustration of nested subresource)



GET /InnovRestTraining/api/rest/endurancesports/1/atheletes HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 5b5ccaae-9930-f9b3-69b1-47d01a766cd9


POST /InnovRestTraining/api/rest/endurancesports/1/athelete HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: df73737c-505c-58c2-f365-9b3fa60f52f5

{
	"fName" : "Scott",
	"lName" : "Jurek",
	"location" : "Boulder,CO",
	"club" : "Solo",
	"gender" : "MALE",
	"rank" : 1
}

*subresources are tricky

PUT /InnovRestTraining/api/rest/endurancesports/1/athelete/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: c47c520f-193a-406f-e0d1-9af3b0338eed

{
    "activityId": "1",
    "age": 35,
    "atheleteId": "2",
    "club": "Solo",
    "fName": "Scott",
    "gender": "MALE",
    "lName": "fisher",
    "location": "Boulder,CO",
    "rank": 1
}


3.) Long running task simulation

GET /InnovRestTraining/api/rest/heavylifting/fetch HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: c3432b4e-91af-a2e2-f3c6-6f85614b78c2

4.)Cache Control Service
GET /InnovRestTraining/api/rest/metadata HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 304f6eaf-6b2d-4521-af67-a582122028b7

5.) Conditional request processing using if not modified since

GET /InnovRestTraining/api/rest/daytemperature HTTP/1.1
Host: localhost:8080
If-Modified-Since: Monday, 23 Oct 2017 18:45:19 GMT
Cache-Control: no-cache
Postman-Token: a8a420dd-45cc-cbae-ca79-3605fdbda2d3

6.) Conditional request processing using eTags (If-None-Match)

GET /InnovRestTraining/api/rest/daytemperature/tagged HTTP/1.1
Host: localhost:8080
If-None-Match: "1192850254"
Cache-Control: no-cache
Postman-Token: 3e8fcc6f-199d-a128-09a2-067b98101aba


7.) A simple illustration of pagination:

GET /InnovRestTraining/api/rest/userinfo?offset=900&amp;limit=100 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 36c2e209-5cab-2609-870b-b6a580a97ea2


8.) Simple illustration of HATEOAS with pagination

GET /InnovRestTraining/api/rest/userinfo/hateoas?offset=10&amp;limit=10 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: a8cbdd2f-2900-c83d-c543-0d7a264db220


9.) Task tracker 

GET /InnovRestTraining/api/rest/tasks HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 8c4f5c0f-351c-d4cb-7763-f96eda8fa0ae


POST /InnovRestTraining/api/rest/tasks HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: d16fbfcf-b346-aa5f-e0de-da43cbebeaaa

{
	"taskName" : "todoTask1",
	"taskDescription": "Some things to do2"
}

GET /InnovRestTraining/api/rest/tasks/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: ce54c28c-c6c9-ce19-db38-4be2fe1d6101


PUT /InnovRestTraining/api/rest/tasks/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 44206bd5-c371-c778-26b9-f628db8ddedf

{
    "taskDescription": "Some things to do",
    "taskId": "1",
    "taskName": "todoTask2",
    "taskStatus": "COMPLETED"
}

GET /InnovRestTraining/api/rest/tasks?offset=0&amp;limit=10&amp;taskstatus=COMPLETED HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 8795f5a6-7257-6211-459c-18afdc76ed21

DELETE /InnovRestTraining/api/rest/tasks/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: b35b2d82-f984-8028-a6c4-05090221fac1
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW