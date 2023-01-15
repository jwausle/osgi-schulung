cm:get org.osgi.service.log.admin# Change log level

> https://mnlipp.github.io/osgi-getting-started/ConfigurationAdmin.html

```
cm:get org.osgi.service.log.admin
Configuration for service (pid) "org.osgi.service.log.admin"
(bundle location = ?)

key           type               value
------        ------             ------
ROOT          java.lang.String   ERROR
service.pid   java.lang.String   org.osgi.service.log.admin

# cm:create org.osgi.service.log.admin
cm:put org.osgi.service.log.admin ROOT INFO

cm:put org.osgi.service.log.admin ROOT ERROR
```

