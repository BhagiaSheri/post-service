# Post Service

Web Application Archietcture (WAA) course day to day progress in a form of post-service project.

## Basic use-case and requirements of project can be found in below link:

[WAA Labs / Requirements]([https://github.com/facebook/create-react-app](https://github.com/BhagiaSheri/post-service/tree/main/src/main/java/edu/miu/waa/postservice/requirements)).

## Description:

post-service is a monolith project defining the domain of post related stuff. There are potential 4 sub-domains in this service and 2 cross-curring domains, which are:
<br />
1. Post
2. Comment
3. User
4. Role
5. Logger
6. Exeption 
<br /> -> 1 to 4 domains are self explanatory defining the flow that any USER with specific ROLE will be able to create POST and can COMMENT on specific post. 
<br /> -> Logger domain is used for audit purposes. On any method call, the audit details have been captured in Logger for that specific request.
<br /> -> And Exception domain is used for capturing the flow of any exception which occurs along exception root cause.

## How to run post-service?
1. Simply need to run this [docker-compose]([https://github.com/BhagiaSheri/post-service/blob/main/docker-compose.yml]) file and post-db container will be up.
2. Run the project via any IDE (preferably use intelliJ)
