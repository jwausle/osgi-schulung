# Change default log service level error to info

> Run `bnd.bnd`

Then will logs from the HelloWorld service logged.


cm:get org.osgi.service.log.admin# Change log level

> https://mnlipp.github.io/osgi-getting-started/ConfigurationAdmin.html

```
g! help cm:get
	get - show configuration for service
	   scope: cm
	   parameters:
	      String   The PID of the configuration

g! cm:get org.osgi.service.log.admin
	no configuration for pid 'org.osgi.service.log.admin' (use 'create' to create one)

g! inspect cap service 1
	org.apache.felix.log [1] provides:
	----------------------------------
	service; org.osgi.service.log.LogService, org.osgi.service.log.LoggerFactory with properties:
	   service.bundleid = 1
	   service.id = 6
	   service.scope = bundle
	   Used by:
	      SimpleBundle-logging-admin [12]
	      org.apache.felix.scr [9]
	      org.apache.felix.configadmin [8]

g! cm:create org.osgi.service.log.admin

g! cm:get org.osgi.service.log.admin
	Configuration for service (pid) "org.osgi.service.log.admin"
	(bundle location = ?)
	
	key           type               value
	------        ------             ------
	service.pid   java.lang.String   org.osgi.service.log.admin
	      
g! cm:put org.osgi.service.log.admin ROOT WARNING

g! cm:get org.osgi.service.log.admin
	Configuration for service (pid) "org.osgi.service.log.admin"
	(bundle location = ?)
	
	key           type               value
	------        ------             ------
	ROOT          java.lang.String   ERROR
	service.pid   java.lang.String   org.osgi.service.log.admin

g! cm:put org.osgi.service.log.admin ROOT INFO
```

