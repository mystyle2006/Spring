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
