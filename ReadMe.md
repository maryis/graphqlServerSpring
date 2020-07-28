this is a graphql-server based on "com.graphql-java-kickstart:graphql-spring-boot-starter"
by using this dependency, there is no need to write controller or datafetcher or ... .
- we define our schema in resources/graphql (can change path in properties file)
- we define GraphQLMutationResolver and GraphQLQueryResolver classes and methods for
each query/mutation/subscription operation.this classes should be annotated as Service (or ...)
- there is no need to write resolver for complex types such as courses
- graphql-spring automatically map each "localhost:9090/graphql" request to its resolver based on the query
in url's body
- Also it provides a "../graphiql" endpoint for testing the server


  I gathered some queries in resources/graphql/queries .
  my resolvers return fake data .
  a useful like: https://graphql-code-generator.com/
    
**API urls:**  localhost:9090/graphql
**testAPI urls:** localhost:9090/graphiql

------------------------


**ITIService:**

Is an API Gateway for TimeTabling project. 
It features:
  - GraphQL server for FrontEnd (done for courses and classes)
  - GraphQL client for Backend (needs a fake API from timetable-deakin)
  - Authentication (done based on http-basic)
 
Later, it can feature:
  - Access Control
  - Load Balancing
  - Request Routing
  - protocol translation
  - Custom API
  - Caching

**Note:** 
  - If the whole project is going to deploy on AWS,
  one alternative way is to use AWS API Gateway service instead (regarding security issue, I do not think so)
  - all data are available on *one endpoint*, so Authentication based on headers is not enough.
   based on graphQL site, we need authorization in business layer!
  - due to previous part, we need a mechanism for preventing DOS, that can be timeout, or ... .

two interesting things that worth noticing during design phase:
1- when the backend is GraphQL server, using apollo-link-state instead of Redux is recomended:
https://www.robinwieruch.de/react-apollo-link-state-tutorial/
although there are ways to have both of them in the React project.

2- common web security mechanisms that rely on headers, does not work for GraphQL servers!
Authorization in business layer is a must!
https://carvesystems.com/news/the-5-most-common-graphql-security-vulnerabilities/


