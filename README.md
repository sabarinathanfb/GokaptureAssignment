{
  "info": {
    "name": "Blog API",
    "description": "API Documentation for Blog API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Create Task",
      "request": {
                  "method": "POST",
                  "header": [
                            {
                            
                            	"key": "Content-Type",
                              "value": "application/json"
                            }
                  ],
					        "body": {
					                  "mode": "raw",
					                  "raw": "{
					                            "title": "Sample Task",
					                            "description":"This is a sample task",
					                            "priority": "HIGH",
					                            "status":"PENDING",
					                            "dueDate":"2024-12-31",
					                            "userId": 1
					                          }"
					                },
					        "url": {
					                  "raw": "http://localhost:8080/api/tasks",
					                  "protocol": "http",
					                  "host": ["localhost"],
					                  "port": "8080",
					                  "path": ["api","tasks"]
					        			}
      },
      "response": []
    },


 
    {
      "name": "Get All Tasks",
      "request": {
					        "method": "GET",
					        "header": [],
					        "url": {
								          "raw": "http://localhost:8080/api/tasks",
								          "protocol": "http",
								          "host": ["localhost"],
								          "port": "8080",
								          "path": ["api","tasks"]
        						}
      },
      "response": []
    },

	
    {
      "name": "Update Task",
      "request": {
						        "method": "PUT",
						        "header": [
						          {
						            "key": "Content-Type",
						            "value": "application/json"
						          }
						        ],
						        "body": {
						          "mode": "raw",
						          "raw": "{
															"title": "Updated Task",
															"description":"This is an updated task", 
															"priority": "MEDIUM",  
															"status": "COMPLETED",  
															"dueDate": "2024-12-31"}"
						        },
						        "url": {
						          "raw": "http://localhost:8080/api/tasks/1",
						          "protocol": "http",
						          "host": ["localhost"],
						          "port": "8080",
											"path": [	"api","tasks","1"]
						        }
      },
      "response": []
    },
    {
      "name": "Delete Task",
      "request": {
							        "method": "DELETE",
							        "header": [],
							        "url": {
							          "raw": "http://localhost:8080/api/tasks/1",
							          "protocol": "http",
							          "host": ["localhost"],
							          "port": "8080",
							          "path": ["api","tasks","1"]
							        }
      },
      "response": []
    },
    {
      "name": "Search Tasks",
      "request": {
								        "method": "GET",
								        "header": [],
								        "url": {
								          "raw": "http://localhost:8080/api/tasks/search?searchTerm=sample",
								          "protocol": "http",
								          "host": ["localhost"],
								          "port": "8080",
								          "path": ["api","tasks","search"],
								          "query": [
											            {
											              "key": "searchTerm",
											              "value": "sample"
											            }
								          ]
        }
      },
      "response": []
    },
    {
      "name": "Filter Tasks by Status",
										      "request": {
										        "method": "GET",
										        "header": [],
										        "url": {
										          "raw": "http://localhost:8080/api/tasks/filter/status?status=PENDING",
										          "protocol": "http",
										          "host": ["localhost"],
										          "port": "8080",
										          "path": ["api","tasks","filter","status"],
										          "query": [
										            {
										              "key": "status",
										              "value": "PENDING"
										            }
										          ]
										        }
      },
      "response": []
    },
    {
      "name": "Filter Tasks by Priority",
      "request": {
									        "method": "GET",
									        "header": [],
									        "url": {
									          "raw": "http://localhost:8080/api/tasks/filter/priority?priority=HIGH",
									          "protocol": "http",
									          "host": ["localhost"],
									          "port": "8080",
									          "path": ["api","tasks","filter","priority"],
									          "query": [
									            {
									              "key": "priority",
									              "value": "HIGH"
									            }
									          ]
									        }
      },
      "response": []
    },
    {
      "name": "Filter Tasks by Due Date",
      "request": {
									        "method": "GET",
									        "header": [],
									        "url": {
									          "raw": "http://localhost:8080/api/tasks/filter/dueDate?dueDate=2024-12-31",
									          "protocol": "http",
									          "host": ["localhost"],
									          "port": "8080",
									          "path": ["api","tasks","filter","dueDate"],
									          "query": [
									            {
									              "key": "dueDate",
									              "value": "2024-12-31"
									            }
									          ]
									        }
									      },
      "response": []
    }
  ]
}
