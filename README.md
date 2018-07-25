# Project Initialization Steps
Spring Boot initialization steps 

## <a name='toc'>Table of Contents</a>
- [Requirements](#req-1)
- [Staging Server Setup](#setup-1)
- [Port Setup](#port-2)
- [MySQL Setup](#mysql-3)
- [Logging Setup](#logging-3)



### [[⬆]](#toc) <a name="req-1">Requirements</a>
- java 8
- gradle 4.3.1


### [[⬆]](#toc) <a name="setup-1">Staging Server Setup</a>
Define in every yml file with active profiles.
 
 ** spring.profiles.active:dev
 
While generate a gradle build use with profile name.

 ** gradle build dev


### [[⬆]](#toc) <a name="port-2">Port Setup</a>
Port number can customized with below lines:

 ** spring.port:8090

### [[⬆]](#toc) <a name="mysql-3">MySQL Setup</a>
Add datasource related info in config file in yml config file.
When you're creating the column names create it without underscores. If you needs to separate use the camel case. If you follow this you can easily access from JPA repository without applying any queries by using as mentioned below:
 
 Supported keywords inside method names
 
 ** findByLastnameAndFirstname("suresh","venkat") which is equals to the query where x.lastname = ?1 and x.firstname = ?2  
 ** findByLastnameOrFirstname("suresh","venkat") which is equals to the query where x.lastname = ?1 or x.firstname = ?2
 
 for more follow the link: <a href="https://docs.spring.io/spring-data/jpa/docs/1.6.0.RELEASE/reference/html/jpa.repositories.html#transactions" target=_blank>link</a>
 
### [[⬆]](#toc) <a name="mysql-3">Logging Setup</a>
Mention the logging.file to logs the build, apis for errors, req & res and warnings

 ** logging.file: /var/log/spring/Spring.log