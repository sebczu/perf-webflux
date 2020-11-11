### **PERF-WEBFLUX**
**spring boot web + spring boot webflux**

#### 1. Run postgres
/docker
```bash
docker-compose up -d
```

#### 2. Measure webmvc
```bash
run webmvc application
curl -w "total: %{time_total}" -o /dev/null -s "localhost:8080/movies"
```
or 
```bash
run test: WebmvcApplicationTest
```

#### 3. Measure webflux
```bash
run webflux application
curl -w "total: %{time_total}" -o /dev/null -s "localhost:8080/movies"
```
or 
```bash
run test: WebfluxApplicationTest
```

#### 4. Performance test
run jmeter
```bash
(Test Plan) add -> threads -> thread group
Number of Threads (users): 20
Ramp-up periods (seconds): 2
(Thread Group) add -> Sampler -> Http request
Server Name or IP: localhost
Port Number: 8080
Http Request: GET
Path: /movies
(Thread Group) add -> Listener -> View Results in Table
```