# Added 

- `bnd.bndrun`

# Use cases 

1) Inspect caps

```
g! inspect cap service
org.apache.felix.framework [0] provides:
----------------------------------------
service; org.osgi.service.resolver.Resolver with properties:
   service.bundleid = 0
   service.id = 1
   service.scope = singleton
...

g! inspect cap osgi.wiring.package
org.apache.felix.framework [0] provides:
----------------------------------------
osgi.wiring.package; org.osgi.framework 1.10.0 required by:
   de.mnl.osgi.coreutils [5]
   org.apache.felix.configadmin [8]
   org.apache.felix.metatype [9]
   org.apache.felix.gogo.command [2]
   org.apache.felix.log [1]
   SimpleBundle-DM [10]
   de.mnl.osgi.osgi2jul [6]
...      
```

2) Service references

```
g! servicereferences org.osgi.service.startlevel.StartLevel null
000003   0 StartLevel                               

g! each (servicereferences org.osgi.service.startlevel.StartLevel null) { $it properties }
[service.id=3, objectClass=[Ljava.lang.String;@1957779c, service.scope=singleton, service.bundleid=0]
```

