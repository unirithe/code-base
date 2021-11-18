# 运行环境

JDK 1.8 + Flume 1.9

# 作用以及使用
作用：简单的数据清洗: 提供Flume集群一个拦截器执行的Jar包程序，可以过滤掉非法JSON数据的文本

使用：使用Maven打包后会出现两种jar包，一种是with-dependency后缀带有依赖包

第一步，将该jar包放在Flume集群所有节点的flume目录下的lib文件夹

第二步，指定flume拦截器的执行类，在所有集群节点flume目录下的conf文件夹中新建flume启动的配置文件比如 `file-flume-kafka.conf`，以下是集群测试的有效参考配置，可当做参考

```xml
# 定义组件
a1.sources=r1
a1.channels=c1

#配置source (taildirsouces)
a1.source.r1.type=TAILDIR
a1.sources.r1.filegroups=f1
a1.sources.r1.filegroups.f1=/usr/local/log/data.*

a1.sources.r1=/usr/local/flume/taildir_position.json

#配置拦截器(ETL数据清晰，判断JSON是否完整)
a1.sources.r1.interceptors=i1
a1.sources.r1.interceptors.i1.type=com.uni.flume.interceptor.ETLInterceptor$Build

# 配置Chanel
a1.channels.c1.type=org.apache.flume.channel.kafka.KafkaChannel
a1.channels.c1.kafka.bootstrap.servers=hadoop101:9092,hadoop102:9092
a1.channels.c1.kafka.topic=topic_log
a1.channels.c1.parseAsFlumeEvent=False
# 配置sink （无）

# 拼接组件
a1.sources.r1.channels=c1
```
# pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>FlumeInterceptor</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.apache.flume</groupId>
            <artifactId>flume-ng-core</artifactId>
            <version>1.9.0</version>
            <scope>provided</scope>
        </dependency>

        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.62</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                    <descriptorRefs>
                        <descriptorRef>jar-with-dependencies</descriptorRef>
                    </descriptorRefs>
                </configuration>
                <executions>
                    <execution>
                        <id>make-assembly</id>
                        <phase>package</phase>
                        <goals>
                            <goal>single</goal>
                        </goals>
                    </execution>
                </executions>
                <version>3.3.0</version>
            </plugin>
        </plugins>

    </build>
</project>
```
# ETLInterceptor.java
```java
package com.uni.flume.interceptor;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

public class ETLInterceptor implements Interceptor {

    @Override
    public void initialize() {}
    @Override
    public void close() {}

    @Override
    public Event intercept(Event event) {

        byte[] body = event.getBody();
        String log = new String(body, StandardCharsets.UTF_8);

        return JSONUtils.isValidate(log) == true ? event : null;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        Iterator<Event> iterator = list.iterator();
        while(iterator.hasNext()){
            Event next = iterator.next();
            if(intercept(next) == null){
                iterator.remove();
            }
        }
        return list;
    }

    public static class Builder implements Interceptor.Builder{

        @Override
        public Interceptor build() { return new ETLInterceptor();  }

        @Override
        public void configure(Context context) {}
    }
}

```

# JSONUtils.java
```java
package com.uni.flume.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;

public class JSONUtils {

    // 验证数据是否为 JSON
    public static boolean isValidate(String log) {
        try{
            JSON.parse(log);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}

```
