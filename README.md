# 01 springFirstEx
This contains a simple example of spring and how to create a project.

* How to create a project
File -> new Project -> type "spring" -> choose "Spring Lagacy" or "Spring Project"

# 02 Life Cycle and Scope of bean
This contains a life cycle and scope of Bean

* The Life Cycle of Bean 
  * By implementing the interfaces.
    * InitializingBean class
      - By overriding afterPropertiesSet(), we can initial a bean before creation.
    * DisposableBean class
      - By overriding destory(), we can destroy a bean after creation
   
  * By using annotation
    * @PostContruct
      - By annotating it, we can initial a bean before creation.
    * @PreDestory
      - By annotating it, we can destroy a bean after creation
      
* The scope of Bean
  * Default value : *singleton*

# 03 Environment Object
This contains a example of accessing properties with Environment.

# 04 Accessing Properties Directly without Environment Object
This contains examples of accessing properties without Environment Object directly

 * By using properties in Java code
 * By using properties in Xml code

# 05 Profile
This contains examples of the property, profile

* By using profile in Java code (@Profile(""))
* By using profile in Xml code (profile="")

# 06 AOP(Aspect Oriented Programming)
This contains a simple example of AOP

* Basic concept
 * AOP addresses the cross-cutting concerns which should be inserted into between your codes that is repeated in methods like logging and exceptions. So by using this technique, you can leave that stuffs out of your main code.
 
* Terms
  * Aspect : a commin function
  * advice :  a viewpoint of aspect
  * Jointpoint : a part of core functions
  * Pointcut : a part that advice is applied
  * Weaving : a behavior of applying advice to Jointpoint.

* the kinds of advice
  * <aop:before> : running advice before any method
  * <aop:around> : running advice before and after any method with excpetion
  * <aop:after-returning> : running advice after running normaly any method.
  * <aop:after-throwing> : running advice when throwing exception during any method
  * <aop:after> : running advice after any method with exception

# 07 AspectJ Pointcut Expression
This contains an example of Pointcut Expression.

* Rules
  * "*" : All
  * . : Current
  * .. : lager than 0
  
  * Execution
    * @pointcut("execution(public void get*(..))") // get method with public void
    * @pointcut("execution(* com.javalec.ex.*.*())") // All methods in com.javalec.ex package without parametors
    * @pointcut("execution(* com.javalec.ex..*.*())") // All methods in com.javalec.ex package & com.javalec.ex's sub-package without parametors
  * within
    * @Pointcut("within(com.javalec.ex.*)") // All method in this designated package.

# 08 Form Data
This contains how to deliver datas to Server and get datas from Server

* HttpServletRequest method
* @RequestParam method
* Data(command) Object method

## Korean Encoding
~~~
<filter>
 <filter-name>encodingFilter</filter-name>
 <filter-class>
  org.springframework.web.filter.CharacterEncodingFilter
 </filter-class>
 <init-param>
  <param-name>encoding</param-name>
  <param-value>UTF-8</param-value>
 </init-param>
 <init-param>
  <param-name>forceEncoding</param-name>
  <param-value>true</param-value>
 </init-param>
</filter>
<filter-mapping>
 <filter-name>encodingFilter</filter-name>
 <url-pattern>/*</url-pattern>
</filter-mapping>
~~~
