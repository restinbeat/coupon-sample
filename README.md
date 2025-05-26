# coupon-sample


### Kafka boot 
```bash
docker-compose up -d
```

### Ngrinder boot (agent 필요에따라 조정)
```bash
cd ngrinder
docker-compose up -d --build --scale agent=3
```
