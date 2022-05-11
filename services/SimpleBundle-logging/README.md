# Registered services

```
bundle 7
...
RegisteredServices   [HelloWorld]
ServicesInUse        [LogService | LoggerFactory]
...
```

# service reference

```
servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null
000020   7 HelloWorld  
```

# service properties 

```
g! each (servicereferences io.github.mnl.osgiGettingStarted.loggingBundle.HelloWorld null) { $it properties }
[service.id=20, objectClass=[Ljava.lang.String;@4d7d6dde, service.scope=singleton, service.bundleid=7
```