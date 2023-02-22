INPUT & OUTPUT
==============

**USER SERVICE - END POINTS**
        
- [GET] http://localhost:8080/api/users
 
   *Get details of all users*
    ##
    
- [GET] http://localhost:8080/api/user/1

    *Get details of user with id 1*
    ##

- [POST] http://localhost:8080/api/user

   *Add a new user*
    
    In Request body - sample input object.
    
       {
          "userName": "Zack",
          "city": "CHENNAI",
          "departmentId": 2
       }
     ##

- [PUT] http://localhost:8080/api/user/1

   *Update a user* 
    
    In Request body - sample input object.
    
       {
          "userName": "Zack",
          "city": "CHENNAI",
          "departmentId": 2
        }
     ##


- [DELETE] http://localhost:8080/api/user/1

   *Delete the user with id 1*
    ##

###

**DEPARTMENT SERVICE - END POINTS**

- [GET] http://localhost:8080/api/departments

    *Get details of all department*
    ##
    
- [GET] http://localhost:8080/api/department/1
 
   *Get details of deaprtment with id 1*
    ##

- [POST] http://localhost:8080/api/department

   *Add a new department*
    
    
    In Request body - sample input object.
    
      {
        "departmentName": "ECE",
        "block": "AF2"
      }
     ##

- [PUT] http://localhost:8080/api/department/1

   *Update a department* 
    
    In Request body - sample input object.
    
      {
        "departmentName": "ECE",
        "block": "AF2"
      }
     ##


- [DELETE] http://localhost:8080/api/department/1

   *Delete the department with id 1*
    ##
