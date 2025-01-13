# Added 

> Run `bnd.bndrun`

```
g! each (servicereferences io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld null) { $it properties } 
[service.id=19, objectClass=[Ljava.lang.String;@7d3cf131, service.scope=singleton, service.bundleid=1]

g! inspect cap service 1
SimpleBundle-DM [1] provides:
-----------------------------
service; io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld with properties:
   service.bundleid = 1
   service.id = 19
   service.scope = singleton    

g! help dm

g! dm
[1] SimpleBundle-DM
 [0] io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld registered
    org.osgi.service.log.LogService service required available   
   
g! dm s '(objectclass=io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld)' 
[1] SimpleBundle-DM
 [0] io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld registered
    org.osgi.service.log.LogService service required available   

g! dm c '.*Hello.*'
[1] SimpleBundle-DM
 [0] io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld registered
    org.osgi.service.log.LogService service required available   
```

dm command doc: https://felix.apache.org/documentation/subprojects/apache-felix-dependency-manager/tutorials/leveraging-the-shell.html

## Trouble shouting when LogService not available

> Run `bndrun.bnd`

```
g! bundle 1
RegisteredServices   [HelloWorld]
ServicesInUse        [LogService | LoggerFactory]

g! stop 7
g! lb
    7|Resolved   |    1|Apache Felix Log Service (1.2.6)|1.2.6
    
g! bundle 1
RegisteredServices   []
ServicesInUse        null    

g! dm wtf
1 unregistered components found
-------------------------------
Please note that the following bundles are in the RESOLVED state:
 * [7] org.apache.felix.log
The following service(s) are missing: 
 * org.osgi.service.log.LogService for bundle SimpleBundle-DM

g! dm c '.*Hello.*'
[1] SimpleBundle-DM
 [0] io.github.mnl.osgiGettingStarted.simpleBundle.HelloWorld unregistered
    org.osgi.service.log.LogService service required unavailable   
```
