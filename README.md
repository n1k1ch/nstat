*Backend: JavaEE RESTEasy App*
====

Tested on [Wildfly 10.0.10.Final](http://wildfly.org/downloads/)

Create database
===
```sql
CREATE DATABASE IF NOT EXISTS `nstat` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nstat`;

CREATE TABLE IF NOT EXISTS `entry` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `amount` decimal(15,2) NOT NULL,
  `currency` char(50) NOT NULL,
  `comment` varchar(1000) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
```

Add MySQL driver to JBoss
===
Put `mysql-connector-java-6.0.3.jar` to `\wildfly-10.0.0.Final\modules\system\layers\base\com\mysql\main`

Put `module.xml` with following contents to the same directory:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-6.0.3.jar"/>
  </resources>
  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>
```

In `jboss-cli.bat`:

```bash
/subsystem=datasources/jdbc-driver=com.mysql:add(driver-name=com.mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.cj.jdbc.MysqlXADataSource)
```

Add datasource to JBoss
===

In `jboss-cli.bat`:

```bash
data-source add \
--name=NStatDS \
--driver-name=com.mysql \
--connection-url=jdbc:mysql://localhost:3306/nstat \
--jndi-name=java:jboss/datasources/NStatDS \
--jta=true \
--use-ccm=false \
--transaction-isolation=TRANSACTION_READ_COMMITTED \
--user-name=foo \
--password=bar \
--max-pool-size=25 \
--pool-prefill=true \
--valid-connection-checker-class-name=org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker \
--check-valid-connection-sql="SELECT 1" \
--background-validation=true \
--background-validation-millis=60000 \
--exception-sorter-class-name=org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter \
--blocking-timeout-wait-millis=5000 \
--idle-timeout-minutes=60
data-source enable --name=NStatDS
```


POSTMan collection
===
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/747aed0e2a412bfc682f)


---
