A simple survey manager.

==============================================
            How to start a server
==============================================

Run commands from root directory:

1) mvn clean package

2) cd target

3) java -jar survey-0.0.1-SNAPSHOT.jar


==============================================
                    Usage
==============================================

Interaction with the server is based on HTTP request/response REST model.

1) Getting list of all available surveys: 
    GET http://localhost:8080/surveys

2) Add a new survey (administrator credentials required):
    POST http://localhost:8080/surveys?user=admin&password=admin
    Request body: 
        {
          "name" : "Survey 1",
          "startDate" : "2000-01-05",
          "endDate" : "2010-01-05",
          "description" : "Test Survey",
          "questions" :
          [
            {
              "type" : "TEXT",
              "text" : "What is your name???"
            }
          ]
        }

3) Delete a survey with id=123 (administrator credentials required):
    DELETE http://localhost:8080/surveys/123?user=admin&password=admin

4) Alter contents of a survey with id=123 (administrator credentials required):
    POST http://localhost:8080/surveys/123?user=admin&password=admin
    Request body: 
        {
          "name" : "New survey name",
          "startDate" : "2000-01-05",
          "endDate" : "2010-01-05",
          "description" : "Test Survey",
          "questions" :
          [
            {
              "type" : "TEXT",
              "text" : "What is your name???"
            },
            {
              "type" : "TEXT",
              "text" : "What is your age???"
            }
          ]
        }

5) Add a user's answer list for a particular survey:
    POST http://localhost:8080/completed_surveys
    Request body: 
         {
          "surveyId" : 2,
          "userId" : 1,
          "answers" :
          [
            {
              "questionId" : 2,
              "answer" : "Gleb"
            },
            {
              "questionId" : 3,
              "answer" : "32"
            }
          ]
        }

6) Get a list of all user's answered surveys (for user with id=1234):
    GET http://localhost:8080/completed_surveys/1234














