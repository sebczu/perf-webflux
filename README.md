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
**Test 1 (all movies/5 user)**
```bash
(Test Plan) add -> threads -> thread group
Number of Threads (users): 5
Ramp-up periods (seconds): 1
Loop Count: 5
(Thread Group) add -> Sampler -> Http request
Server Name or IP: localhost
Port Number: 8080
Http Request: GET
Path: /movies
(Thread Group) add -> Listener -> View Results in Table
```
```bash
Result for Webflux:
Average response time: 22.287s
```
![Image](monitor/webflux_5req_allMovies.png)
```bash
Result for Webmvc:
Average response time: 8.740s
```
![Image](monitor/webmvc_5req_allMovies.png)
**Test 2 (all movies/10 user)**
```bash
(Test Plan) add -> threads -> thread group
Number of Threads (users): 10
Ramp-up periods (seconds): 1
Loop Count: 5
(Thread Group) add -> Sampler -> Http request
Server Name or IP: localhost
Port Number: 8080
Http Request: GET
Path: /movies
(Thread Group) add -> Listener -> View Results in Table
```
```bash
Result for Webflux:
Average response time: 37.767s
```
![Image](monitor/webflux_10req_allMovies.png)
```bash
Result for Webmvc:
Average response time: 18.762s
```
![Image](monitor/webmvc_10req_allMovies.png)