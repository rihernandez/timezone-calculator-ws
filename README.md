# timezone-calculator-ws

## REST API using springboot

- This RESFull has a simple endpoint that alow calculate time zones sending through POST HTTP protocol an object with the below format:

```
{
    "time": "14:49:52",
    "timezone": "+3"
}
```


-To download this proyect execute in the terminal :
```
git clone https://github.com/rihernandez/timezone-calculator-ws.git
```

- To install this proyect go to the `import` option in eclipse or STS , then after finish the procees. Proceed to execute via terminal or doing doble click over the proyect in the option `Run as` > `Maven clean` and then `Maven install`. This procees is going to generate a .war file in the under the target folder.

- Once running the proyect you'll can see the documentation of this API and respective helps, going to the browser and pasting the endpoint :
```
http://localhost:8080/swagger-ui.html
```
or 
```
http://localhost:8080/swagger-ui.html#/time-zone-calculator
```

- To make a request you have available these endpoints:
```
http://localhost:8080/api/v1/current-datetime
http://localhost:8080/api/v1/time-zone
```

[- To see this app running online click here](https://timezone-calculator-ws.herokuapp.com/swagger-ui.html#/time-zone-calculator)





