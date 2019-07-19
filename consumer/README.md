jvm启动参数：
-Dcsp.sentinel.dashboard.server=127.0.0.1:5080 -Dcsp.sentinel.api.port=8721

dashboard启动脚本：
java -Dserver.port=5080 -Dcsp.sentinel.dashboard.server=localhost:5080 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.6.2.jar