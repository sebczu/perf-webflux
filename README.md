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