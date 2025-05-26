# coupon-sample


### kafka boot 
```bash
docker-compose up -d
```

### install ngrinder-controller
```bash
curl -L -o ngrinder-controller.war https://github.com/naver/ngrinder/releases/download/ngrinder-3.5.9-p1-20240613/ngrinder-controller-3.5.9-p1.war
```

### ngrinder boot (agent 필요에따라 조정)
```bash
cd ngrinder
```

```bash
docker-compose up -d --build --scale agent=3
```
